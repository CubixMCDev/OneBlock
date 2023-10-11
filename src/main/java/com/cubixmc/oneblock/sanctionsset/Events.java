package com.cubixmc.oneblock.sanctionsset;

import com.cubixmc.oneblock.OneBlock;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.ChatColor;
import org.bukkit.SkullType;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.List;
import java.util.Collections;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.SkullMeta;

public class Events implements Listener
{
    private final FileConfiguration config;
    private final HashMap<Player, String> lasttarget;
    
    public Events(final FileConfiguration config, final HashMap<Player, String> lasttarget) {
        this.config = config;
        this.lasttarget = lasttarget;
    }
    
    @EventHandler
    public void onInventoryClicked(final InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        String inventoryName;
        try {
            inventoryName = e.getView().getTitle();
        }
        catch (NoSuchMethodError ex) {
            inventoryName = e.getView().getTitle();
        }
        if (inventoryName.startsWith("§4/ss")) {
            e.setCancelled(true);
            if (!inventoryName.endsWith(" (m)")) {
                final ItemStack head0 = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
                SkullMeta headMeta0 = (SkullMeta)head0.getItemMeta();
                headMeta0.setOwner(this.lasttarget.get(e.getWhoClicked()));
                headMeta0.setDisplayName(ChatColor.GOLD+this.lasttarget.get(e.getWhoClicked()));
                head0.setItemMeta(headMeta0);
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
                final ItemStack unban = new ItemStack(Material.OAK_BUTTON, 1);
                final ItemMeta unbanM = unban.getItemMeta();
                unbanM.setDisplayName("§cFin");
                unban.setItemMeta(unbanM);
                final ItemStack vitre = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
                final ItemMeta vitreM = vitre.getItemMeta();
                vitreM.setDisplayName("§7");
                vitre.setItemMeta(vitreM);
                if (e.getSlot() == 1) {
                    final ItemStack id1 = new ItemStack(Material.WOODEN_HOE, 1);
                    final ItemMeta id1M = id1.getItemMeta();
                    id1M.setDisplayName("§6Message(s) inutile(s)");
                    id1M.setLore((List)Collections.singletonList(""));
                    id1.setItemMeta(id1M);
                    final ItemStack id2 = new ItemStack(Material.GLASS_BOTTLE, 1);
                    final ItemMeta id2M = id2.getItemMeta();
                    id2M.setDisplayName("§6Fausse(s) information(s)");
                    id2M.setLore((List)Collections.singletonList(""));
                    id2.setItemMeta(id2M);
                    final ItemStack id3 = new ItemStack(Material.SKELETON_SKULL, 1);
                    final ItemMeta id3M = id3.getItemMeta();
                    id3M.setDisplayName("§6SMS");
                    id3M.setLore((List)Collections.singletonList(""));
                    id3.setItemMeta(id3M);
                    final ItemStack id4 = new ItemStack(Material.BREWING_STAND, 1);
                    final ItemMeta id4M = id4.getItemMeta();
                    id4M.setDisplayName("§6Formatage incorrect");
                    id4M.setLore((List)Collections.singletonList(""));
                    id4.setItemMeta(id4M);
                    final ItemStack id5 = new ItemStack(Material.DIAMOND_SWORD, 1);
                    final ItemMeta id5M = id5.getItemMeta();
                    id5M.setDisplayName("§6Vantardise");
                    id5M.setLore((List)Collections.singletonList(""));
                    id5.setItemMeta(id5M);
                    final ItemStack id6 = new ItemStack(Material.TNT, 1);
                    final ItemMeta id6M = id6.getItemMeta();
                    id6M.setDisplayName("§6Flood");
                    id6M.setLore((List)Collections.singletonList(""));
                    id6.setItemMeta(id6M);
                    final ItemStack id7 = new ItemStack(Material.ROTTEN_FLESH, 1);
                    final ItemMeta id7M = id7.getItemMeta();
                    id7M.setDisplayName("§6Mauvais langage");
                    id7M.setLore((List)Collections.singletonList(""));
                    id7.setItemMeta(id7M);
                    final ItemStack id8 = new ItemStack(Material.POTION, 1);
                    final ItemMeta id8M = id8.getItemMeta();
                    id8M.setDisplayName("§6Provocation(s)");
                    id8M.setLore((List)Collections.singletonList(""));
                    id8.setItemMeta(id8M);
                    final ItemStack id9 = new ItemStack(Material.TORCH, 1);
                    final ItemMeta id9M = id9.getItemMeta();
                    id9M.setDisplayName("§6Insulte(s)");
                    id9M.setLore((List)Collections.singletonList(""));
                    id9.setItemMeta(id9M);
                    final ItemStack id10 = new ItemStack(Material.ENDER_PEARL, 1);
                    final ItemMeta id10M = id10.getItemMeta();
                    id10M.setDisplayName("§6Incitation \u00e0 l'infraction");
                    id10M.setLore((List)Collections.singletonList(""));
                    id10.setItemMeta(id10M);
                    final ItemStack id11 = new ItemStack(Material.COMPARATOR, 1);
                    final ItemMeta id11M = id11.getItemMeta();
                    id11M.setDisplayName("§6Contournement protection-chat");
                    id11M.setLore((List)Collections.singletonList(""));
                    id11.setItemMeta(id11M);
                    final ItemStack id12 = new ItemStack(Material.BARRIER, 1);
                    final ItemMeta id12M = id12.getItemMeta();
                    id12M.setDisplayName("§6Lien(s) interdit(s)");
                    id12M.setLore((List)Collections.singletonList(""));
                    id12.setItemMeta(id12M);
                    final ItemStack id13 = new ItemStack(Material.WHITE_BANNER, 1);
                    final ItemMeta id13M = id13.getItemMeta();
                    id13M.setDisplayName("§6Publicit\u00e9");
                    id13M.setLore((List)Collections.singletonList(""));
                    id13.setItemMeta(id13M);
                    final ItemStack id14 = new ItemStack(Material.FISHING_ROD, 1);
                    final ItemMeta id14M = id14.getItemMeta();
                    id14M.setDisplayName("§6DDoS/Hack/Fake/Phishing");
                    id14M.setLore((List)Collections.singletonList(""));
                    id14.setItemMeta(id14M);
                    final ItemStack id15 = new ItemStack(Material.FLINT_AND_STEEL, 1);
                    final ItemMeta id15M = id15.getItemMeta();
                    id15M.setDisplayName("§6Menace(s) IRL");
                    id15M.setLore((List)Collections.singletonList(""));
                    id15.setItemMeta(id15M);
                    final Inventory Message = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Message§s§s");
                    e.getWhoClicked().openInventory(Message);
                    Message.setItem(9, vitre);
                    Message.setItem(10, vitre);
                    Message.setItem(11, vitre);
                    Message.setItem(12, vitre);
                    Message.setItem(13, vitre);
                    Message.setItem(14, vitre);
                    Message.setItem(15, vitre);
                    Message.setItem(16, vitre);
                    Message.setItem(17, vitre);
                    Message.setItem(0, head0);
                    Message.setItem(1, message);
                    if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                        Message.setItem(2, triche);
                        Message.setItem(3, jeu);
                        Message.setItem(4, abus);
                    }
                    if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                        Message.setItem(5, unban);
                    }
                    Message.setItem(18, id1);
                    Message.setItem(19, id2);
                    Message.setItem(20, id3);
                    Message.setItem(21, id4);
                    Message.setItem(22, id5);
                    Message.setItem(23, id6);
                    Message.setItem(24, id7);
                    Message.setItem(25, id8);
                    Message.setItem(26, id9);
                    Message.setItem(27, id10);
                    Message.setItem(28, id11);
                    Message.setItem(29, id12);
                    Message.setItem(30, id13);
                    Message.setItem(31, id14);
                    Message.setItem(32, id15);
                }
                if (e.getSlot() == 2) {
                    if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                        final ItemStack id1 = new ItemStack(Material.COBWEB, 1);
                        final ItemMeta id1M = id1.getItemMeta();
                        id1M.setDisplayName("§6Triche: Anti-Knockback");
                        id1M.setLore((List)Collections.singletonList(""));
                        id1.setItemMeta(id1M);
                        final ItemStack id2 = new ItemStack(Material.IRON_SWORD, 1);
                        final ItemMeta id2M = id2.getItemMeta();
                        id2M.setDisplayName("§6Triche: Forcefield/Killaura");
                        id2M.setLore((List)Collections.singletonList(""));
                        id2.setItemMeta(id2M);
                        final ItemStack id3 = new ItemStack(Material.CLOCK, 1);
                        final ItemMeta id3M = id3.getItemMeta();
                        id3M.setDisplayName("§6Triche: Timer/FastPlace");
                        id3M.setLore((List)Collections.singletonList(""));
                        id3.setItemMeta(id3M);
                        final ItemStack id4 = new ItemStack(Material.BOW, 1);
                        final ItemMeta id4M = id4.getItemMeta();
                        id4M.setDisplayName("§6Triche: Reach");
                        id4M.setLore((List)Collections.singletonList(""));
                        id4.setItemMeta(id4M);
                        final ItemStack id5 = new ItemStack(Material.STONE, 1);
                        final ItemMeta id5M = id5.getItemMeta();
                        id5M.setDisplayName("§6Triche: Autres");
                        id5M.setLore((List)Collections.singletonList(""));
                        id5.setItemMeta(id5M);
                        final ItemStack id6 = new ItemStack(Material.IRON_AXE, 1);
                        final ItemMeta id6M = id6.getItemMeta();
                        id6M.setDisplayName("§6Triche: Macro/Jitterclick");
                        id6M.setLore((List)Collections.singletonList(""));
                        id6.setItemMeta(id6M);
                        final ItemStack id7 = new ItemStack(Material.FEATHER, 1);
                        final ItemMeta id7M = id7.getItemMeta();
                        id7M.setDisplayName("§6Triche: Fly/Glide");
                        id7M.setLore((List)Collections.singletonList(""));
                        id7.setItemMeta(id7M);
                        final Inventory Triche = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Triche§s§s");
                        e.getWhoClicked().openInventory(Triche);
                        Triche.setItem(9, vitre);
                        Triche.setItem(10, vitre);
                        Triche.setItem(11, vitre);
                        Triche.setItem(12, vitre);
                        Triche.setItem(13, vitre);
                        Triche.setItem(14, vitre);
                        Triche.setItem(15, vitre);
                        Triche.setItem(16, vitre);
                        Triche.setItem(17, vitre);
                        Triche.setItem(0, head0);
                        Triche.setItem(1, message);
                        if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                            Triche.setItem(2, triche);
                            Triche.setItem(3, jeu);
                            Triche.setItem(4, abus);
                        }
                        if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                            Triche.setItem(5, unban);
                        }
                        Triche.setItem(18, id1);
                        Triche.setItem(19, id2);
                        Triche.setItem(20, id3);
                        Triche.setItem(21, id4);
                        Triche.setItem(22, id5);
                        Triche.setItem(23, id6);
                        Triche.setItem(24, id7);
                    }
                    else {
                        final ItemStack id1 = new ItemStack(Material.ANVIL, 1);
                        final ItemMeta id1M = id1.getItemMeta();
                        id1M.setDisplayName("§6Abus de signalement : message");
                        id1M.setLore((List)Collections.singletonList(""));
                        id1.setItemMeta(id1M);
                        final ItemStack id2 = new ItemStack(Material.EGG, 1);
                        final ItemMeta id2M = id2.getItemMeta();
                        id2M.setDisplayName("§6Abus de signalement : /report");
                        id2M.setLore((List)Collections.singletonList(""));
                        id2.setItemMeta(id2M);
                        final Inventory Abus = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Abus§s§s");
                        e.getWhoClicked().openInventory(Abus);
                        Abus.setItem(9, vitre);
                        Abus.setItem(10, vitre);
                        Abus.setItem(11, vitre);
                        Abus.setItem(12, vitre);
                        Abus.setItem(13, vitre);
                        Abus.setItem(14, vitre);
                        Abus.setItem(15, vitre);
                        Abus.setItem(16, vitre);
                        Abus.setItem(17, vitre);
                        Abus.setItem(0, head0);
                        Abus.setItem(1, message);
                        if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                            Abus.setItem(2, triche);
                            Abus.setItem(3, jeu);
                            Abus.setItem(4, abus);
                        }
                        if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                            Abus.setItem(5, unban);
                        }
                        Abus.setItem(18, id1);
                        Abus.setItem(19, id2);
                    }
                }
                if (e.getSlot() == 3) {
                    if (!e.getWhoClicked().hasPermission("moderator") && !e.getWhoClicked().isOp()) {
                        return;
                    }
                    final ItemStack id1 = new ItemStack(Material.LEGACY_RAW_FISH, 1);
                    final ItemMeta id1M = id1.getItemMeta();
                    id1M.setDisplayName("§6Alliance en \u00e9quipes");
                    id1M.setLore((List)Collections.singletonList(""));
                    id1.setItemMeta(id1M);
                    final ItemStack id2 = new ItemStack(Material.LEGACY_COOKED_FISH, 1);
                    final ItemMeta id2M = id2.getItemMeta();
                    id2M.setDisplayName("§6Alliance en solo");
                    id2M.setLore((List)Collections.singletonList(""));
                    id2.setItemMeta(id2M);
                    final ItemStack id3 = new ItemStack(Material.DIRT, 1);
                    final ItemMeta id3M = id3.getItemMeta();
                    id3M.setDisplayName("§6Construction incorrecte");
                    id3M.setLore((List)Collections.singletonList(""));
                    id3.setItemMeta(id3M);
                    final ItemStack id4 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                    final ItemMeta id4M = id4.getItemMeta();
                    id4M.setDisplayName("§6Skin incorrect");
                    id4M.setLore((List)Collections.singletonList(""));
                    id4.setItemMeta(id4M);
                    final ItemStack id5 = new ItemStack(Material.NAME_TAG, 1);
                    final ItemMeta id5M = id5.getItemMeta();
                    id5M.setDisplayName("§6Pseudonyme incorrect");
                    id5M.setLore((List)Collections.singletonList(""));
                    id5.setItemMeta(id5M);
                    final ItemStack id6 = new ItemStack(Material.FLINT_AND_STEEL, 1);
                    final ItemMeta id6M = id6.getItemMeta();
                    id6M.setDisplayName("§6Anti-jeux");
                    id6M.setLore((List)Collections.singletonList(""));
                    id6.setItemMeta(id6M);
                    final Inventory Jeu = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Gameplay§s§s");
                    e.getWhoClicked().openInventory(Jeu);
                    Jeu.setItem(9, vitre);
                    Jeu.setItem(10, vitre);
                    Jeu.setItem(11, vitre);
                    Jeu.setItem(12, vitre);
                    Jeu.setItem(13, vitre);
                    Jeu.setItem(14, vitre);
                    Jeu.setItem(15, vitre);
                    Jeu.setItem(16, vitre);
                    Jeu.setItem(17, vitre);
                    Jeu.setItem(0, head0);
                    Jeu.setItem(1, message);
                    if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                        Jeu.setItem(2, triche);
                        Jeu.setItem(3, jeu);
                        Jeu.setItem(4, abus);
                    }
                    if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                        Jeu.setItem(5, unban);
                    }
                    Jeu.setItem(18, id1);
                    Jeu.setItem(19, id2);
                    Jeu.setItem(20, id3);
                    Jeu.setItem(21, id4);
                    Jeu.setItem(22, id5);
                    Jeu.setItem(23, id6);
                }
                if (e.getSlot() == 4) {
                    if (!e.getWhoClicked().hasPermission("moderator") && !e.getWhoClicked().isOp()) {
                        return;
                    }
                    final ItemStack id1 = new ItemStack(Material.ANVIL, 1);
                    final ItemMeta id1M = id1.getItemMeta();
                    id1M.setDisplayName("§6Abus de signalement : message");
                    id1M.setLore((List)Collections.singletonList(""));
                    id1.setItemMeta(id1M);
                    final ItemStack id2 = new ItemStack(Material.EGG, 1);
                    final ItemMeta id2M = id2.getItemMeta();
                    id2M.setDisplayName("§6Abus de signalement : /report");
                    id2M.setLore((List)Collections.singletonList(""));
                    id2.setItemMeta(id2M);
                    final Inventory Abus = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Abus§s§s");
                    e.getWhoClicked().openInventory(Abus);
                    Abus.setItem(9, vitre);
                    Abus.setItem(10, vitre);
                    Abus.setItem(11, vitre);
                    Abus.setItem(12, vitre);
                    Abus.setItem(13, vitre);
                    Abus.setItem(14, vitre);
                    Abus.setItem(15, vitre);
                    Abus.setItem(16, vitre);
                    Abus.setItem(17, vitre);
                    Abus.setItem(0, head0);
                    Abus.setItem(1, message);
                    if (e.getWhoClicked().hasPermission("moderator") && !e.getWhoClicked().isOp()) {
                        Abus.setItem(2, triche);
                        Abus.setItem(3, jeu);
                        Abus.setItem(4, abus);
                    }
                    if (e.getWhoClicked().hasPermission("modmanager") && !e.getWhoClicked().isOp()) {
                        Abus.setItem(5, unban);
                    }
                    Abus.setItem(18, id1);
                    Abus.setItem(19, id2);
                }
                if (e.getSlot() == 5) {
                    if (!e.getWhoClicked().hasPermission("modmanager") && !e.getWhoClicked().isOp()) {
                        return;
                    }
                    final ItemStack id1 = new ItemStack(Material.LEVER, 1);
                    final ItemMeta id1M = id1.getItemMeta();
                    id1M.setDisplayName("§6Unban");
                    id1M.setLore((List)Collections.singletonList(""));
                    id1.setItemMeta(id1M);
                    final ItemStack id2 = new ItemStack(Material.PAPER, 1);
                    final ItemMeta id2M = id2.getItemMeta();
                    id2M.setDisplayName("§6Unmute");
                    id2M.setLore((List)Collections.singletonList(""));
                    id2.setItemMeta(id2M);
                    final Inventory Unban = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 Fin§s§s");
                    e.getWhoClicked().openInventory(Unban);
                    Unban.setItem(9, vitre);
                    Unban.setItem(10, vitre);
                    Unban.setItem(11, vitre);
                    Unban.setItem(12, vitre);
                    Unban.setItem(13, vitre);
                    Unban.setItem(14, vitre);
                    Unban.setItem(15, vitre);
                    Unban.setItem(16, vitre);
                    Unban.setItem(17, vitre);
                    Unban.setItem(0, head0);
                    Unban.setItem(1, message);
                    if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                        Unban.setItem(2, triche);
                        Unban.setItem(3, jeu);
                        Unban.setItem(4, abus);
                    }
                    if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                        Unban.setItem(5, unban);
                    }
                    Unban.setItem(18, id1);
                    Unban.setItem(19, id2);
                }
            }
        }
        if (inventoryName.endsWith("§s§s")) {
            final ItemStack warn = new ItemStack(Material.REDSTONE_TORCH, 1);
            final ItemMeta warnM = warn.getItemMeta();
            warnM.setDisplayName("§aAvertir/warn");
            warn.setItemMeta(warnM);
            final ItemStack vitreV = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE, 1);
            final ItemMeta vitreVM = vitreV.getItemMeta();
            vitreV.setItemMeta(vitreVM);
            final ItemStack vitreB = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
            final ItemMeta vitreBM = vitreB.getItemMeta();
            vitreB.setItemMeta(vitreBM);
            final ItemStack vitreJ = new ItemStack(Material.GREEN_STAINED_GLASS_PANE, 1);
            final ItemMeta vitreJM = vitreJ.getItemMeta();
            vitreJ.setItemMeta(vitreJM);
            final ItemStack porte = new ItemStack(Material.OAK_DOOR, 1);
            final ItemMeta porteM = porte.getItemMeta();
            porteM.setDisplayName("§cRetour");
            porteM.setLore((List)Collections.singletonList("Revenir au menu"));
            porte.setItemMeta(porteM);
            final ItemStack m1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta m1M = m1.getItemMeta();
            m1M.setDisplayName("§aMute 1 minute " + this.lasttarget.get(e.getWhoClicked()));
            m1.setItemMeta(m1M);
            final ItemStack m2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta m10M = m2.getItemMeta();
            m10M.setDisplayName("§aMute 10 minutes " + this.lasttarget.get(e.getWhoClicked()));
            m2.setItemMeta(m10M);
            final ItemStack m3 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta m30M = m3.getItemMeta();
            m30M.setDisplayName("§aMute 30 minutes " + this.lasttarget.get(e.getWhoClicked()));
            m3.setItemMeta(m30M);
            final ItemStack m4 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta m60M = m4.getItemMeta();
            m60M.setDisplayName("§aMute 60 minutes " + this.lasttarget.get(e.getWhoClicked()));
            m4.setItemMeta(m60M);
            final ItemStack j1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta j1M = j1.getItemMeta();
            j1M.setDisplayName("§aMute 1 jour " + this.lasttarget.get(e.getWhoClicked()));
            j1.setItemMeta(j1M);
            final ItemStack j2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta j7M = j2.getItemMeta();
            j7M.setDisplayName("§aMute 7 jours " + this.lasttarget.get(e.getWhoClicked()));
            j2.setItemMeta(j7M);
            final ItemStack j3 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta j30M = j3.getItemMeta();
            j30M.setDisplayName("§aMute 30 jours " + this.lasttarget.get(e.getWhoClicked()));
            j3.setItemMeta(j30M);
            final ItemStack a1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta a1M = a1.getItemMeta();
            a1M.setDisplayName("§aMute 1 an " + this.lasttarget.get(e.getWhoClicked()));
            a1.setItemMeta(a1M);
            final ItemStack a2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta a10M = a2.getItemMeta();
            a10M.setDisplayName("§aMute \u00e0 vie " + this.lasttarget.get(e.getWhoClicked()));
            a2.setItemMeta(a10M);
            final ItemStack bm1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bm1M = bm1.getItemMeta();
            bm1M.setDisplayName("§aBan 1 minute " + this.lasttarget.get(e.getWhoClicked()));
            bm1.setItemMeta(bm1M);
            final ItemStack bm2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bm10M = bm2.getItemMeta();
            bm10M.setDisplayName("§aBan 10 minutes " + this.lasttarget.get(e.getWhoClicked()));
            bm2.setItemMeta(bm10M);
            final ItemStack bm3 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bm30M = bm3.getItemMeta();
            bm30M.setDisplayName("§aBan 30 minutes " + this.lasttarget.get(e.getWhoClicked()));
            bm3.setItemMeta(bm30M);
            final ItemStack bm4 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bm60M = bm4.getItemMeta();
            bm60M.setDisplayName("§aBan 60 minutes " + this.lasttarget.get(e.getWhoClicked()));
            bm4.setItemMeta(bm60M);
            final ItemStack bj1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bj1M = bj1.getItemMeta();
            bj1M.setDisplayName("§aBan 1 jour " + this.lasttarget.get(e.getWhoClicked()));
            bj1.setItemMeta(bj1M);
            final ItemStack bj2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bj7M = bj2.getItemMeta();
            bj7M.setDisplayName("§aBan 7 jours " + this.lasttarget.get(e.getWhoClicked()));
            bj2.setItemMeta(bj7M);
            final ItemStack bj3 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta bj30M = bj3.getItemMeta();
            bj30M.setDisplayName("§aBan 30 jours " + this.lasttarget.get(e.getWhoClicked()));
            bj3.setItemMeta(bj30M);
            final ItemStack ba1 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta ba1M = ba1.getItemMeta();
            ba1M.setDisplayName("§aBan 1 an " + this.lasttarget.get(e.getWhoClicked()));
            ba1.setItemMeta(ba1M);
            final ItemStack ba2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta ba10M = ba2.getItemMeta();
            ba10M.setDisplayName("§aBan \u00e0 vie " + this.lasttarget.get(e.getWhoClicked()));
            ba2.setItemMeta(ba10M);
            final ItemStack unban2 = new ItemStack(Material.BARRIER, 1);
            final ItemMeta unbanM2 = unban2.getItemMeta();
            unbanM2.setDisplayName("§aUnban " + this.lasttarget.get(e.getWhoClicked()));
            unban2.setItemMeta(unbanM2);
            final ItemStack unmute = new ItemStack(Material.BARRIER, 1);
            final ItemMeta unmuteM = unmute.getItemMeta();
            unmuteM.setDisplayName("§aUnmute " + this.lasttarget.get(e.getWhoClicked()));
            unmute.setItemMeta(unmuteM);
            Inventory Confirm = null;
            if (inventoryName.endsWith("Message§s§s")) {
                if (e.getSlot() < 18 || e.getSlot() > 32) {
                    return;
                }
                switch (e.getSlot()) {
                    case 18: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Message inutile (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 19: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Fausse information (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 20: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 SMS (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 21: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Formatage incorrect (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 22: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Vantardise (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 23: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Flood (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 24: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Mauvais langage (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 25: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Provocation (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 26: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Insulte (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 27: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Incitation infraction (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 28: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Contournement (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 29: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Lien interdit (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 30: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Publicit\u00e9 (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 31: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 DDoS/Hack/Fake (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 32: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Menace(s) IRL (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                }
                Confirm.setItem(20, m1);
                Confirm.setItem(21, m2);
                Confirm.setItem(22, m3);
                Confirm.setItem(23, m4);
                Confirm.setItem(24, j1);
                Confirm.setItem(30, j2);
                Confirm.setItem(31, j3);
                Confirm.setItem(32, a1);
                Confirm.setItem(40, a2);
                Confirm.setItem(53, porte);
            }
            if (inventoryName.endsWith("Triche§s§s")) {
                if (e.getSlot() < 18 || e.getSlot() > 24) {
                    return;
                }
                switch (e.getSlot()) {
                    case 18: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Anti-Knockback (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 19: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Forcefield/Killaura (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 20: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Timer/Fastplace (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 21: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Reach (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 22: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Autres (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 23: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Macro/Jitterclick (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 24: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Fly/Glide (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                }
                Confirm.setItem(20, bm1);
                Confirm.setItem(21, bm2);
                Confirm.setItem(22, bm3);
                Confirm.setItem(23, bm4);
                Confirm.setItem(24, bj1);
                Confirm.setItem(30, bj2);
                Confirm.setItem(31, bj3);
                Confirm.setItem(32, ba1);
                Confirm.setItem(40, ba2);
                Confirm.setItem(53, porte);
            }
            if (inventoryName.endsWith("Gameplay§s§s")) {
                if (e.getSlot() < 18 || e.getSlot() > 23) {
                    return;
                }
                switch (e.getSlot()) {
                    case 18: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Alliance en \u00e9quipes (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 19: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Alliance en solo (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 20: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Construction incorrect (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 21: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Skin incorrect (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 22: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Pseudonyme incorrect (m)");
                        e.getWhoClicked().openInventory(Confirm);
                    }
                    case 23: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Anti-jeux (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                }
                Confirm.setItem(20, bm1);
                Confirm.setItem(21, bm2);
                Confirm.setItem(22, bm3);
                Confirm.setItem(23, bm4);
                Confirm.setItem(24, bj1);
                Confirm.setItem(30, bj2);
                Confirm.setItem(31, bj3);
                Confirm.setItem(32, ba1);
                Confirm.setItem(40, ba2);
                Confirm.setItem(53, porte);
            }
            if (inventoryName.endsWith("Abus§s§s")) {
                if (e.getSlot() < 18 || e.getSlot() > 19) {
                    return;
                }
                switch (e.getSlot()) {
                    case 18: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Abus : message (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                    case 19: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Abus : /report (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        break;
                    }
                }
                Confirm.setItem(20, m1);
                Confirm.setItem(21, m2);
                Confirm.setItem(22, m3);
                Confirm.setItem(23, m4);
                Confirm.setItem(24, j1);
                Confirm.setItem(30, j2);
                Confirm.setItem(31, j3);
                Confirm.setItem(32, a1);
                Confirm.setItem(40, a2);
                Confirm.setItem(53, porte);
            }
            if (inventoryName.endsWith("Fin§s§s")) {
                if (e.getSlot() < 18 || e.getSlot() > 19) {
                    return;
                }
                switch (e.getSlot()) {
                    case 18: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Unban (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        Confirm.setItem(31, unban2);
                        Confirm.setItem(53, porte);
                        break;
                    }
                    case 19: {
                        Confirm = Bukkit.createInventory((InventoryHolder)null, 54, "§4/ss§7 Unmute (m)");
                        e.getWhoClicked().openInventory(Confirm);
                        Confirm.setItem(31, unmute);
                        Confirm.setItem(53, porte);
                        break;
                    }
                }
            }
            Confirm.setItem(0, vitreV);
            Confirm.setItem(1, vitreV);
            Confirm.setItem(2, vitreV);
            Confirm.setItem(3, vitreV);
            Confirm.setItem(4, vitreV);
            Confirm.setItem(5, vitreV);
            Confirm.setItem(6, vitreV);
            Confirm.setItem(7, vitreV);
            Confirm.setItem(8, vitreV);
            Confirm.setItem(9, vitreV);
            Confirm.setItem(17, vitreV);
            Confirm.setItem(18, vitreV);
            Confirm.setItem(26, vitreV);
            Confirm.setItem(27, vitreV);
            Confirm.setItem(35, vitreV);
            Confirm.setItem(36, vitreV);
            Confirm.setItem(44, vitreV);
            Confirm.setItem(45, warn);
            Confirm.setItem(46, vitreV);
            Confirm.setItem(47, vitreV);
            Confirm.setItem(48, vitreV);
            Confirm.setItem(49, vitreV);
            Confirm.setItem(50, vitreV);
            Confirm.setItem(51, vitreV);
            Confirm.setItem(52, vitreV);
            Confirm.setItem(10, vitreB);
            Confirm.setItem(16, vitreB);
            Confirm.setItem(19, vitreB);
            Confirm.setItem(25, vitreB);
            Confirm.setItem(28, vitreB);
            Confirm.setItem(34, vitreB);
            Confirm.setItem(37, vitreB);
            Confirm.setItem(38, vitreB);
            Confirm.setItem(42, vitreB);
            Confirm.setItem(43, vitreB);
            Confirm.setItem(11, vitreJ);
            Confirm.setItem(12, vitreJ);
            Confirm.setItem(13, vitreJ);
            Confirm.setItem(14, vitreJ);
            Confirm.setItem(15, vitreJ);
            Confirm.setItem(29, vitreJ);
            Confirm.setItem(33, vitreJ);
            Confirm.setItem(39, vitreJ);
            Confirm.setItem(41, vitreJ);
        }
        if (inventoryName.endsWith(" (m)")) {
            if (e.getSlot() < 9) {
                return;
            }
            boolean warn2 = false;
            String time = null;
            Label_8877: {
                switch (e.getSlot()) {
                    case 20: {
                        time = " 1m";
                        break Label_8877;
                    }
                    case 21: {
                        time = " 10m";
                        break Label_8877;
                    }
                    case 22: {
                        time = " 30m";
                        break Label_8877;
                    }
                    case 23: {
                        time = " 60m";
                        break Label_8877;
                    }
                    case 24: {
                        time = " 1d";
                        break Label_8877;
                    }
                    case 30: {
                        time = " 7d";
                        break Label_8877;
                    }
                    case 31: {
                        time = " 30d";
                        break Label_8877;
                    }
                    case 32: {
                        time = " 365d";
                        break Label_8877;
                    }
                    case 40: {
                        if (!e.getWhoClicked().hasPermission("admin") && !e.getWhoClicked().isOp()) {
                            e.getWhoClicked().sendMessage("§cErreur : vous n'avez pas la permission de sanctionner \u00e0 vie.");
                            return;
                        }
                        time = "";
                        break Label_8877;
                    }
                    case 45: {
                        time = "";
                        warn2 = true;
                        break Label_8877;
                    }
                    case 53: {
                        final ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1, (short) SkullType.PLAYER.ordinal());
                        SkullMeta headMeta = (SkullMeta)head.getItemMeta();
                        headMeta.setOwner(this.lasttarget.get(e.getWhoClicked()));
                        headMeta.setDisplayName(ChatColor.GOLD+this.lasttarget.get(e.getWhoClicked()));
                        head.setItemMeta(headMeta);
                        final ItemStack message2 = new ItemStack(Material.PAPER, 1);
                        final ItemMeta messageMeta2 = message2.getItemMeta();
                        messageMeta2.setDisplayName("§cMessage");
                        message2.setItemMeta(messageMeta2);
                        final ItemStack triche2 = new ItemStack(Material.GOLDEN_APPLE, 1);
                        final ItemMeta tricheMeta2 = triche2.getItemMeta();
                        tricheMeta2.setDisplayName("§cTriche");
                        triche2.setItemMeta(tricheMeta2);
                        final ItemStack jeu2 = new ItemStack(Material.DIAMOND_AXE, 1);
                        final ItemMeta jeuMeta2 = jeu2.getItemMeta();
                        jeuMeta2.setDisplayName("§cGameplay");
                        jeu2.setItemMeta(jeuMeta2);
                        final ItemStack abus2 = new ItemStack(Material.BOOK, 1);
                        final ItemMeta abusMeta2 = abus2.getItemMeta();
                        abusMeta2.setDisplayName("§cAbus");
                        abus2.setItemMeta(abusMeta2);
                        final ItemStack unban3 = new ItemStack(Material.OAK_BUTTON, 1);
                        final ItemMeta unbanMeta = unban3.getItemMeta();
                        unbanMeta.setDisplayName("§cFin");
                        unban3.setItemMeta(unbanMeta);
                        final Inventory Ss = Bukkit.createInventory((InventoryHolder)null, 36, "§4/ss§7 " + this.lasttarget.get(e.getWhoClicked()));
                        e.getWhoClicked().openInventory(Ss);
                        Ss.setItem(0, head);
                        Ss.setItem(1, message2);
                        if (e.getWhoClicked().hasPermission("moderator") || e.getWhoClicked().isOp()) {
                            Ss.setItem(2, triche2);
                            Ss.setItem(3, jeu2);
                            Ss.setItem(4, abus2);
                        }
                        if (e.getWhoClicked().hasPermission("modmanager") || e.getWhoClicked().isOp()) {
                            Ss.setItem(5, unban3);
                        }
                        break;
                    }
                }
                return;
            }
            e.getWhoClicked().sendMessage("§6§lCubixGuard §e|Application de la sanction...");
            String motif = null;
            String type = null;
            if (inventoryName.endsWith("Message inutile (m)")) {
                motif = " Message(s) inutile(s)§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Fausse information (m)")) {
                motif = " Fausse(s) information(s)§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("SMS (m)")) {
                motif = " SMS§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Formatage incorrect (m)")) {
                motif = " Formatage incorrect§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Vantardise (m)")) {
                motif = " Vantardise§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Flood (m)")) {
                motif = " Flood§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Mauvais langage (m)")) {
                motif = " Mauvais langage§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Provocation (m)")) {
                motif = " Provocation§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Insulte (m)")) {
                motif = " Insulte(s)§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Incitation infraction (m)")) {
                motif = " Incitation \u00e0 l'infraction§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Contournement (m)")) {
                motif = " Contournement protection-tchat§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Lien interdit (m)")) {
                motif = " Lien(s) interdit(s)§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Publicit\u00e9 (m)")) {
                motif = " Publicit\u00e9§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("DDoS/Hack/Fake (m)")) {
                motif = " DDOS/Hack/Fake/Phishing§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Menace(s) IRL (m)")) {
                motif = " Menace(s) URL§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Pseudonyme incorrect (m)")) {
                motif = " Pseudonyme incorrect§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Anti-Knockback (m)")) {
                motif = " Anti-KnockBack§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Forcefield/Killaura (m)")) {
                motif = " ForceField/KillAura§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Timer/Fastplace (m)")) {
                motif = " Timer/FastPlace§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Reach (m)")) {
                motif = " Reach§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Autres (m)")) {
                motif = " Autres§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Macro/Jitterclick (m)")) {
                motif = " Macro/JitterClick§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Fly/Glide (m)")) {
                motif = " Fly/Glide§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Alliance en \u00e9quipes (m)")) {
                motif = " Alliance en \u00e9quipes§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Alliance en solo (m)")) {
                motif = " Alliance en solo§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Construction incorrect (m)")) {
                motif = " Construction incorrecte§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Skin incorrect (m)")) {
                motif = " Skin incorrect§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Anti-jeux (m)")) {
                motif = " Anti-jeux§m";
                type = "ban -s ";
            }
            if (inventoryName.endsWith("Abus : message (m)")) {
                motif = " Abus de signalement : messages§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Abus : /report (m)")) {
                motif = " Abus de signalement : /report§m";
                type = "mute -s ";
            }
            if (inventoryName.endsWith("Unban (m)")) {
                player.performCommand("unban " + this.lasttarget.get(e.getWhoClicked()) + " Unban");
                e.getWhoClicked().sendMessage("§6§lCubixGuard §e| Le joueur est d\u00e9banni !");
                e.getWhoClicked().closeInventory();
                motif = null;
                return;
            }
            if (inventoryName.endsWith("Unmute (m)")) {
                player.performCommand("unmute " + this.lasttarget.get(e.getWhoClicked()) + " Unmute");
                e.getWhoClicked().sendMessage("§6§lCubixGuard §e| La parole est rendue au joueur !");
                e.getWhoClicked().closeInventory();
                motif = null;
                return;
            }
            if (warn2) {
                player.performCommand("warn -s " + this.lasttarget.get(e.getWhoClicked()) + motif);
                e.getWhoClicked().sendMessage("§6§lCubixGuard §e| L'avertissement a \u00e9t\u00e9 appliqu\u00e9 !");
                return;
            }
            player.performCommand(type + this.lasttarget.get(e.getWhoClicked()) + " " + time + motif);
            e.getWhoClicked().sendMessage("§6§lCubixGuard §e| La sanction a \u00e9t\u00e9 appliqu\u00e9e !");
            e.getWhoClicked().sendMessage("§6§lCubixGuard §e| " + this.lasttarget.get(e.getWhoClicked()) + " §ea \u00e9t\u00e9 sanctionn\u00e9 par un mod\u00e9rateur");
            e.getWhoClicked().closeInventory();
        }
    }
}
