package com.codelog.uhcutils;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import com.codelog.uhcutils.commands.SpreadPlayers;

public class UhcUtilsPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Enabling UHC Utils...");
        var uspread = getCommand("uspread");
        if (uspread == null) {
            Bukkit.getLogger().log(Level.SEVERE, "Couldn't get handle for command 'uspread'");
            return;
        }

        uspread.setExecutor(new SpreadPlayers());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabling UHC Utils...");
    }
}
