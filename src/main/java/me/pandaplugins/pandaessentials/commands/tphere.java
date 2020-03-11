package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class tphere implements CommandExecutor {

    Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("pandaessentials.teleport.others")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    Location playerLocation = player.getLocation();

                    target.teleport(playerLocation);
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid arguments!");
                    player.sendMessage(ChatColor.RED + "/tphere <playername>");
                }
            }else{
                player.sendMessage(ChatColor.RED + "Invalid permissions!");
            }
        }else{
            plugin.getLogger().severe("This command has to be run by a player");
        }

        return true;
    }
}
