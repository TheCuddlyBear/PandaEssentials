package me.pandaplugins.pandaessentials.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.UUID;

public class MenuItemClick implements Listener {

    private Plugin plugin;

    public MenuItemClick(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuItemClick(InventoryClickEvent e) {
            if (e.getView().getTitle().equalsIgnoreCase("Armor Stand Editor")) {

                // Get UUID
                ItemStack uuidItem = Objects.requireNonNull(e.getClickedInventory()).getItem(17);
                String itemName = uuidItem.getItemMeta().getDisplayName();

                UUID itemUUID = java.util.UUID.fromString(itemName);

                ArmorStand armorStand = (ArmorStand) Bukkit.getEntity(itemUUID); // Cast the armor stand

                // Switch for the items that are clicked
                switch(e.getCurrentItem().getItemMeta().getDisplayName()){
                    case "§aSet Arms":
                        armorStand.setArms(false);
                        e.getWhoClicked().closeInventory();
                        break;
                    case "§cSet Arms":
                        armorStand.setArms(true);
                        e.getWhoClicked().closeInventory();
                        break;
                    case "§aSet Baseplate":
                        armorStand.setBasePlate(false);
                        e.getWhoClicked().closeInventory();
                        break;
                    case "§cSet Baseplate":
                        armorStand.setBasePlate(true);
                        e.getWhoClicked().closeInventory();
                        break;
                    case "§aSet Gravity":
                        armorStand.setGravity(false);
                        e.getWhoClicked().closeInventory();
                        break;
                    case "§cSet Gravity":
                        armorStand.setGravity(true);
                        e.getWhoClicked().closeInventory();
                        break;
                }

                e.setCancelled(true);
            }
        }
}
