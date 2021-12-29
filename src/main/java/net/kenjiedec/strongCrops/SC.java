package net.kenjiedec.strongCrops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SC implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("modid");
	public static final GameRules.Key<GameRules.IntRule> SCALE = GameRuleRegistry.register("trampleFallHeight", GameRules.Category.MISC, GameRuleFactory.createIntRule(2, 1));
	public static final GameRules.Key<GameRules.BooleanRule> TRAMPLE = GameRuleRegistry.register("doFarmlandTrample", GameRules.Category.MISC, GameRuleFactory.createBooleanRule(true));
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("StrongCrops is here!");
	}
}
