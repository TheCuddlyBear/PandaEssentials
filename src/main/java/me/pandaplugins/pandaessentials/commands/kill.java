package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class kill implements CommandExecutor {

    Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("pandaessentials.kill")){
            Player player = (Player) sender;
            if(args.length == 1){
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target != null){
                    player.sendMessage(ChatColor.RED + "Killed: " + target.getDisplayName());
                    target.setHealth(0);
                }else{
                    player.sendMessage(ChatColor.RED +  "That player does not exist!");
                }
            }else if(args.length > 1){
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
                player.sendMessage(ChatColor.RED + "/kill <playername>");
            }else if(sender instanceof Player) {
                player.setHealth(0);
            }else{
                plugin.getLogger().severe("The console cannot be killed!");
            }
        }

        return true;
    }
}