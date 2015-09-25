package boni.dummy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DummyEventHandler {
    @SubscribeEvent
    public void onPlayerLeftClick(LivingAttackEvent event)
    {
        if(event.source == null || event.entity == null || !(event.entity instanceof EntityDummy))
            return;

        if(!event.source.damageType.equals("player"))
            return;
        if(!(event.source.getEntity() instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) event.source.getEntity();

        // shift-leftclick with empty hand dismantles
        if(player.isSneaking() && player.getCurrentEquippedItem() == null)
            ((EntityDummy)event.entity).dismantle();
    }
}