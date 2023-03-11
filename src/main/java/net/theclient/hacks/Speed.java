package net.theclient.hacks;

import net.minecraft.util.math.Vec3d;

public class Speed {
    public static void Speed(){
        if(Main.mc.player != null && Main.isSpeedEnabled) {

            if (Main.mc.player.isSneaking()
                    || Main.mc.player.forwardSpeed == 0 && Main.mc.player.sidewaysSpeed == 0)
                return;

            if (Main.mc.player.forwardSpeed > 0 && !Main.mc.player.horizontalCollision)
                Main.mc.player.setSprinting(true);

            if (!Main.mc.player.isOnGround())
                return;

            Vec3d v = Main.mc.player.getVelocity();
            Main.mc.player.setVelocity(v.x * 1.8, v.y + 0.1, v.z * 1.8);

            v = Main.mc.player.getVelocity();
            double currentSpeed = Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.z, 2));

            double maxSpeed = 0.65F;

            if (currentSpeed > maxSpeed)
                Main.mc.player.setVelocity(v.x / currentSpeed * maxSpeed, v.y,
                        v.z / currentSpeed * maxSpeed);
        }
    }
}
