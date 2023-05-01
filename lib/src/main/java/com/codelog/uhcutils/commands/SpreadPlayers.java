package com.codelog.uhcutils.commands;

import java.util.Random;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SpreadPlayers implements CommandExecutor {
    public SpreadPlayers() {

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        if (args.length != 2) {
            Bukkit.getLogger().log(Level.INFO,
                    "uspread command called with incorrect number of arguments: " + args.length);
            sender.sendMessage("Incorrect number of arguments!");
            return false;
        }

        int minorRadius, majorRadius;
        try {
            minorRadius = Integer.parseInt(args[0]);
            majorRadius = Integer.parseInt(args[1]);
        } catch (Exception e) {
            sender.sendMessage("Couldn't parse radii!");
            return true;
        }

        if (minorRadius >= majorRadius) {
            sender.sendMessage("Minor radius must be strictly smaller than major radius!");
            return true;
        }

        Bukkit.getLogger().log(Level.INFO, String.format("Executing command /uspread with args: {}", (Object[]) args));
        var onlinePlayers = Bukkit.getOnlinePlayers().iterator();
        var sectorSize = Math.PI * 2.0 / Bukkit.getOnlinePlayers().size();
        for (int i = 0; i < Bukkit.getOnlinePlayers().size(); i++) {
            var player = onlinePlayers.next();
            var angle = sectorSize * i;
            var radius = new Random().nextInt(majorRadius - minorRadius + 1) + minorRadius;
            var posX = (int) Math.floor(radius * Math.cos(angle));
            var posZ = (int) Math.floor(radius * Math.sin(angle));

            player.teleport(
                    new Location(player.getWorld(), posX, player.getWorld().getHighestBlockYAt(posX, posZ), posZ));
        }

        return true;
    }
}
