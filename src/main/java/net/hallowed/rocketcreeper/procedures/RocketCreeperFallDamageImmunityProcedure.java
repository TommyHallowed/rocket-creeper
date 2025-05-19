package net.hallowed.rocketcreeper.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.hallowed.rocketcreeper.init.RocketCreeperModMobEffects;
import net.hallowed.rocketcreeper.entity.RocketCreeperEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RocketCreeperFallDamageImmunityProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof RocketCreeperEntity && entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get())) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
	}
}
