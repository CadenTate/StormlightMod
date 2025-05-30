package ctnightfury.stormlightmod;

import ctnightfury.stormlightmod.block.ModBlocks;
import ctnightfury.stormlightmod.componenet.ModDataComponentTypes;
import ctnightfury.stormlightmod.item.ModItemGroups;
import ctnightfury.stormlightmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StormlightMod implements ModInitializer {
	public static final String MOD_ID = "stormlightmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		// Client-side tick event (only needed for client-specific actions)
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistry.INSTANCE.add(ModItems.DRIED_LAVIS_POLYP, 300);

		LOGGER.info("Registering all spheres...");
		ModItems.registerSpheres();
		LOGGER.info("Spheres registered!");
	}
}