package me.CodeConduit.InstaChess;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils {
    //Method for ease of use color chat
    public static String chat (String a) {
        return ChatColor.translateAlternateColorCodes('&', a);
    }

    //Methods for easy itemstack creation
    public static ItemStack createItem(Inventory inv, int materialID, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Objects.requireNonNull(Material.getMaterial(String.valueOf(materialID))), amount);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
    public static ItemStack createItemByte(Inventory inv, int materialID, short byteID, int amount, int invSlot, String displayName, String... loreString) {
        ItemStack item;
        List<String> lore = new ArrayList();

        item = new ItemStack(Objects.requireNonNull(Material.getMaterial(String.valueOf(materialID))), amount, byteID);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(Utils.chat(displayName));
        for (String s : loreString) {
            lore.add(Utils.chat(s));
        }
        meta.setLore(lore);
        item.setItemMeta(meta);

        inv.setItem(invSlot - 1, item);
        return item;
    }
}