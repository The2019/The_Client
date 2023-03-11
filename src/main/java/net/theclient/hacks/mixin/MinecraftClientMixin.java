package net.theclient.hacks.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.theclient.hacks.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
    private void onHasOutline(Entity entity, CallbackInfoReturnable<Boolean> info)
    {
        if(Main.isEntityOutlinetEnabled && entity.getType() != EntityType.PLAYER) {
            info.setReturnValue(true);
        }
    }
}
