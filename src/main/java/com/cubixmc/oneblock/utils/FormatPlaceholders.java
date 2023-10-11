package com.cubixmc.oneblock.utils;

import com.cubixmc.oneblock.hooks.HookManager;
import com.cubixmc.oneblock.hooks.PlaceholderAPIHook;

import org.bukkit.entity.Player;

public class FormatPlaceholders {
    public static HookManager hooks = new HookManager();

    public static String format(Player player, String string, String message) {
        if (hooks.isPlaceholderAPIHooked())
            string = PlaceholderAPIHook.format(player, string);
        string = string.replaceAll("\\{player\\}", player.getName());
        string = string.replaceAll("\\{displayName\\}", player.getDisplayName());
        if (message != "")
            string = string.replaceAll("\\{message\\}", message);
        return string;
    }
}
