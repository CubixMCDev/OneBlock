package com.cubixmc.oneblock.hooks;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

public class PlaceholderAPIHook {
    public static String format(Player player, String message) {
        return PlaceholderAPI.setPlaceholders(player, message);
    }
}
