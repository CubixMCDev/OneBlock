package com.cubixmc.oneblock.sanctionsset;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Reload implements CommandExecutor
{
    private final OneBlock main;
    
    public Reload(final OneBlock main) {
        this.main = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!sender.hasPermission("admin") && !sender.isOp()) {
            sender.sendMessage("Commande inconnue.");
            return false;
        }
        if (args.length != 1 || (!args[0].equalsIgnoreCase("rl") && !args[0].equalsIgnoreCase("reload"))) {
            sender.sendMessage("§cUsage : /" + label + " rl");
            return false;
        }
        this.main.reloadConfig();
        sender.sendMessage("§a§nSucc\u00e8s§r§a : La configuration a \u00e9t\u00e9 reload.");
        return false;
    }
}
