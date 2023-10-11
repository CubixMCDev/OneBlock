package com.cubixmc.oneblock.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockRedstoneEvent;

public class Redstone implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    private void onPistonExtendEvent(BlockPistonExtendEvent e) {
        e.getBlock().setType(Material.STONE);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    private void onPistonRetractEvent(BlockPistonRetractEvent e) {
        e.getBlock().setType(Material.STONE);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void onBlockDisable(BlockRedstoneEvent e) {
        int current = e.getOldCurrent();
        e.setNewCurrent(current);
    }
}
