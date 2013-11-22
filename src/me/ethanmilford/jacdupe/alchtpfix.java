package me.ethanmilford.jacdupe;

import me.ethanmilford.jacdupe.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class alchtpfix
  implements Listener
{
  @EventHandler(priority=EventPriority.HIGH)
  public void teleport(PlayerTeleportEvent e)
  {
    if (main.alchtpfix.equals("true"));
    Player player = e.getPlayer();
    player.closeInventory();
  }
}