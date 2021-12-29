package net.kenjiedec.strongCrops.mixin;

import net.kenjiedec.strongCrops.SC;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = FarmlandBlock.class, priority = 1001)
public class SCMixin {
	@Inject(method = "onLandedUpon", at = @At("HEAD"), cancellable = true)
	private void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance, CallbackInfo ci) {
		boolean trueornot = world.getGameRules().getBoolean(SC.TRAMPLE);
		if (!world.isClient && world.getGameRules().getInt(SC.SCALE) < fallDistance && entity instanceof LivingEntity && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) && entity.getWidth() * entity.getWidth() * entity.getHeight() > 0.512f && trueornot) {
			FarmlandBlock.setToDirt(state, world, pos);
		}
		entity.handleFallDamage(fallDistance, 1.0f, DamageSource.FALL);
		ci.cancel();
	}
}