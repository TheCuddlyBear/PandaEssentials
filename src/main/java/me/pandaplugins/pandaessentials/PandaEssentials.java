package me.pandaplugins.pandaessentials;

import java.util.ArrayList;
import me.pandaplugins.pandaessentials.commands.*;
import me.pandaplugins.pandaessentials.events.ArmorStandMenuHandler;
import me.pandaplugins.pandaessentials.events.MenuItemClick;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class PandaEssentials extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    getLogger().info("The plugin has been enabled!");

    // Commands
    getCommand("kill").setExecutor(new kill());
    getCommand("teleport").setExecutor(new teleport());
    getCommand("suicide").setExecutor(new suicide());
    getCommand("tphere").setExecutor(new tphere());
    getCommand("armorstd").setExecutor(new armorstand());
    getCommand("armorstandtool").setExecutor(new ArmorStandToolCommand(this));

    // Crafting recipe
    ItemStack tool = new ItemStack(Material.STICK);

    ItemMeta tool_meta = tool.getItemMeta();
    tool_meta.setDisplayName(ChatColor.AQUA + "Armor Stand Tool");
    tool_meta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
    tool_meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    ArrayList<String> tool_lore = new ArrayList<>();
    tool_lore.add(ChatColor.GRAY +
                  "Opens the Armor Stand Editor on left click");
    tool_meta.setLore(tool_lore);
    tool.setItemMeta(tool_meta);

    ShapedRecipe armorTool = new ShapedRecipe(tool);

    armorTool.shape("@A@", "@*@", "@*@");

    armorTool.setIngredient('*', Material.STICK);
    armorTool.setIngredient('@', Material.AIR);
    armorTool.setIngredient('A', Material.ARMOR_STAND);

    getServer().addRecipe(armorTool);
    // End

    // Config
    getConfig().options().copyDefaults();
    saveDefaultConfig();

    // Events
    getServer().getPluginManager().registerEvents(
        new ArmorStandMenuHandler(this),
        this); // Work in progress! Use command instead
    getServer().getPluginManager().registerEvents(new MenuItemClick(this),
                                                  this);
  }

  public void CreateRecipe() {}

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    getLogger().info("The plugin is disabled!");
  }
}
