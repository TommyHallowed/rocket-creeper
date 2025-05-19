
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hallowed.rocketcreeper.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.hallowed.rocketcreeper.RocketCreeperMod;

public class RocketCreeperModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RocketCreeperMod.MODID);
	public static final RegistryObject<Item> ROCKET_CREEPER_SPAWN_EGG = REGISTRY.register("rocket_creeper_spawn_egg", () -> new ForgeSpawnEggItem(RocketCreeperModEntities.ROCKET_CREEPER, -16724788, -16777012, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
