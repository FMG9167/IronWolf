package io.github.FMG9167.IronWolf;

import io.github.FMG9167.IronWolf.client.IronWolfClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class IronWolfEntityRenderer extends MobEntityRenderer<IronWolfEntity, IronWolfEntityRenderState, IronWolfEntityModel> {

    private static final Identifier TEXTURE = Identifier.of(IronWolf.MOD_ID, "textures/entity/ironwolf.png");

    public IronWolfEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new IronWolfEntityModel(context.getPart(IronWolfClient.MODEL_IRON_WOLF_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(IronWolfEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public IronWolfEntityRenderState createRenderState() {
        return new IronWolfEntityRenderState();
    }

    @Override
    public void updateRenderState(IronWolfEntity entity, IronWolfEntityRenderState state, float f) {
        super.updateRenderState(entity, state, f);
        state.armorLayer = entity.getArmorLayer();
    }
}
