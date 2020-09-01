package me.CodeConduit.InstaChess;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    //Method for ease of use color chat
    public static String chat (String a) {
        return ChatColor.translateAlternateColorCodes('&', a);
    }

    //Method for placing an item stack
    public static ItemStack createItemByte(Inventory inv, int materialID, int byteId, int amount, int invslot, String displayName, String... loreString){

        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Material.getMaterial(String.valueOf(materialID)), amount, (short) byteId);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(invslot - 1, item);
        return item;
    }
}