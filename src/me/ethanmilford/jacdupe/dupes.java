package me.ethanmilford.jacdupe;

import me.ethanmilford.jacdupe.main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;

public class dupes extends JavaPlugin
  implements Listener
{
  @EventHandler
  public void handleDupes(InventoryClickEvent event)
  {
    Player player = (Player)event.getWhoClicked();
    int slot = event.getSlot();
    String title = event.getView().getTopInventory().getTitle().toLowerCase();

    if (title.equals("rm furnace")) {
      if ((!main.rmfurnace.equals("true")) || (
        (slot == 35) && (event.isShiftClick()))) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.GOLD + "[JACDupe] " + ChatColor.RED + "You cant DUPE with an RM_Furnace");
      }

    }
    else if ((title.equals("tank cart")) && (
      (!main.tankcart.equals("true")) || 
      (event.isShiftClick()))) {
      event.setCancelled(true);
      player.sendMessage(ChatColor.GOLD + "[JACDupe] " + ChatColor.RED + "You cant DUPE with an TANK_CART");
    }
  }
}