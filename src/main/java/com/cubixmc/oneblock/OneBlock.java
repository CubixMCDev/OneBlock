package com.cubixmc.oneblock;

import com.cubixmc.oneblock.api.PAPIExpansion;
import com.cubixmc.oneblock.commands.*;
import com.cubixmc.oneblock.hooks.HookManager;
import com.cubixmc.oneblock.listeners.*;
import com.cubixmc.oneblock.sanctionsset.Reload;
import com.cubixmc.oneblock.sanctionsset.cmd.Ss;
import com.cubixmc.oneblock.utils.FormatColors;
import com.cubixmc.oneblock.sanctionsset.Events;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OneBlock extends JavaPlugin implements CommandExecutor {

    private final String prefix = FormatColors.format("[" + getDescription().getPrefix() + "] ");

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    public static HookManager hooks = new HookManager();

    private static OneBlock instance;

    public CommandManager commandManager;

    public ListenerManager listenerManager;

    public Permission perms = null;

    public HashMap<Player, String> lasttarget = new HashMap<>();

    public static OneBlock getSanctionned() {
        return instance;
    }

    String command = "stop";

    public void onEnable() {
        instance = this;
        loadChannels();

        this.commandManager = new CommandManager();
        this.listenerManager = new ListenerManager();
        this.listenerManager.setup();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Bukkit.getLogger().info(this.prefix + "Plugin enabled.");
        if (hooks.isVaultHooked()) {
            Bukkit.getLogger().info(this.prefix + "Successfully hooked with Vault.");
            setupPermissions();
        } else {
            Bukkit.getLogger().info(this.prefix + "Couldn't hook with Vault.");
        }
        if (hooks.isPlaceholderAPIHooked()) {
            Bukkit.getLogger().info(this.prefix + "Successfully hooked with PlaceholderAPI.");
        } else {
            Bukkit.getLogger().info(this.prefix + "Couldn't hook with PlaceholderAPI.");
        }

        getCommand("ss").setExecutor(new Ss(this));
        getCommand("cubixmc").setExecutor(new Reload(this));
        getCommand("vote").setExecutor(new WebSite());
        getCommand("store").setExecutor(new WebSite());
        getCommand("site").setExecutor(new WebSite());
        getCommand("youtube").setExecutor(new WebSite());
        getCommand("twitter").setExecutor(new WebSite());
        getCommand("instagram").setExecutor(new WebSite());
        getCommand("bienvenue").setExecutor(new Welcome());

        new PAPIExpansion().register();

        if (isNew()) {
            getServer().getPluginManager().registerEvents(new Events(getConfig(), this.lasttarget), this);
        }

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask((Plugin)this, new Runnable() {
            public void run() {
                DateFormat dateformat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String first = OneBlock.this.getConfig().getString("restart.time");
                String beforefirst = OneBlock.this.getConfig().getString("restart.before1time");
                String beforetwo = OneBlock.this.getConfig().getString("restart.before2time");
                String beforethree = OneBlock.this.getConfig().getString("restart.before3time");
                if (dateformat.format(date).equals(beforethree))
                    Bukkit.dispatchCommand(OneBlock.this.console, "broadcast Redémarrage du serveur dans 1 minute");
                if (dateformat.format(date).equals(beforetwo))
                    Bukkit.dispatchCommand(OneBlock.this.console, "broadcast Redémarrage du serveur dans 5 minutes");
                if (dateformat.format(date).equals(beforefirst))
                    Bukkit.dispatchCommand(OneBlock.this.console, "broadcast Redémarrage du serveur dans 10 minutes");
                if (dateformat.format(date).equals(first)) {
                    Bukkit.dispatchCommand(OneBlock.this.console, "broadcast Redémarrage du serveur en cours...");
                    Bukkit.dispatchCommand(OneBlock.this.console, OneBlock.this.command);
                }
            }
        },0L, 1200L);
    }

    @Override
    public void onDisable() {
        this.perms = null;
    }

    public static OneBlock getInstance() {
        return instance;
    }

    private void loadChannels(){
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        this.perms = (Permission)rsp.getProvider();
        return (this.perms != null);
    }

    private boolean isNew() {
        return (Integer.parseInt(Bukkit.getBukkitVersion().split("\\.")[1]) >= 13);
    }

    public String getNewestPlayer() {
        if (Welcome.welcome.get("Welcome") != null)
            return Welcome.welcome.get("Welcome");
        return "Noone";
    }
}