package dev.rosewood.roseloot.command;

import dev.rosewood.rosegarden.RosePlugin;
import dev.rosewood.rosegarden.command.framework.RoseCommandWrapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LootCommandWrapper extends RoseCommandWrapper {

    public LootCommandWrapper(RosePlugin rosePlugin) {
        super(rosePlugin);
    }

    @Override
    public String getDefaultName() {
        return "loot";
    }

    @Override
    public List<String> getDefaultAliases() {
        return Arrays.asList("roseloot", "rl");
    }

    @Override
    public List<String> getCommandPackages() {
        return Collections.singletonList("dev.rosewood.roseloot.command.command");
    }

    @Override
    public boolean includeBaseCommand() {
        return true;
    }

    @Override
    public boolean includeHelpCommand() {
        return true;
    }

    @Override
    public boolean includeReloadCommand() {
        return true;
    }

}
