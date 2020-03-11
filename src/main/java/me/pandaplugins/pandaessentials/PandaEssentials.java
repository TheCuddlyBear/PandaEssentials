package me.pandaplugins.pandaessentials;

import me.pandaplugins.pandaessentials.commands.kill;
import org.bukkit.plugin.java.JavaPlugin;

public final class PandaEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("The plugin has been enabled!");
        getCommand("kill").setExecutor(new kill());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
