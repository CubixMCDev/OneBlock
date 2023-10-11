package com.cubixmc.oneblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WebSite implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){
            sender.sendMessage("Seul un joueur peut executer cette commande !");
            return false;
        }

        Player player = (Player) sender;

        if(label.equalsIgnoreCase("vote")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eVote : §nhttps://cubixmc.fr/vote");
            return false;
        }

        if(label.equalsIgnoreCase("store")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eBoutique : §nhttps://cubixmc.fr/shop");
            return false;
        }

        if(label.equalsIgnoreCase("site")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eSite : §nhttps://cubixmc.fr");
            return false;
        }

        if(label.equalsIgnoreCase("youtube")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eYouTube : §nhttps://youtube.com/@cubixmc8561");
            return false;
        }

        if(label.equalsIgnoreCase("twitter")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eX (Twitter) : §nhttps://twitter.com/CubixMCFR");
            return false;
        }

        if(label.equalsIgnoreCase("instagram")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eInstagram : §nhttps://instagram.com/CubixMC/");
            return false;
        }

        if(label.equalsIgnoreCase("tiktok")){
            player.sendMessage("§6§lRéseaux Sociaux §e| §eTikTok : §nhttps://www.tiktok.com/@CubixMCOFF");
            return false;
        }

        return false;
    }
}
