package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import com.cubixmc.oneblock.utils.FormatColors;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class Protect implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();

        if (player.getWorld().getName().equals("oneblock")) {
            if (location.getBlockY() <= OneBlock.getInstance().getConfig().getInt("protect.ycoord")) {
                player.sendMessage(FormatColors.format(OneBlock.getInstance().getConfig().getString("protect.messages.fallspawn")));
                player.performCommand("spawn");
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPreprocess(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
        if(player.hasPermission("isnew")) {
            e.setCancelled(true);
            player.sendMessage(FormatColors.format(OneBlock.getInstance().getConfig().getString("protect.messages.tutorial")));
        }
    }
}
