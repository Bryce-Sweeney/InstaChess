package me.CodeConduit.InstaChess.uis;

import me.CodeConduit.InstaChess.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BaseChessGameUI {

    public static Inventory inv;
    public static String inventory_name;
    public static int inv_rows = 6 * 9;

    public static void initialize(){
        inventory_name = Utils.chat("&e&lChessBoard");

        inv = Bukkit.createInventory(null, inv_rows);
    }

    public static Inventory GUI (Player p) {

        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        Utils.createItem(inv, 219, 1, 51, Utils.chat("&lWhite King"), "Can move into any unoccupied and", "non-threatened square.");

        toReturn.setContents(inv.getContents());
        return toReturn;
    }

    //Do things when certain items are clicked.
    public static void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(Utils.chat("&lWhite King"))) {
            p.sendMessage(Utils.chat("&6You have selected the white king! Please select the area you want to put him in."));
        }
    }
}
