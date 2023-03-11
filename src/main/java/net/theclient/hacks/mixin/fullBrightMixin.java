package net.theclient.hacks.mixin;

import net.minecraft.client.render.LightmapTextureManager;
import net.theclient.hacks.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LightmapTextureManager.class)
abstract class fullBrightMixin
{
    @Inject(method = "getBrightness", at = @At("HEAD"), cancellable = true)
    private void onGetBrightness(CallbackInfoReturnable<Float> info) {
        if(Main.isfullBrightEnabled) {
            info.setReturnValue(1f);
        }
    }
}
