package com.codelog.uhcutils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class UhcUtilsPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling UHC Utils...");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling UHC Utils...");
    }
}
