package io.github.FMG9167.IronWolf;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class IronWolf implements ModInitializer {
    public static final String MOD_ID = "ironwolf";

    public static final EntityType<IronWolfEntity> IRON_WOLF = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(MOD_ID, "iron_wolf"),
            EntityType.Builder.create(IronWolfEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.9f,0.9f)
                    .build(RegistryKey.of(Registries.ENTITY_TYPE.getKey(), Identifier.of(MOD_ID, "iron_wolf")))
    );

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(IRON_WOLF, IronWolfEntity.createIronWolfEntityAttributes());
    }
}
