package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class Entities implements Listener {

    final Vector vec = new Vector();

    @EventHandler
    public void onPlayerHit(final EntityDamageByEntityEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            Entity p = e.getEntity();
            Player damager = (Player) e.getDamager();
            Bukkit.getScheduler().runTaskLater(OneBlock.getInstance(), () -> p.setVelocity(vec), 1l);
        }
    }
}
