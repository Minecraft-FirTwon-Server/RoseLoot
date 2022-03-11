package dev.rosewood.roseloot.hook.conditions;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.rosewood.roseloot.event.LootConditionRegistrationEvent;
import dev.rosewood.roseloot.loot.condition.LootCondition;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class HookConditionListener implements Listener {

    private static final Multimap<String, ConditionStorage> LOOT_CONDITIONS = ArrayListMultimap.create();
    static {
        LOOT_CONDITIONS.put("MythicMobs", new ConditionStorage("mythicmobs-type", MythicMobsTypeCondition.class));
        LOOT_CONDITIONS.put("EcoBosses", new ConditionStorage("ecobosses-type", EcoBossesTypeCondition.class));
    }

    @EventHandler
    public void onLootConditionRegistration(LootConditionRegistrationEvent event) {
        PluginManager pluginManager = Bukkit.getPluginManager();
        for (String pluginName : LOOT_CONDITIONS.keys())
            if (pluginManager.isPluginEnabled(pluginName))
                for (ConditionStorage conditionStorage : LOOT_CONDITIONS.get(pluginName))
                    event.registerLootCondition(conditionStorage.getConditionName(), conditionStorage.getConditionClass());
    }

    private static class ConditionStorage {

        private final String conditionName;
        private final Class<? extends LootCondition> conditionClass;

        private ConditionStorage(String conditionName, Class<? extends LootCondition> conditionClass) {
            this.conditionName = conditionName;
            this.conditionClass = conditionClass;
        }

        /**
         * @return The name of the condition
         */
        public String getConditionName() {
            return this.conditionName;
        }

        /**
         * @return The class of the condition
         */
        public Class<? extends LootCondition> getConditionClass() {
            return this.conditionClass;
        }

    }

}
