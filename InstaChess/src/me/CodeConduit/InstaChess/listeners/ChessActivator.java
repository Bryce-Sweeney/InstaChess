package me.CodeConduit.InstaChess.listeners;

import me.CodeConduit.InstaChess.Main;
import me.CodeConduit.InstaChess.Utils;
import me.CodeConduit.InstaChess.events.ChessActivateEvent;
import me.CodeConduit.InstaChess.uis.BaseChessGameUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

@SuppressWarnings("SpellCheckingInspection")
public class ChessActivator implements Listener {
    //Variables
    private Main plugin;
    ArrayList<String> CbookLore = new ArrayList<>();

    //Standard constructor for listeners
    public ChessActivator(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //Listener for this class
    @EventHandler
    public void ChessActivateEvent(ChessActivateEvent e) {
        //Redefining for ease of use
        Player S = e.getSender();
        Player R = e.getReceiver();
        S.openInventory(BaseChessGameUI.GUI(R));
    }
}
