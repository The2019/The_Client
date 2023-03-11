package net.theclient.hacks;


import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Sprint {

    public static void Sprint(){
        if(Main.mc.player != null && Main.isSprintEnabled) {
            Main.mc.player.setSprinting(true);
        }
    }
}
