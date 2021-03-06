package me.pandaplugins.pandaessentials;

import me.pandaplugins.pandaessentials.commands.kill;
import me.pandaplugins.pandaessentials.commands.suicide;
import me.pandaplugins.pandaessentials.commands.teleport;
import me.pandaplugins.pandaessentials.commands.tphere;
import org.bukkit.plugin.java.JavaPlugin;

public final class PandaEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("The plugin has been enabled!");
        getCommand("kill").setExecutor(new kill());
        getCommand("teleport").setExecutor(new teleport());
        getCommand("suicide").setExecutor(new suicide());
        getCommand("tphere").setExecutor(new tphere());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
