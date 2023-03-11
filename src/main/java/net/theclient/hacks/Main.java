package net.theclient.hacks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.text.Text;
import net.theclient.hacks.Screens.ConfigScreen;
import org.lwjgl.glfw.GLFW;

public class Main implements ModInitializer {

    public static final MinecraftClient mc = MinecraftClient.getInstance();

    //Varibals
    public static boolean isHurtCamEnabled = true;
    public static boolean isFlightEnabled = false;
    public static boolean isSprintEnabled = true;
    public static boolean isAutoTotemEnabled = true;
    public static boolean isNoFallEnabled = true;
    public static boolean isSpeedEnabled = false;
    public static boolean isfullBrightEnabled = true;
    public static boolean isEntityOutlinetEnabled = false;
    public static boolean isMapExploit = true;

    @Override
    public void onInitialize() {

        KeyBinding clientGui = KeyBindingHelper.registerKeyBinding(new KeyBinding("Open Gui", GLFW.GLFW_KEY_F5, "The Client"));

        KeyBinding flight = KeyBindingHelper.registerKeyBinding(new KeyBinding("Flight toggle", GLFW.GLFW_KEY_F6, "The Client"));

        KeyBinding autoTotem = KeyBindingHelper.registerKeyBinding(new KeyBinding("Auto Totem toggle", GLFW.GLFW_KEY_F7, "The Client"));

        KeyBinding sprint = KeyBindingHelper.registerKeyBinding(new KeyBinding("Sprint toggle", GLFW.GLFW_KEY_F8, "The Client"));

        KeyBinding noFall = KeyBindingHelper.registerKeyBinding(new KeyBinding("No Fall toggle", GLFW.GLFW_KEY_F9, "The Client"));

        KeyBinding speed = KeyBindingHelper.registerKeyBinding(new KeyBinding("Speed toggle", GLFW.GLFW_KEY_F10, "The Client"));

        KeyBinding hurtCam = KeyBindingHelper.registerKeyBinding(new KeyBinding("Hurt Cam toggle", GLFW.GLFW_KEY_F11, "The Client"));

        KeyBinding fullBright = KeyBindingHelper.registerKeyBinding(new KeyBinding("Full Bright toggle", GLFW.GLFW_KEY_F12, "The Client"));

        KeyBinding entityOutline = KeyBindingHelper.registerKeyBinding(new KeyBinding("Entity Outline toggle", GLFW.GLFW_KEY_COMMA, "The Client"));

        KeyBinding mapExploit = KeyBindingHelper.registerKeyBinding(new KeyBinding("Map Render toggle", GLFW.GLFW_KEY_RIGHT_CONTROL, "The Client"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            //keydedection Open Gui F5
            if (clientGui.wasPressed()) {
                client.setScreen(new ConfigScreen( client.currentScreen, client.options));
            }

            //keydedection auto Totem F7
            if (autoTotem.wasPressed()) {
                if (isAutoTotemEnabled) {
                    isAutoTotemEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Auto Totem"), false);
                }
                else {
                    isAutoTotemEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Auto Totem"), false);
                }
            }
            //keydedection Sprint F8
            if (sprint.wasPressed()) {
                if (isSprintEnabled) {
                    isSprintEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Sprint"), false);
                }
                else {
                    isSprintEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Sprint"), false);
                }
            }
            //keydedection No Fall F9
            if (noFall.wasPressed()) {
                if (isNoFallEnabled) {
                    isNoFallEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled No Fall"), false);
                }
                else {
                    isNoFallEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled No Fall"), false);
                }
            }
            //keydedection Speed F10
            if (speed.wasPressed()) {
                if (isSpeedEnabled) {
                    isSpeedEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Speed"), false);
                }
                else {
                    isSpeedEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Speed"), false);
                }
            }
            //keydedection Flight F6
            if (flight.wasPressed()) {
                if (isFlightEnabled) {
                    isFlightEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Flight"), false);
                }
                else {
                    isFlightEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Flight"), false);
                }
            }
            //keydedection Hurt Cam F11
            if (hurtCam.wasPressed()) {
                if (isHurtCamEnabled) {
                    isHurtCamEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Hurt Cam"), false);
                }
                else {
                    isHurtCamEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Hurt Cam"), false);
                }
            }
            //keydedection Hurt Cam F12
            if (fullBright.wasPressed()) {
                if (isfullBrightEnabled) {
                    isfullBrightEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Full Bright"), false);
                }
                else {
                    isfullBrightEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Full Bright"), false);
                }
            }
            //keydedection Entity Outline COMMA
            if (entityOutline.wasPressed()) {
                if (isEntityOutlinetEnabled) {
                    isEntityOutlinetEnabled = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Entity Outline"), false);
                }
                else {
                    isEntityOutlinetEnabled = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Entity Outline"), false);
                }
            }
            //keydedection Entity Outline COMMA
            if (mapExploit.wasPressed()) {
                if (isMapExploit) {
                    isMapExploit = false;
                    client.player.sendMessage(Text.of("§9[The Client] §rEnabled Map Rendering"), false);
                }
                else {
                    isMapExploit = true;
                    client.player.sendMessage(Text.of("§9[The Client] §rDisabled Map Rendering"), false);
                }
            }
        });
    }
}
