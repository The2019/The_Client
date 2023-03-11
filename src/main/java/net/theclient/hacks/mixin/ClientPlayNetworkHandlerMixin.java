package net.theclient.hacks.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.DeathMessageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.network.packet.s2c.play.ItemPickupAnimationS2CPacket;
import net.minecraft.network.packet.s2c.play.ScreenHandlerSlotUpdateS2CPacket;
import net.minecraft.screen.slot.SlotActionType;

import net.theclient.hacks.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    @Inject(method = "onEntityStatus", at = @At("RETURN"))
    private void onOnEntityStatus(EntityStatusS2CPacket packet, CallbackInfo info)
    {
        if(Main.isAutoTotemEnabled && packet.getStatus() == 35 && packet.getEntity(Main.mc.player.world).equals(Main.mc.player)) {
            ClientPlayerEntity player  = Main.mc.player;

            int activeIdx = -1;

            // TOTEM used in main hand (main hand first as it gets priority if totem in both hands)
            if(player.getMainHandStack().getItem() == Items.TOTEM_OF_UNDYING) {
                activeIdx = player.getInventory().selectedSlot + 36;
            } // TOTEM used in offhand
            else if(player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING) {
                activeIdx = 45;
            }

            if(activeIdx != -1) {
                int sz = player.getInventory().main.size();

                for(int i = 0; i < sz; i++) {
                    if(player.getInventory().main.get(i).getItem() == Items.TOTEM_OF_UNDYING && i != player.getInventory().selectedSlot) {
                        // works by clicking on the totem first and then on the last known used totem position (either a hotbar slot or offhand)
                        if(i < 9) { // hotbar
                            Main.mc.interactionManager.clickSlot(player.playerScreenHandler.syncId, i + 36, 0, SlotActionType.PICKUP, player);
                        } // rest of inventory
                        else {
                            Main.mc.interactionManager.clickSlot(player.playerScreenHandler.syncId, i, 0, SlotActionType.PICKUP, player);
                        }

                        Main.mc.interactionManager.clickSlot(player.playerScreenHandler.syncId, activeIdx, 0, SlotActionType.PICKUP, player);

                        break;
                    }
                }
            }
        }
    }
}
