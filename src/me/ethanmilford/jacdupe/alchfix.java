package me.ethanmilford.jacdupe;

import ee.TileAlchChest;
import me.ethanmilford.jacdupe.main;
import net.minecraft.server.TileEntity;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class alchfix
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
  public void onBlockBreak(BlockBreakEvent event)
  {
    Block block = event.getBlock();
    if ((block.getTypeId() == 128) && (block.getData() == 0))
    {
      if (main.alchfix.equals("true"));
      event.setCancelled(true);

      TileEntity entity = ((CraftWorld)block.getWorld()).getTileEntityAt(block.getX(), block.getY(), block.getZ());
      if (!(entity instanceof TileAlchChest)) return;
      TileAlchChest chest = (TileAlchChest)entity;

      net.minecraft.server.ItemStack[] items = new net.minecraft.server.ItemStack[chest.getSize()];
      for (int i = 0; i < chest.getSize(); i++)
      {
        items[i] = chest.getItem(i);
        chest.setItem(i, null);
      }

      block.setType(Material.AIR);
      for (net.minecraft.server.ItemStack i : items)
      {
        if ((i != null) && (i.id != 0)) {
          block.getWorld().dropItemNaturally(block.getLocation(), new CraftItemStack(i));
        }
      }
      block.getWorld().dropItemNaturally(block.getLocation(), new org.bukkit.inventory.ItemStack(128, 1, (short)0));
    }
  }
}