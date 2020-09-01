package me.CodeConduit.InstaChess.commands;

import me.CodeConduit.InstaChess.Main;
import me.CodeConduit.InstaChess.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        //Check if their on the request list
        if (ChessRequest.requestedPlayers.contains(sender.getName())) {
            index = ChessRequest.requestedPlayers.indexOf(sender.getName());

            //Sending sender and receiver confirmation messages
            Bukkit.getPlayer(ChessRequest.requestSenders.get(index)).sendMessage(Utils.chat("&6Your chess request has been accepted by&a " + sender.getName() + "&6!"));
            sender.sendMessage(Utils.chat("&6You have accepted the chess request!"));

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
