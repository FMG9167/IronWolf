package io.github.FMG9167.IronWolf;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityAttachments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;

import java.util.Objects;

public class IronWolfEntity extends HostileEntity {
    private float armorDamage = 0;

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(IronWolfEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Integer> ARMOR_LAYER =
            DataTracker.registerData(IronWolfEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public IronWolfEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void setAttacking(boolean attacking) { this.dataTracker.set(ATTACKING, attacking); }

    @Override
    public boolean isAttacking() { return this.dataTracker.get(ATTACKING); }

    public void setArmorLayer(Integer armorLayer) { this.dataTracker.set(ARMOR_LAYER, armorLayer); }
    public Integer getArmorLayer() { return this.dataTracker.get(ARMOR_LAYER); }
    public void armorLayerBreaks() { setArmorLayer(getArmorLayer() - 1); }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
        builder.add(ARMOR_LAYER, 2);
    }

    private void handleArmorHit(ServerWorld world, DamageSource source, float amount) {
        if (source.getAttacker() instanceof PlayerEntity player && player.getMainHandStack().isIn(ItemTags.AXES)) {
            armorDamage += amount * 1.5f;
        } else {
            armorDamage += amount;
        }

        if (armorDamage >= 8.0f * getArmorLayer()) {
            armorDamage = 0;
            breakArmorLayer(world);
        }

        this.playSound(SoundEvents.BLOCK_ANVIL_HIT, 1.0f, 1.1f);

        world.spawnParticles(
                ParticleTypes.CRIT,
                getX(), getBodyY(0.5), getZ(),
                12, 0.3, 0.3, 0.3, 0.1
        );
    }

    private void breakArmorLayer(ServerWorld world) {
        setArmorLayer(getArmorLayer() - 1);

        updateSpeedAndModel();

        this.playSound(SoundEvents.BLOCK_ANVIL_BREAK, 1.2f, 0.9f);

        world.spawnParticles(
                ParticleTypes.CRIT,
                getX(), getBodyY(0.5), getZ(),
                20,0.4,0.4,0.4,0.2
        );
    }

    private void updateSpeedAndModel() {
        Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED)).setBaseValue(0.3 + (2 - getArmorLayer()) * 0.06);


    }

    @Override
    public void applyDamage(ServerWorld world, DamageSource source, float amount) {
        if (this.isInvulnerableTo(world, source)) return;

        if (getArmorLayer() > 0) {
            handleArmorHit(world, source, amount);
        }
        super.applyDamage(world, source, amount);

    }

    @Override
    public void writeCustomData(WriteView view) {
        super.writeCustomData(view);
        view.putBoolean("Attacking", this.isAttacking());
        view.putInt("ArmorLayer", this.getArmorLayer());
    }

    @Override
    public void readCustomData(ReadView view) {
        super.readCustomData(view);
        this.setAttacking(view.getBoolean("Attacking", false));
        this.setArmorLayer(view.getInt("ArmorLayer", 2));
    }
}
