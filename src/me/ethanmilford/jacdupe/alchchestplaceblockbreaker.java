package me.ethanmilford.jacdupe;

import me.ethanmilford.jacdupe.main;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class alchchestplaceblockbreaker
  implements Listener
{
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event)
  {
    Block block = event.getBlock();
    Player player = event.getPlayer();

    if ((!main.alchblockbreakerfix.equals("true")) || (
      (block.getTypeId() == 150) && (block.getData() == 1))) {
      int y = block.getY();
      int x = block.getX();
      int z = block.getZ();
      World world = block.getWorld();
      int place = world.getBlockAt(x, y, z - 1).getTypeId();
      int place1 = world.getBlockAt(x, y, z + 1).getTypeId();
      int place2 = world.getBlockAt(x, y - 1, z).getTypeId();
      int place3 = world.getBlockAt(x, y + 1, z).getTypeId();
      int place4 = world.getBlockAt(x - 1, y, z).getTypeId();
      int place5 = world.getBlockAt(x + 1, y, z).getTypeId();

      boolean isbad = false;
      if (place == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (place1 == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (place2 == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (place3 == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (place4 == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (place5 == 128) {
        isbad = true;
        event.setCancelled(true);
      }
      if (isbad)
      {
        event.setCancelled(true);
        player.sendMessage(ChatColor.GOLD + "[JACDupe] " + ChatColor.RED + "You cant dupe with a blockbreaker.");
      }
    }
  }
}