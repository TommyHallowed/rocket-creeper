package net.hallowed.rocketcreeper.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.hallowed.rocketcreeper.init.RocketCreeperModMobEffects;
import net.hallowed.rocketcreeper.entity.RocketCreeperEntity;
import net.hallowed.rocketcreeper.RocketCreeperMod;

import java.util.List;
import java.util.Comparator;

public class RocketCreeperOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		double maxDistance = 0;
		boolean PlayerInRange = false;
		PlayerInRange = false;
		distance = 0;
		maxDistance = 6;
		if (distance <= maxDistance) {
			{
				final Vec3 _center = new Vec3(
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player && new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
							}
							return false;
						}
					}.checkGamemode(entityiterator)) {
						PlayerInRange = true;
					}
				}
			}
			distance = distance + 1;
		}
		if (PlayerInRange) {
			if (entity instanceof RocketCreeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(RocketCreeperEntity.DATA_wait, (int) ((entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) + 1));
		} else {
			if (entity instanceof RocketCreeperEntity _datEntSetI)
				_datEntSetI.getEntityData().set(RocketCreeperEntity.DATA_wait, 0);
		}
		if (!PlayerInRange && entity.onGround() && (entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) == 20) {
			if ((((RocketCreeperEntity) entity).animationprocedure).equals("idle")) {
				if (entity instanceof RocketCreeperEntity) {
					((RocketCreeperEntity) entity).setAnimation("extinguish");
				}
				RocketCreeperMod.queueServerWork(5, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get());
					if (entity instanceof RocketCreeperEntity animatable)
						animatable.setTexture("rocketcreeper");
				});
			}
		} else if (PlayerInRange && entity.onGround() && (entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) == 20) {
			if ((((RocketCreeperEntity) entity).animationprocedure).equals("idle")) {
				if (entity instanceof RocketCreeperEntity) {
					((RocketCreeperEntity) entity).setAnimation("extinguish");
				}
				RocketCreeperMod.queueServerWork(5, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get());
					if (entity instanceof RocketCreeperEntity animatable)
						animatable.setTexture("rocketcreeper");
				});
			}
		}
		if ((entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) == 1) {
			if (!(((RocketCreeperEntity) entity).animationprocedure).equals("launch")) {
				if (entity instanceof RocketCreeperEntity) {
					((RocketCreeperEntity) entity).setAnimation("ignition");
				}
			}
			if (world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 3, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 4, z)).canOcclude()
					&& world.getBlockState(BlockPos.containing(x, y + 5, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 6, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 7, z)).canOcclude()
					&& world.getBlockState(BlockPos.containing(x, y + 8, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 9, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 10, z)).canOcclude()
					&& world.getBlockState(BlockPos.containing(x, y + 11, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y + 12, z)).canOcclude()) {
				if (entity instanceof RocketCreeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(RocketCreeperEntity.DATA_spaceabove, false);
			} else {
				if (entity instanceof RocketCreeperEntity _datEntSetL)
					_datEntSetL.getEntityData().set(RocketCreeperEntity.DATA_spaceabove, true);
			}
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get(), 40, 1, false, false));
			RocketCreeperMod.queueServerWork(15, () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 10, false, false));
			});
		}
		if ((entity instanceof RocketCreeperEntity _datEntI ? _datEntI.getEntityData().get(RocketCreeperEntity.DATA_wait) : 0) == 25) {
			if (entity instanceof RocketCreeperEntity _datEntL43 && _datEntL43.getEntityData().get(RocketCreeperEntity.DATA_spaceabove)) {
				if (entity instanceof RocketCreeperEntity) {
					((RocketCreeperEntity) entity).setAnimation("launch");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get(), 40, 1, false, false));
				entity.setDeltaMovement(new Vec3(0, 1.5, 0));
				RocketCreeperMod.queueServerWork(38, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
				});
			} else {
				if (entity instanceof RocketCreeperEntity) {
					((RocketCreeperEntity) entity).setAnimation("nospace");
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(RocketCreeperModMobEffects.FUSE_ANIMATION_TOGGLE.get(), 40, 1, false, false));
				RocketCreeperMod.queueServerWork(20, () -> {
					if (!entity.level().isClientSide())
						entity.discard();
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, x, y, z, 3, Level.ExplosionInteraction.MOB);
				});
			}
		}
	}
}
