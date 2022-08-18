package com.weirtz.nocreeperanxiety;

import net.minecraft.world.entity.monster.Creeper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.world.ExplosionEvent;

@Mod("nocreeperanxiety")
@Mod.EventBusSubscriber()
public class NoCreeperAnxiety{

    public NoCreeperAnxiety()
    {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority= EventPriority.HIGHEST)
    public static void onDetonate(ExplosionEvent.Detonate event) {
        
        //if explosion is other than creeper, allow.
        if(!(event.getExplosion().getSourceMob() instanceof Creeper)) {
            return;
        }

        // Remove blocks from explosion array.
        event.getAffectedBlocks().clear();
    }
}
