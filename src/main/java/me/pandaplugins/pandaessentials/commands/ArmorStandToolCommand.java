package me.pandaplugins.pandaessentials.commands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class ArmorStandToolCommand implements CommandExecutor {

  private Plugin plugin;

  public ArmorStandToolCommand(Plugin plugin) { this.plugin = plugin; }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label,
                           String[] args) {

    if (sender instanceof Player) {
      Player player = (Player)sender;

      if (player.hasPermission("pandaessentials.armorstand.tool")) {
        ItemStack tool = new ItemStack(Material.STICK);

        ItemMeta tool_meta = tool.getItemMeta();
        tool_meta.setDisplayName(ChatColor.AQUA + "Armor Stand Tool");
        ArrayList<String> tool_lore = new ArrayList<>();
        tool_lore.add(ChatColor.GRAY +
                      "Opens the Armor Stand Editor on left click");
        tool_meta.setLore(tool_lore);
        tool.setItemMeta(tool_meta);

        player.getInventory().addItem(tool);
      }

    } else {
      plugin.getLogger().severe("This command has to be run by a player!");
    }

    return true;
  }
}
