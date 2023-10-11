package com.cubixmc.oneblock.commands;

import java.util.HashMap;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Welcome implements CommandExecutor {
    public static HashMap<String, String> welcome = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', OneBlock.getInstance().getConfig().getString("welcome.not-player")));
            return true;
        }
        Player player = (Player)sender;
        if (OneBlock.getInstance().getNewestPlayer().equalsIgnoreCase("Noone")) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', OneBlock.getInstance().getConfig().getString("welcome.already-welcome")));
            return true;
        }
        player.chat(OneBlock.getInstance().getConfig().getString("welcome.message").replace("%newplayer%", OneBlock.getInstance().getNewestPlayer()));
        return true;
    }
}
