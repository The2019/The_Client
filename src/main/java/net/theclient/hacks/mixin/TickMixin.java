package net.theclient.hacks.mixin;

import net.minecraft.client.MinecraftClient;
import net.theclient.hacks.Flight;
import net.theclient.hacks.Sprint;
import net.theclient.hacks.noFall;
import net.theclient.hacks.Speed;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(MinecraftClient.class)
public class TickMixin  {

	@Inject(at = @At("HEAD"), method = "tick",cancellable = true)
	public void onTick(CallbackInfo ci) {

		Flight.Flight();
		Sprint.Sprint();
		noFall.noFall();
		Speed.Speed();
	}
}
