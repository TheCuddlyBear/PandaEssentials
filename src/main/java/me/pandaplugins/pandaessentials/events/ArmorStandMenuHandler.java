package me.pandaplugins.pandaessentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.UUID;

public class ArmorStandMenuHandler implements Listener {

    private Plugin plugin;

    public ArmorStandMenuHandler(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityClick(EntityDamageByEntityEvent e) {
        if (plugin.getConfig().getBoolean("armorstandGUI")) {
            if (e.getDamager() instanceof Player) {
                if (((Player) e.getDamager()).getItemInHand().getItemMeta().getDisplayName().equals("§bArmor Stand Tool")) {
                    if (e.getDamager().hasPermission("pandaessentials.editarmorstand")) {
                        if (e.getEntity() instanceof ArmorStand) {
                                e.setCancelled(true);
                                Player player = (Player) e.getDamager();
                                ArmorStand armorStand = (ArmorStand) e.getEntity();
                                UUID standUUID = e.getEntity().getUniqueId();

                                Inventory gui = Bukkit.createInventory(player, 18, "Armor Stand Editor");

                                makeArmsItem(armorStand, gui);
                                makeBasePlateItem(armorStand, gui);
                                makeGravityItem(armorStand, gui);

                                getUUID(String.valueOf(standUUID), gui);

                                player.openInventory(gui);
                        }
                    }
                }
            }
        }
    }

    public void getUUID(String standUUID, Inventory gui){
        ItemStack uuid = new ItemStack(Material.GRAY_STAINED_GLASS);

        ItemMeta uuid_meta = uuid.getItemMeta();
        uuid_meta.setDisplayName(standUUID);
        uuid.setItemMeta(uuid_meta);

        gui.setItem(17, uuid);
    }

    public void makeArmsItem(ArmorStand armorStand, Inventory gui){
        if (armorStand.hasArms()) {
            ItemStack setarms = new ItemStack(Material.GREEN_WOOL);

            ItemMeta setarms_meta = setarms.getItemMeta();
            setarms_meta.setDisplayName(ChatColor.GREEN + "Set Arms");
            ArrayList<String> setarms_lore = new ArrayList<>();
            setarms_lore.add(ChatColor.GRAY + "Currently set to: true");
            setarms_meta.setLore(setarms_lore);
            setarms.setItemMeta(setarms_meta);
            gui.setItem(0, setarms);

        } else {
            ItemStack setarms = new ItemStack(Material.RED_WOOL);

            ItemMeta setarms_meta = setarms.getItemMeta();
            setarms_meta.setDisplayName(ChatColor.RED + "Set Arms");
            ArrayList<String> setarms_lore = new ArrayList<>();
            setarms_lore.add(ChatColor.GRAY + "Currently set to: false");
            setarms_meta.setLore(setarms_lore);
            setarms.setItemMeta(setarms_meta);
            gui.setItem(0, setarms);
        }
    }

    public void makeBasePlateItem(ArmorStand armorStand, Inventory gui){
        if (armorStand.hasBasePlate()) {
            ItemStack setbaseplate = new ItemStack(Material.GREEN_WOOL);

            ItemMeta setbaseplate_meta = setbaseplate.getItemMeta();
            setbaseplate_meta.setDisplayName(ChatColor.GREEN + "Set Baseplate");
            ArrayList<String> setbaseplate_lore = new ArrayList<>();
            setbaseplate_lore.add(ChatColor.GRAY + "Currently set to: true");
            setbaseplate_meta.setLore(setbaseplate_lore);
            setbaseplate.setItemMeta(setbaseplate_meta);
            gui.setItem(1, setbaseplate);

        } else {
            ItemStack setbaseplate = new ItemStack(Material.RED_WOOL);

            ItemMeta setbaseplate_meta = setbaseplate.getItemMeta();
            setbaseplate_meta.setDisplayName(ChatColor.RED + "Set Baseplate");
            ArrayList<String> setbaseplate_lore = new ArrayList<>();
            setbaseplate_lore.add(ChatColor.GRAY + "Currently set to: false");
            setbaseplate_meta.setLore(setbaseplate_lore);
            setbaseplate.setItemMeta(setbaseplate_meta);
            gui.setItem(1, setbaseplate);
        }
    }

    public void makeGravityItem(ArmorStand armorStand, Inventory gui){
        if (armorStand.hasGravity()) {
            ItemStack setgravity = new ItemStack(Material.GREEN_WOOL);

            ItemMeta setgravity_meta = setgravity.getItemMeta();
            setgravity_meta.setDisplayName(ChatColor.GREEN + "Set Gravity");
            ArrayList<String> setgravity_lore = new ArrayList<>();
            setgravity_lore.add(ChatColor.GRAY + "Currently set to: true");
            setgravity_meta.setLore(setgravity_lore);
            setgravity.setItemMeta(setgravity_meta);
            gui.setItem(2, setgravity);

        } else {
            ItemStack setgravity = new ItemStack(Material.RED_WOOL);

            ItemMeta setgravity_meta = setgravity.getItemMeta();
            setgravity_meta.setDisplayName(ChatColor.RED + "Set Gravity");
            ArrayList<String> setgravity_lore = new ArrayList<>();
            setgravity_lore.add(ChatColor.GRAY + "Currently set to: false");
            setgravity_meta.setLore(setgravity_lore);
            setgravity.setItemMeta(setgravity_meta);
            gui.setItem(2, setgravity);
        }
    }

}
