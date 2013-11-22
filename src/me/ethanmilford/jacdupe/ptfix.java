package me.ethanmilford.jacdupe;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ptfix extends JavaPlugin
  implements Listener
{
  private Map<Block, String> inPt = new HashMap();
  private Map<String, Block> inPtPl = new HashMap();
  private Boolean clog = Boolean.valueOf(false);
  private String message = "[JACDupe] Two players can't use same project table at the same time.";
  private Boolean allow_ignore = Boolean.valueOf(true);
  private int pt_id = 137;
  private int pt_subid = 3;

  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
  }

  public void onDisable() {
    this.inPt.clear();
    this.inPtPl.clear();
  }

  public Boolean canOpen(Player p) {
    if ((this.allow_ignore.booleanValue()) && (
      (p.isOp()) || (p.hasPermission("ptfix.ignore")))) {
      return Boolean.valueOf(true);
    }

    return Boolean.valueOf(false);
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void playerQuit(PlayerQuitEvent e) {
    String player = e.getPlayer().getName();
    if (this.inPtPl.get(player) != null) {
      Block block = (Block)this.inPtPl.get(player);
      this.inPt.remove(block);
      this.inPtPl.remove(player);
    }
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void inventoryClose(InventoryCloseEvent e) {
    String player = e.getPlayer().getName();
    if (this.inPtPl.get(player) != null) {
      Block block = (Block)this.inPtPl.get(player);
      this.inPt.remove(block);
      this.inPtPl.remove(player);
    }
  }

  @EventHandler(priority=EventPriority.HIGH)
  public void openPT(PlayerInteractEvent e) {
    if (e.getClickedBlock() == null) return;
    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

    if ((e.getClickedBlock().getTypeId() == this.pt_id) && (e.getClickedBlock().getData() == this.pt_subid)) {
      if (main.ptfix.equals("true"));
      Player player = e.getPlayer();
      Block block = e.getClickedBlock();
      if (this.inPt.get(block) == null) {
        this.inPt.put(block, player.getName());
        this.inPtPl.put(player.getName(), block);
      } else {
        if (((String)this.inPt.get(block)).equals(player.getName())) return;
        if (!canOpen(player).booleanValue()) {
          player.sendMessage(ChatColor.RED + this.message);
          this.clog.booleanValue();

          e.setCancelled(true);
        } else {
          this.clog.booleanValue();
        }
      }
    }
  }
}