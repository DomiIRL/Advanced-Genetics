package com.technovision.advancedgenetics.components;

import com.technovision.advancedgenetics.AdvancedGenetics;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistry;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public class AdvancedGeneticsComponents implements EntityComponentInitializer {

    public static final ComponentKey<PlayerGenetics> PLAYER_GENETICS =
            ComponentRegistry.getOrCreate(new Identifier(AdvancedGenetics.MOD_ID, "player_genetics"), PlayerGenetics.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        // Add the component to every PlayerEntity instance, and copy it on respawn
        registry.registerForPlayers(PLAYER_GENETICS, player -> new PlayerGenetics(), RespawnCopyStrategy.ALWAYS_COPY);
    }
}
