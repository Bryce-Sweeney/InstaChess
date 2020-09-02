package me.CodeConduit.InstaChess.commands;

import me.CodeConduit.InstaChess.Main;
import me.CodeConduit.InstaChess.Utils;
import me.CodeConduit.InstaChess.events.ChessActivateEvent;
import me.CodeConduit.InstaChess.listeners.ChessActivator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChessAccept implements CommandExecutor {
    //Variables
    private Main plugin;

    //Standard constructor for a command
    public ChessAccept(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("chessAccept").setExecutor(this);
    }

    //Command executor
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        //Variables
        int index;
        Player player = (Player) sender;
        //Check if their on the request list
        if (ChessRequest.requestedPlayers.contains(sender.getName())) {
            index = ChessRequest.requestedPlayers.indexOf(sender.getName());

            //Test if the player already has an active game
            if (ChessRequest.activePlayers.contains(player.getName())) {
                player.sendMessage(Utils.chat("&cYou already have an active game!"));
                return false;
            }

            //Sending sender and receiver confirmation messages
            Bukkit.getPlayer(ChessRequest.requestSenders.get(index)).sendMessage(Utils.chat("&6Your chess request has been accepted by&a " + sender.getName() + "&6!"));
            sender.sendMessage(Utils.chat("&6You have accepted the chess request!"));

            //Calling custom ChessActivate event
            Bukkit.getServer().getPluginManager().callEvent(new ChessActivateEvent(Bukkit.getPlayer(ChessRequest.requestSenders.get(index)), player));

            //Adding players to the list of active players
            ChessRequest.activePlayers.add(Bukkit.getPlayer(ChessRequest.requestSenders.get(index)).getName());
            ChessRequest.activePlayers.add(sender.getName());

            //Cleaning up old entries on the list
            ChessRequest.requestedPlayers.remove(index);
            ChessRequest.requestSenders.remove(index);
            return true;
        } else {
            //Player does not have a request, and it has failed.
            sender.sendMessage(Utils.chat("&cYou do not have any incoming requests."));
            return false;
        }
    }
}
