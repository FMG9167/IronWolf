package io.github.FMG9167.IronWolf.client;

import io.github.FMG9167.IronWolf.IronWolf;
import io.github.FMG9167.IronWolf.IronWolfEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class IronWolfClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_IRON_WOLF_LAYER = new EntityModelLayer(Identifier.of(IronWolf.MOD_ID, "ironwolf"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(IronWolf.IRON_WOLF, IronWolfEntityRenderer::new);
    }
}
