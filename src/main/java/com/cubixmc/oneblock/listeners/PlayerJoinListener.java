package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import com.cubixmc.oneblock.commands.Welcome;
import com.cubixmc.oneblock.utils.FormatColors;
import com.cubixmc.oneblock.utils.FormatPlaceholders;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private OneBlock plugin = OneBlock.getInstance();

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        if (this.plugin.getConfig().getBoolean("enabled"))
            if (!event.getPlayer().hasPlayedBefore()) {
                if (this.plugin.getConfig().getBoolean("onFirstJoinMessage.enabled")) {
                    event.setJoinMessage(FormatColors.format(FormatPlaceholders.format(event.getPlayer(), this.plugin.getConfig().getString("onFirstJoinMessage.message"), "")));
                    if(!event.getPlayer().hasPermission("staff.use")) {
                        Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set isnew true");
                    }
                }
            } else if (this.plugin.getConfig().getBoolean("onJoinMessage.enabled")) {
                event.setJoinMessage(FormatColors.format(FormatPlaceholders.format(event.getPlayer(), this.plugin.getConfig().getString("onJoinMessage.message"), "")));
            }

        if (!event.getPlayer().hasPlayedBefore()) {
            Welcome.welcome.clear();
            Welcome.welcome.put("Welcome", event.getPlayer().getName());
        }
    }
}
