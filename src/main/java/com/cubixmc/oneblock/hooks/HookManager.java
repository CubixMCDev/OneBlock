package com.cubixmc.oneblock.hooks;

import org.bukkit.Bukkit;

public class HookManager {
    public boolean isPlaceholderAPIHooked() {
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
            return true;
        return false;
    }

    public boolean isVaultHooked() {
        if (Bukkit.getPluginManager().isPluginEnabled("Vault"))
            return true;
        return false;
    }
}
