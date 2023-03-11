package net.theclient.hacks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Flight {


    public static void Flight(){
        if(Main.mc.player != null && Main.isFlightEnabled){
            Main.mc.player.getAbilities().allowFlying = true;
        }
        if(Main.mc.player != null && !Main.isFlightEnabled){
            Main.mc.player.getAbilities().allowFlying = false;
        }
    }
}
