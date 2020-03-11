package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class suicide implements CommandExecutor {

    Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("pandaessentials.suicide")){
                player.sendMessage(ChatColor.RED + "I don't want to live anymore, goodbye!");
                player.setHealth(0);
            }else{
                player.sendMessage(ChatColor.RED + "Invalid permissions!");
            }
        }else{
            plugin.getLogger().severe("This command has to be run as a player!");
        }

        return true;
    }
}
