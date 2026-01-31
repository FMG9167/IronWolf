package io.github.FMG9167.IronWolf;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.include.com.google.common.collect.ImmutableList;

public class IronWolfEntityModel extends EntityModel<IronWolfEntityRenderState> {
    private final ModelPart ent;
    private final ModelPart armorLayer1;
    private final ModelPart armorLayer2;
    public IronWolfEntityModel(ModelPart root) {
        super(root);
        this.ent = root.getChild("ent");
        this.armorLayer1 = this.ent.getChild("armorLayer1");
        this.armorLayer2 = this.ent.getChild("armorLayer2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData ent = modelPartData.addChild("ent", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 24.0F, 0.0F));

        ModelPartData hindLeg2 = ent.addChild("hindLeg2", ModelPartBuilder.create().uv(57, 33).cuboid(5.0F, 2.0F, 1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(46, 24).cuboid(6.0F, -2.0F, -2.0F, 2.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -10.0F, 10.0F));

        ModelPartData hindLeg1 = ent.addChild("hindLeg1", ModelPartBuilder.create().uv(57, 33).cuboid(-8.0F, 2.0F, 1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F))
                .uv(46, 24).cuboid(-8.0F, -2.0F, -2.0F, 2.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -10.0F, 10.0F));

        ModelPartData head = ent.addChild("head", ModelPartBuilder.create().uv(0, 44).cuboid(-5.0F, -22.0F, -15.0F, 10.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(46, 58).cuboid(2.0F, -26.0F, -11.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(54, 58).cuboid(-5.0F, -26.0F, -11.0F, 3.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(34, 44).cuboid(-2.0F, -17.0F, -20.0F, 4.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData armorLayer1 = ent.addChild("armorLayer1", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData helmet = armorLayer1.addChild("helmet", ModelPartBuilder.create().uv(38, 6).cuboid(-6.0F, -23.0F, -15.0F, 12.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(38, 6).cuboid(-6.0F, -13.0F, -15.0F, 12.0F, 1.0F, 7.0F, new Dilation(0.0F))
                .uv(27, 53).cuboid(-6.0F, -22.0F, -15.0F, 1.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(27, 53).cuboid(5.0F, -22.0F, -15.0F, 1.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, -23.0F, -16.0F, 12.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, -23.0F, -8.0F, 12.0F, 4.0F, 1.0F, new Dilation(0.0F))
                .uv(38, 0).cuboid(-6.0F, -17.0F, -16.0F, 12.0F, 5.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(-1.0F, -19.0F, -16.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(-6.0F, -19.0F, -16.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(43, 0).cuboid(5.0F, -19.0F, -16.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData chestplate = armorLayer1.addChild("chestplate", ModelPartBuilder.create().uv(29, 63).cuboid(-6.0F, -8.0F, -1.0F, 12.0F, 1.0F, 14.0F, new Dilation(0.0F))
                .uv(29, 63).cuboid(-6.0F, -19.0F, -1.0F, 12.0F, 1.0F, 14.0F, new Dilation(0.0F))
                .uv(10, 64).cuboid(6.0F, -19.0F, -1.0F, 1.0F, 12.0F, 14.0F, new Dilation(0.0F))
                .uv(10, 64).cuboid(-7.0F, -19.0F, -1.0F, 1.0F, 12.0F, 14.0F, new Dilation(0.0F))
                .uv(55, 16).cuboid(-7.0F, -19.0F, 13.0F, 14.0F, 12.0F, 1.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData armorLayer2 = ent.addChild("armorLayer2", ModelPartBuilder.create().uv(43, 54).cuboid(7.0F, -19.0F, -10.0F, 1.0F, 11.0F, 24.0F, new Dilation(0.0F))
                .uv(43, 54).cuboid(-8.0F, -19.0F, -10.0F, 1.0F, 11.0F, 24.0F, new Dilation(0.0F))
                .uv(45, 31).cuboid(-8.0F, -20.0F, -10.0F, 16.0F, 1.0F, 24.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData frontLeg1 = ent.addChild("frontLeg1", ModelPartBuilder.create().uv(57, 33).cuboid(-6.0F, 1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -9.0F, -5.0F));

        ModelPartData frontLeg2 = ent.addChild("frontLeg2", ModelPartBuilder.create().uv(57, 33).cuboid(3.0F, 1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -9.0F, -5.0F));

        ModelPartData mainBody = ent.addChild("mainBody", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -18.0F, -1.0F, 12.0F, 10.0F, 14.0F, new Dilation(0.0F))
                .uv(0, 24).cuboid(-7.0F, -19.0F, -10.0F, 14.0F, 11.0F, 9.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData tail = ent.addChild("tail", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, -16.0F, 12.0F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(42, 43).cuboid(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(IronWolfEntityRenderState ironWolfEntityRenderState) {
        int armorLayer = ironWolfEntityRenderState.armorLayer;

        armorLayer1.visible = armorLayer >= 1;
        armorLayer2.visible = armorLayer == 2;
    }
}