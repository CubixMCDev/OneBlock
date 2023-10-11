package com.cubixmc.oneblock.commands;

import com.cubixmc.oneblock.OneBlock;
import com.cubixmc.oneblock.utils.FormatColors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {

    private OneBlock plugin = OneBlock.getInstance();

    private String prefix = FormatColors.format("&6&lCubixMC &e| ");

    private String version = FormatColors.format("&6&lCubixMC &e| version &8[&c" + this.plugin.getDescription().getVersion() + "&8]");

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("cubixmc"))
            if (args.length == 0) {
                sender.sendMessage(this.version);
            } else if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    executeReload(sender);
                } else if (args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("v")) {
                    executeVersion(sender);
                } else {
                    sender.sendMessage("Commande inconnue.");
                }
            }
        return true;
    }

    private Boolean checkPermission(CommandSender sender, String command) {
        if (sender.hasPermission("chatformat." + command))
            return Boolean.valueOf(true);
        sender.sendMessage("Commande inconnue.");
        return Boolean.valueOf(false);
    }

    private void executeReload(CommandSender sender) {
        if (checkPermission(sender, "reload").booleanValue()) {
            this.plugin.reloadConfig();
            sender.sendMessage(this.prefix + FormatColors.format("&eRechargé !"));
        }
    }

    private void executeVersion(CommandSender sender) {
        sender.sendMessage(this.version);
    }
}
