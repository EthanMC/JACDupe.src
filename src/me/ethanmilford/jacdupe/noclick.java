package me.ethanmilford.jacdupe;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class noclick extends JavaPlugin
  implements Listener
{
  @EventHandler
  public void onInteract(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();

    int item = player.getItemInHand().getTypeId();
    if (((item == 27564) || (item == 27565) || (item == 27566) || (item == 27568) || (item == 27569) || (item == 27570) || (item == 27572) || (item == 27573) || (item == 27543) || (item == 27544) || (item == 27545) || (item == 27546) || (item == 27547) || (item == 27548) || (item == 27555)) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK))) {
      if (main.eeclick.equals("true"));
      event.setCancelled(true);
      player.sendMessage(ChatColor.GOLD + "[JACDupe] " + ChatColor.RED + "Right click with this item has been disabled becouse of massive griefing.");
    }
  }
}