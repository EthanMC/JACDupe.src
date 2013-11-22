package me.ethanmilford.jacdupe;

import me.ethanmilford.jacdupe.noclick;
import me.ethanmilford.jacdupe.ptfix;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin
{
  public static String eeclick;
  public static String ptfix;
  public static String rmfurnace;
  public static String tankcart;
  public static String alchfix;
  public static String alchblockbreakerfix;
  public static String alchtpfix;
  public static String autotableblockbreakerfix;

  public void onEnable()
  {
    saveDefaultConfig();
    eeclick = getConfig().getString("eeclick");
    ptfix = getConfig().getString("ptfix");
    tankcart = getConfig().getString("tankcart");
    rmfurnace = getConfig().getString("rmfurnace");
    alchfix = getConfig().getString("alchfix");
    alchtpfix = getConfig().getString("alchtpfix");
    alchblockbreakerfix = getConfig().getString("alchblockbreakerfix");
    autotableblockbreakerfix = getConfig().getString("autotableblockbreakerfix");

    getServer().getPluginManager().registerEvents(new ptfix(), this);
    getServer().getPluginManager().registerEvents(new alchchestplaceblockbreaker(), this);
    getServer().getPluginManager().registerEvents(new noclick(), this);
    getServer().getPluginManager().registerEvents(new alchfix(), this);
    getServer().getPluginManager().registerEvents(new dupes(), this);
    getServer().getPluginManager().registerEvents(new alchtpfix(), this);
    getServer().getPluginManager().registerEvents(new blockbreakerplaceautotable(), this);
    getServer().getPluginManager().registerEvents(new blockbreakerplacealchchest(), this);
    getServer().getPluginManager().registerEvents(new autotableplaceblockbreaker(), this);
  }
}