package dev.rosewood.roseloot.loot.condition.tags.entity;

import dev.rosewood.roseloot.loot.condition.EntityConditions;
import dev.rosewood.roseloot.loot.condition.LootConditions;
import org.bukkit.entity.IronGolem;

public class IronGolemConditions extends EntityConditions {

    public IronGolemConditions() {
        LootConditions.registerTag("iron-golem-player-created", context -> context.getLootedEntity() instanceof IronGolem && ((IronGolem) context.getLootedEntity()).isPlayerCreated());
    }

}
