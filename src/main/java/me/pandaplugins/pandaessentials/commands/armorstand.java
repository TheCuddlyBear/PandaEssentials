package me.pandaplugins.pandaessentials.commands;

import me.pandaplugins.pandaessentials.PandaEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class armorstand implements CommandExecutor {

    Plugin plugin = PandaEssentials.getPlugin(PandaEssentials.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("pandaessentials.armorstand")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                for(Entity e : player.getNearbyEntities(1, 1, 1)) {
                    if(e.getType() == EntityType.ARMOR_STAND) {
                        ArmorStand armorStand = (ArmorStand) e;

                        if (args[0].equals("setarms")) {
                            argumentSetArms(args[1], player, armorStand);
                        }else if(args[0].equals("setbaseplate")){
                            argumentSetBasePlate(args[1], player, armorStand);
                        }
                    }
                }
            }else{
                plugin.getLogger().severe("This plugin has to be run by a player");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Invalid permissions!");
        }

        return true;
    }

    public void argumentSetArms(String argument, Player player, ArmorStand e) {

        if(!argument.isEmpty()){
            if(argument.equals("true") || argument.equals("false")){
                if(argument.equals("true")) {
                    e.setArms(true);
                    player.sendMessage(ChatColor.GREEN + "Made ArmorStand's arms visible");
                }else{
                    e.setArms(false);
                    player.sendMessage(ChatColor.GREEN + "Made ArmorStand's arms invisible");
                }
            }else{
                player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                player.sendMessage(ChatColor.RED + "/armorstand setarms <true/false>");
            }
        }else{
            player.sendMessage(ChatColor.RED + "Invalid Arguments!");
            player.sendMessage(ChatColor.RED + "/armorstand setarms <true/false>");
        }
    }

    public void argumentSetBasePlate(String argument, Player player, ArmorStand e){
        if(!argument.isEmpty()){
            if(argument.equals("true") || argument.equals("false")){
                if(argument.equals("true")) {
                    e.setBasePlate(true);
                    player.sendMessage(ChatColor.GREEN + "Made ArmorStand's base plate visible");
                }else{
                    e.setBasePlate(false);
                    player.sendMessage(ChatColor.GREEN + "Made ArmorStand's base plate invisible");
                }
            }else{
                player.sendMessage(ChatColor.RED + "Invalid Arguments!");
                player.sendMessage(ChatColor.RED + "/armorstand setbaseplate <true/false>");
            }
        }else{
            player.sendMessage(ChatColor.RED + "Invalid Arguments!");
            player.sendMessage(ChatColor.RED + "/armorstand setbaseplate <true/false>");
        }
    }


}
