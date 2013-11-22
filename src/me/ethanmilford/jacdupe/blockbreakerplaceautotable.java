package me.ethanmilford.jacdupe;

import me.ethanmilford.jacdupe.main;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockbreakerplaceautotable
  implements Listener
{
  @EventHandler
  public void onBlockPlace(BlockPlaceEvent event)
  {
    Block block = event.getBlock();
    Player player = event.getPlayer();

    if ((!main.autotableblockbreakerfix.equals("true")) || (
      (block.getTypeId() == 194) && (block.getData() == 1))) {
      int y = block.getY();
      int x = block.getX();
      int z = block.getZ();
      World world = block.getWorld();
      int place = world.getBlockAt(x, y, z - 1).getTypeId();
      int sub = world.getBlockAt(x, y, z - 1).getData();
      int place1 = world.getBlockAt(x, y, z + 1).getTypeId();
      int sub1 = world.getBlockAt(x, y, z + 1).getData();
      int place2 = world.getBlockAt(x, y - 1, z).getTypeId();
      int sub2 = world.getBlockAt(x, y - 1, z).getData();
      int place3 = world.getBlockAt(x, y + 1, z).getTypeId();
      int sub3 = world.getBlockAt(x, y + 1, z).getData();
      int place4 = world.getBlockAt(x - 1, y, z).getTypeId();
      int sub4 = world.getBlockAt(x - 1, y, z).getData();
      int place5 = world.getBlockAt(x + 1, y, z).getTypeId();
      int sub5 = world.getBlockAt(x + 1, y, z).getData();

      boolean isbad = false;
      if ((place == 150) && (sub == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if ((place1 == 150) && (sub1 == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if ((place2 == 150) && (sub2 == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if ((place3 == 150) && (sub3 == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if ((place4 == 150) && (sub4 == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if ((place5 == 150) && (sub5 == 1)) {
        isbad = true;
        event.setCancelled(true);
      }
      if (isbad)
      {
        event.setCancelled(true);
        player.sendMessage("[JACDupe] You cant dupe with a blockbreaker.");
      }
    }
  }
}