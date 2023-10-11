package com.cubixmc.oneblock.utils;

import org.bukkit.ChatColor;

public class FormatColors {
    public static String format(String string) {
        string = ChatColor.translateAlternateColorCodes('&', string);
        return string;
    }
}
