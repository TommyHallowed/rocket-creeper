
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hallowed.rocketcreeper.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.hallowed.rocketcreeper.client.renderer.RocketCreeperRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RocketCreeperModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(RocketCreeperModEntities.ROCKET_CREEPER.get(), RocketCreeperRenderer::new);
	}
}
