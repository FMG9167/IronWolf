package io.github.FMG9167.IronWolf;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IronWolfEntityRenderState extends LivingEntityRenderState {
    public int armorLayer;
    public final AnimationState walkingAnimationState = new AnimationState();
    public IronWolfEntity entity;
    public float delta;

//    public IronWolfEntityRenderState(IronWolfEntity entity, float delta) {
//        this.entity = entity;
//        this.delta = delta;
//        this.age = entity.age + delta;
//    }
}
