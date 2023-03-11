package net.theclient.hacks.mixin;

import net.minecraft.client.render.MapRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.map.MapState;
import net.theclient.hacks.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapRenderer.class)
public class mapRenderMixin {

    @Inject(method = "draw", at = @At("HEAD"), cancellable = true)
    private void disableMapRendering(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int id, MapState state, boolean hidePlayerIcons, int light, CallbackInfo ci) {
        if(Main.isMapExploit) {
            ci.cancel();
        }
    }
}
