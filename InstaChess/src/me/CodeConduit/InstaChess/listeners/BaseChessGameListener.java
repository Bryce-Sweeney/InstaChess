package me.CodeConduit.InstaChess.listeners;

import me.CodeConduit.InstaChess.Main;
import me.CodeConduit.InstaChess.uis.BaseChessGameUI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BaseChessGameListener implements Listener {
    //Variables
    private Main plugin;
    //Standard constructor for listeners
    public BaseChessGameListener(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getTitle();
        if (title.equals(BaseChessGameUI.inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (title.equals(BaseChessGameUI.inventory_name)) {
                BaseChessGameUI.clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
            }
        }
    }
}
