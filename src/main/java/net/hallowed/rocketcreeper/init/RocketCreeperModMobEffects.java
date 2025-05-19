
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.hallowed.rocketcreeper.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.hallowed.rocketcreeper.potion.FuseAnimationToggleMobEffect;
import net.hallowed.rocketcreeper.RocketCreeperMod;

public class RocketCreeperModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RocketCreeperMod.MODID);
	public static final RegistryObject<MobEffect> FUSE_ANIMATION_TOGGLE = REGISTRY.register("fuse_animation_toggle", () -> new FuseAnimationToggleMobEffect());
}
