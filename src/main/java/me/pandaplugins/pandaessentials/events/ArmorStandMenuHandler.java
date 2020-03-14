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

                        Inventory gui = Bukkit.createInventory(player, 18, "Armor Stand Editor");

                        if (armorStand.hasArms()) {
                            ItemStack setarms = new ItemStack(Material.GREEN_WOOL);

                            ItemMeta setarms_meta = setarms.getItemMeta();
                            setarms_meta.setDisplayName(ChatColor.GREEN + "Set Arms");
                            ArrayList<String> setarms_lore = new ArrayList<>();
                            setarms_lore.add(ChatColor.GRAY + "Currently set to: true");
                            setarms_meta.setLore(setarms_lore);
                            setarms.setItemMeta(setarms_meta);
                            ItemStack[] items = {setarms};
                            gui.setContents(items);

                        } else {
                            ItemStack setarms = new ItemStack(Material.RED_WOOL);

                            ItemMeta setarms_meta = setarms.getItemMeta();
                            setarms_meta.setDisplayName(ChatColor.RED + "Set Arms");
                            ArrayList<String> setarms_lore = new ArrayList<>();
                            setarms_lore.add(ChatColor.GRAY + "Currently set to: false");
                            setarms_meta.setLore(setarms_lore);
                            setarms.setItemMeta(setarms_meta);
                            ItemStack[] items = {setarms};
                            gui.setContents(items);
                        }

                        player.openInventory(gui);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onMenuItemClick(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase("Armor Stand Editor")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("Set Arms")){
                for(Entity entity : e.getWhoClicked().getNearbyEntities(1, 1, 1)){
                if(entity.getType() == EntityType.ARMOR_STAND){
                    ArmorStand armorStand = (ArmorStand) entity;

                    if(armorStand.hasArms()){
                        armorStand.setArms(false);
                        e.getWhoClicked().closeInventory();
                    }else{
                        armorStand.setArms(true);
                        e.getWhoClicked().closeInventory();
                    }
                }
            }
            }

            e.setCancelled(true);
        }
    }

}
