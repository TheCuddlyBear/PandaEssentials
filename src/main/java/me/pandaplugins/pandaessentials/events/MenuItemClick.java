package me.pandaplugins.pandaessentials.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.UUID;

public class MenuItemClick implements Listener {

    @EventHandler
    public void onMenuItemClick(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase("Armor Stand Editor")){
            if(e.getCurrentItem().getType().equals(Material.GREEN_WOOL) || e.getCurrentItem().getType().equals(Material.RED_WOOL)){
                ItemStack uuidItem = Objects.requireNonNull(e.getClickedInventory()).getItem(17);
                String itemName = uuidItem.getItemMeta().getDisplayName();

                UUID itemUUID = java.util.UUID.fromString(itemName);

                ArmorStand armorStand = (ArmorStand) Bukkit.getEntity(itemUUID);

                if(armorStand.hasArms()){
                    armorStand.setArms(false);
                    e.getWhoClicked().closeInventory();
                    e.getWhoClicked().sendMessage("Hello");
                }else{
                    armorStand.setArms(true);
                    e.getWhoClicked().closeInventory();
                }
            }
            e.setCancelled(true);
        }
    }

}
