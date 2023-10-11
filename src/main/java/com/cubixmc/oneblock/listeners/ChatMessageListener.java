package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import com.cubixmc.oneblock.hooks.VaultHook;
import com.cubixmc.oneblock.utils.FormatPlaceholders;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMessageListener implements Listener {
    private OneBlock plugin = OneBlock.getInstance();

    private String group;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (this.plugin.getConfig().getBoolean("enabled") &&
                this.plugin.getConfig().getBoolean("MessageFormat.enabled")) {
            if (this.plugin.perms != null) {
                this.group = VaultHook.getGroup(event.getPlayer());
            } else {
                this.group = "default";
            }
            event.setFormat(FormatPlaceholders.format(event.getPlayer(), this.plugin.getConfig().getString("MessageFormat." + this.group), event.getMessage()).replaceAll("%", "%%"));
        }
    }
}