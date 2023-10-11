package com.cubixmc.oneblock.listeners;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.plugin.Plugin;

public class ListenerManager {
    private OneBlock plugin = OneBlock.getInstance();

    public void setup() {
        this.plugin.getServer().getPluginManager().registerEvents(new ChatMessageListener(), (Plugin)this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), (Plugin)this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), (Plugin)this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new Entities(), (Plugin)this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new Redstone(), this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new Entities(), this.plugin);
        this.plugin.getServer().getPluginManager().registerEvents(new Protect(), this.plugin);
    }
}
