package net.hallowed.rocketcreeper.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.hallowed.rocketcreeper.entity.RocketCreeperEntity;
import net.hallowed.rocketcreeper.RocketCreeperMod;

public class FuseAnimationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof RocketCreeperEntity) {
			if ((entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) == 25) {
				if (entity instanceof RocketCreeperEntity _datEntL2 && _datEntL2.getEntityData().get(RocketCreeperEntity.DATA_spaceabove)) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.HOSTILE, 1, (float) 0.5);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.launch")), SoundSource.HOSTILE, 1, (float) 0.5, false);
						}
					}
				}
			}
			for (int index0 = 0; index0 < 4; index0++) {
				if ((entity instanceof RocketCreeperEntity animatable ? animatable.getTexture() : "null").equals("rocketcreeper")) {
					RocketCreeperMod.queueServerWork(3, () -> {
						if (entity instanceof RocketCreeperEntity animatable)
							animatable.setTexture("rocketcreeper_primed");
					});
				} else if ((entity instanceof RocketCreeperEntity animatable ? animatable.getTexture() : "null").equals("rocketcreeper_primed")) {
					RocketCreeperMod.queueServerWork(3, () -> {
						if (entity instanceof RocketCreeperEntity animatable)
							animatable.setTexture("rocketcreeper");
					});
				}
			}
		}
	}
}
