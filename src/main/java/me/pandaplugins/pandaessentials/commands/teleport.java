package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class teleport implements CommandExecutor {

    Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

        }else {
            plugin.getLogger().severe("This command has to be run by a player"1);
        }

        return true;
    }
}
