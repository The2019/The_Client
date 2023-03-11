package net.theclient.hacks;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.OnGroundOnly;


public class noFall {
    public static void noFall() {

        ClientPlayerEntity player = Main.mc.player;

        if(Main.mc.player != null && Main.isNoFallEnabled){
            if (player.fallDistance <= (player.isFallFlying() ? 1 : 2))
                return;

            if (player.isFallFlying() && player.isSneaking()
                    && !isFallingFastEnoughToCauseDamage(player))
                return;

            player.networkHandler.sendPacket(new OnGroundOnly(true));
            }
        }

        public static boolean isFallingFastEnoughToCauseDamage (ClientPlayerEntity player) {
            return player.getVelocity().y < -0.5;
    }
}