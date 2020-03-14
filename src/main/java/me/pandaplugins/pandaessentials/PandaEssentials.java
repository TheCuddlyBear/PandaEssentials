package me.pandaplugins.pandaessentials;

import me.pandaplugins.pandaessentials.commands.*;
import me.pandaplugins.pandaessentials.events.ArmorStandMenuHandler;
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
        getCommand("armorstd").setExecutor(new armorstand());
        // getServer().getPluginManager().registerEvents(new ArmorStandMenuHandler(), this); - Work in progress! Use command instead
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
