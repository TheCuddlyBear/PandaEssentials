package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.ChatColor;
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
            Player player = (Player) sender;
            if(args.length == 1){
                if(player.hasPermission("pandaessentials.teleport.others")){

                }
            }else if(args.length == 2) {
                if(player.hasPermission("pandaessentials.teleport.others"));
            } else{
                player.sendMessage(ChatColor.RED + "Invalid arguments!");
                player.sendMessage(ChatColor.RED + "/teleport <playername> [otherplayer]");
            }
        }else {
            plugin.getLogger().severe("This command has to be run by a player");
        }

        return true;
    }
}
