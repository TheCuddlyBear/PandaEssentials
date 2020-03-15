package me.pandaplugins.pandaessentials.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class ArmorStandMenuHandler implements Listener {

    @EventHandler
    public void onEntityClick(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player) {
            if (e.getDamager().hasPermission("pandaessentials.editarmorstand")) {
                if (e.getEntity() instanceof ArmorStand) {
                    if (((Player) e.getDamager()).isSneaking()) {
                        e.setCancelled(true);
                        Player player = (Player) e.getDamager();
                        ArmorStand armorStand = (ArmorStand) e.getEntity();
                        UUID standUUID = e.getEntity().getUniqueId();

                        Inventory gui = Bukkit.createInventory(player, 18, "Armor Stand Editor");

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

                        ItemStack uuid = new ItemStack(Material.GRAY_STAINED_GLASS);

                        ItemMeta uuid_meta = uuid.getItemMeta();
                        uuid_meta.setDisplayName(String.valueOf(standUUID));
                        uuid.setItemMeta(uuid_meta);

                        gui.setItem(17, uuid);

                        player.openInventory(gui);
                    }
                }
            }
        }
    }
}
