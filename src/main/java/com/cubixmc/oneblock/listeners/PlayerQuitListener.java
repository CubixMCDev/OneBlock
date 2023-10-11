package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import com.cubixmc.oneblock.utils.FormatColors;
import com.cubixmc.oneblock.utils.FormatPlaceholders;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    private OneBlock plugin = OneBlock.getInstance();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        if (this.plugin.getConfig().getBoolean("enabled") &&
                this.plugin.getConfig().getBoolean("onQuitMessage.enabled"))
            event.setQuitMessage(FormatColors.format(FormatPlaceholders.format(event.getPlayer(), this.plugin.getConfig().getString("onQuitMessage.message"), "")));
    }
}
