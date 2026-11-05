package net.vsh33.withertools;

import net.fabricmc.api.ClientModInitializer;

public class WitherToolsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// ChunkSectionLayer is chosen automatically from sprite transparency in 26.1+.
		// Witherproof glass uses a translucent texture, so it renders as translucent.
	}
}
