package io.github.FMG9167.IronWolf;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class IronWolfEntityModel extends EntityModel<IronWolfEntityRenderState> {
    private final ModelPart armorLayer1;
    private final ModelPart armorLayer2;
    private final ModelPart helmet;
    private final Animation walkingAnimation;
    public IronWolfEntityModel(ModelPart root) {
        super(root);
        this.armorLayer1 = root.getChild("armorLayer1");
        this.helmet = armorLayer1.getChild("helmet");
        this.armorLayer2 = root.getChild("armorLayer2");
        this.walkingAnimation = IronWolfAnimations.WALK.createAnimation(root);
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData hindLeg2 = modelPartData.addChild("hindLeg2", ModelPartBuilder.create().uv(57, 33).cuboid(5.0F, 2.0F, 1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(46, 24).cuboid(6.0F, -2.0F, -2.0F, 2.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 14.0F, 10.0F));

        ModelPartData hindLeg1 = modelPartData.addChild("hindLeg1", ModelPartBuilder.create().uv(57, 33).cuboid(-8.0F, 2.0F, 1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(46, 24).cuboid(-8.0F, -2.0F, -2.0F, 2.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 14.0F, 10.0F));

        ModelPartData head = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 44).cuboid(-5.0F, -5.0F, -7.0F, 10.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(46, 58).cuboid(2.0F, -9.0F, -3.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(54, 58).cuboid(-5.0F, -9.0F, -3.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(34, 44).cuboid(-2.0F, 0.0F, -12.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 7.0F, -8.0F));

        ModelPartData armorLayer1 = modelPartData.addChild("armorLayer1", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData helmet = armorLayer1.addChild("helmet", ModelPartBuilder.create().uv(38, 6).cuboid(-6.0F, -6.0F, -7.0F, 12.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(38, 6).cuboid(-6.0F, 4.0F, -7.0F, 12.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(27, 53).cuboid(-6.0F, -5.0F, -7.0F, 1.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(27, 53).cuboid(5.0F, -5.0F, -7.0F, 1.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, -6.0F, -8.0F, 12.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, -6.0F, 0.0F, 12.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, 0.0F, -8.0F, 12.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(-1.0F, -2.0F, -8.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(-6.0F, -2.0F, -8.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(5.0F, -2.0F, -8.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -17.0F, -8.0F));

        ModelPartData chestplate = armorLayer1.addChild("chestplate", ModelPartBuilder.create().uv(29, 63).cuboid(-6.0F, -8.0F, -1.0F, 12.0F, 1.0F, 14.0F, new Dilation(0.0F))
                .uv(29, 63).cuboid(-6.0F, -19.0F, -1.0F, 12.0F, 1.0F, 14.0F, new Dilation(0.0F))
                .uv(10, 64).cuboid(6.0F, -19.0F, -1.0F, 1.0F, 12.0F, 14.0F, new Dilation(0.0F))
                .uv(10, 64).cuboid(-7.0F, -19.0F, -1.0F, 1.0F, 12.0F, 14.0F, new Dilation(0.0F))
                .uv(55, 16).cuboid(-7.0F, -19.0F, 13.0F, 14.0F, 12.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

        ModelPartData armorLayer2 = modelPartData.addChild("armorLayer2", ModelPartBuilder.create().uv(43, 54).cuboid(7.0F, -19.0F, -10.0F, 1.0F, 11.0F, 24.0F, new Dilation(0.0F))
                .uv(43, 54).cuboid(-8.0F, -19.0F, -10.0F, 1.0F, 11.0F, 24.0F, new Dilation(0.0F))
                .uv(45, 31).cuboid(-8.0F, -20.0F, -10.0F, 16.0F, 1.0F, 24.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData frontLeg1 = modelPartData.addChild("frontLeg1", ModelPartBuilder.create().uv(57, 33).cuboid(-6.0F, 1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 15.0F, -5.0F));

        ModelPartData frontLeg2 = modelPartData.addChild("frontLeg2", ModelPartBuilder.create().uv(57, 33).cuboid(3.0F, 1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 15.0F, -5.0F));

        ModelPartData mainBody = modelPartData.addChild("mainBody", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -18.0F, -1.0F, 12.0F, 10.0F, 14.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-7.0F, -19.0F, -10.0F, 14.0F, 11.0F, 9.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 24.0F, 0.0F));

        ModelPartData tail = modelPartData.addChild("tail", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 8.0F, 12.0F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(42, 43).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(IronWolfEntityRenderState state) {
        super.setAngles(state);
        int armorLayer = state.armorLayer;
        IronWolfEntity wolf = state.entity;
        ModelPart root = this.getRootPart();

        armorLayer1.visible = armorLayer >= 1;
        armorLayer2.visible = armorLayer == 2;

//        this.getRootPart().getChild("head").yaw = ironWolfEntityRenderState.relativeHeadYaw * (float) (Math.PI / 360.0);
//        this.getRootPart().getChild("armorLayer1").getChild("helmet").yaw = ironWolfEntityRenderState.relativeHeadYaw * (float) (Math.PI / 360.0);
//        this.getRootPart().getChild("head").pitch = ironWolfEntityRenderState.pitch * (float) (Math.PI / 360.0);
//        this.getRootPart().getChild("armorLayer1").getChild("helmet").pitch = ironWolfEntityRenderState.pitch * (float) (Math.PI / 360.0);
//
//        this.walkingAnimation.apply(ironWolfEntityRenderState.walkingAnimationState, ironWolfEntityRenderState.age);

        Vec3d velocity = wolf.getVelocity();
        float horizontalSpeed = (float)Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
        horizontalSpeed = Math.min(horizontalSpeed*4.0f, 1.0f);
//        float horizontalSpeed = wolf.getMovementSpeed();

        float speedBoost = 0.3f + (2-armorLayer) * 0.05f;
        float time = state.age * (1.5f + speedBoost);
        float stride = horizontalSpeed * 1.2f;

        root.getChild("frontLeg1").pitch = MathHelper.cos(time) * stride;
        root.getChild("hindLeg2").pitch = MathHelper.cos(time) * stride;

        root.getChild("frontLeg2").pitch = MathHelper.cos(time + MathHelper.PI) * stride;
        root.getChild("hindLeg1").pitch = MathHelper.cos(time + MathHelper.PI) * stride;

        root.getChild("mainBody").pitch = MathHelper.cos(time * 2.0f) * 0.05f * stride;

        float headYaw = MathHelper.lerp(
                state.delta,
                wolf.lastHeadYaw,
                wolf.headYaw
        );
        float bodyYaw = MathHelper.lerp(
                state.delta,
                wolf.lastBodyYaw,
                wolf.bodyYaw
        );

        float relativeYaw = MathHelper.wrapDegrees(headYaw - bodyYaw);

        root.getChild("head").yaw = relativeYaw * MathHelper.RADIANS_PER_DEGREE;
        root.getChild("armorLayer1").getChild("helmet").yaw = relativeYaw * MathHelper.RADIANS_PER_DEGREE;

//        root.getChild("head").yaw = wolf.getHeadYaw() * MathHelper.RADIANS_PER_DEGREE;
        root.getChild("head").pitch = wolf.getPitch() * MathHelper.RADIANS_PER_DEGREE;
//        root.getChild("armorLayer1").getChild("helmet").yaw = wolf.getHeadYaw() * MathHelper.RADIANS_PER_DEGREE;
        root.getChild("armorLayer1").getChild("helmet").pitch = wolf.getPitch() * MathHelper.RADIANS_PER_DEGREE;

        root.getChild("tail").yaw = MathHelper.cos(state.age * 0.15f * speedBoost) * 0.25f;

        if (horizontalSpeed < 0.05f) {
            float idle = MathHelper.cos(state.age * 0.05f) * 0.03f;
            root.getChild("mainBody").pitch += idle;
            root.getChild("head").pitch += idle*0.4f;
            root.getChild("armorLayer1").getChild("helmet").pitch += idle*0.4f;
        }
    }
}