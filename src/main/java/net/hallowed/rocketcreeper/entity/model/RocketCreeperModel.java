package net.hallowed.rocketcreeper.entity.model;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

import net.hallowed.rocketcreeper.entity.RocketCreeperEntity;

public class RocketCreeperModel extends GeoModel<RocketCreeperEntity> {
	@Override
	public ResourceLocation getAnimationResource(RocketCreeperEntity entity) {
		return new ResourceLocation("rocket_creeper", "animations/rocket_creeper.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RocketCreeperEntity entity) {
		return new ResourceLocation("rocket_creeper", "geo/rocket_creeper.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RocketCreeperEntity entity) {
		return new ResourceLocation("rocket_creeper", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(RocketCreeperEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
