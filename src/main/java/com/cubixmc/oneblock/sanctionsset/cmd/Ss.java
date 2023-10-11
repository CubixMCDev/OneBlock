package com.cubixmc.oneblock.sanctionsset.cmd;

import com.cubixmc.oneblock.OneBlock;
import org.bukkit.ChatColor;
import org.bukkit.SkullType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.inventory.meta.SkullMeta;

public class Ss implements CommandExecutor
{
    private OneBlock main;
    
    public Ss(final OneBlock main) {
        this.main = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!sender.hasPermission("helper") && !sender.isOp()) {
            sender.sendMessage("Commande inconnue.");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("§cUtilisez : /" + label + " <joueur>");
            return true;
        }
        if (!(sender instanceof Player)) {
            sender.sendMessage("Vous ne pouvez pas ouvrir de menu en console.");
            return true;
        }
        if (args[0].length() > 16) {
            sender.sendMessage("§cErreur : les joueurs ne peuvent pas d\u00e9passer seize caract\u00e8res !");
            return true;
        }
        if (this.main.getConfig().getStringList("ss.immune").contains(args[0].toLowerCase())) {
            sender.sendMessage("§cErreur : vous ne pouvez pas sanctionner ce joueur.");
            return true;
        }
        final Player mod = (Player)sender;
        final ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta headMeta = (SkullMeta)head.getItemMeta();
        headMeta.setOwner(args[0]);
        headMeta.setDisplayName(ChatColor.GOLD+args[0]);
        head.setItemMeta(headMeta);

        final ItemStack message = new ItemStack(Material.PAPER, 1);
        final ItemMeta messageMeta = message.getItemMeta();
        messageMeta.setDisplayName("§cMessage");
        message.setItemMeta(messageMeta);
        final ItemStack triche = new ItemStack(Material.GOLDEN_APPLE, 1);
        final ItemMeta tricheMeta = triche.getItemMeta();
        tricheMeta.setDisplayName("§cTriche");
        triche.setItemMeta(tricheMeta);
        final ItemStack jeu = new ItemStack(Material.DIAMOND_AXE, 1);
        final ItemMeta jeuMeta = jeu.getItemMeta();
        jeuMeta.setDisplayName("§cGameplay");
        jeu.setItemMeta(jeuMeta);
        final ItemStack abus = new ItemStack(Material.BOOK, 1);
        final ItemMeta abusMeta = abus.getItemMeta();
        abusMeta.setDisplayName("§cAbus");
        abus.setItemMeta(abusMeta);
        final ItemStack unban = new ItemStack(Material.OAK_BUTTON);
        final ItemMeta unbanMeta = unban.getItemMeta();
        unbanMeta.setDisplayName("§cFin");
        unban.setItemMeta(unbanMeta);
        final Inventory Ss = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 " + args[0]);
        mod.openInventory(Ss);
        Ss.setItem(0, head);
        Ss.setItem(1, message);
        if (sender.hasPermission("moderator") || sender.isOp()) {
            Ss.setItem(2, triche);
            Ss.setItem(3, jeu);
            Ss.setItem(4, abus);
        }
        if (sender.hasPermission("modmanager") || sender.isOp()) {
            Ss.setItem(5, unban);
        }
        OneBlock.getSanctionned().lasttarget.put(mod, args[0]);
        return true;
    }
}
