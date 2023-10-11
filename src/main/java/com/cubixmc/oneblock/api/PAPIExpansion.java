package com.cubixmc.oneblock.api;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class PAPIExpansion extends PlaceholderExpansion {
    @Override
    public String getIdentifier() {
        return "cubixmc";
    }

    @Override
    public String getAuthor() {
        return "PipoSurMC";
    }

    @Override
    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String params) {
        if(player == null) {
            return "";
        }
        if (params.equals("test")) {
            //return "" + this.fd.getTokens(player);
        }
        return null;
    }
}
