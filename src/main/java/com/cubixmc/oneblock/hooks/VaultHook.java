package com.cubixmc.oneblock.hooks;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.entity.Player;

public class VaultHook {
    private static OneBlock plugin = OneBlock.getInstance();

    public static String getGroup(Player player) {
        return plugin.perms.getPrimaryGroup(player);
    }
}
