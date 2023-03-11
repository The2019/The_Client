package net.theclient.hacks.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.theclient.hacks.Screens.ExploitScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.theclient.hacks.Screens.ConfigScreen;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text text) {
        super(text);
    }
    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void initWidgets(CallbackInfo ci) {
        this.addDrawableChild(new ButtonWidget(10 , 10, 90, 20, new LiteralText("Config") , (buttonWidget) -> {
            this.client.setScreen( new ConfigScreen(this, this.client.options));
        }));

        this.addDrawableChild(new ButtonWidget(10 , 35, 90, 20, new LiteralText("Exploits") , (buttonWidget) -> {
            this.client.setScreen( new ExploitScreen(this, this.client.options));
        }));
    }
}
