package me.CodeConduit.InstaChess.commands;

import me.CodeConduit.InstaChess.Main;
import me.CodeConduit.InstaChess.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ChessRequest<RequestedPlayers> implements CommandExecutor {
    //Variables +  Lists
    private Main plugin;
    static List<String> requestedPlayers=new ArrayList<String>();
    static List<String> requestSenders=new ArrayList<String>();

    //Standard constructor for a command
    public ChessRequest(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("chessRequest").setExecutor(this);
    }

    //Actual command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        //Variables
        boolean secondActive;
        //Redefining sender for ease of use
        Player player = (Player) sender;
        if (args.length == 0 || args.length > 2) {
            //The player has imputed an incorrect number of arguments
            player.sendMessage(Utils.chat("&c/requestChess {player} [timeout]"));
            return false;
        } else {
            for (Player sent : Bukkit.getOnlinePlayers()) {
                if (sent.getName().toLowerCase().equals(args[0].toLowerCase())) {
                    //Is the second argument active? If so, enable the second argument section.
                    if (args.length == 2)
                        secondActive = true;

                    //Does the receiver already have a request, is so, don't send
                    if (requestedPlayers.contains(sender.getName()) || requestSenders.contains(sender.getName())) {
                        sender.sendMessage(Utils.chat("&cThat player already has a pending request."));
                        return false;
                    }

                    //Does the sender already have a request, if so, don't send
                    if (requestedPlayers.contains(player.getName()) || requestSenders.contains(player.getName())) {
                        player.sendMessage(Utils.chat("&cYou already have an outgoing request!"));
                        return false;
                    }

                    //Execute request sending
                    requestedPlayers.add(sent.getName());
                    requestSenders.add(player.getName());
                    sent.sendMessage(Utils.chat("&aCodeConduit &6has sent you a chess request!"));
                    sent.sendMessage(Utils.chat("&6Do &a/chessAccept &6to accept!"));
                    return true;
                }
            }
            //The player does not exist, has not played on the server, or is not online
            player.sendMessage(Utils.chat("&cThe player you mentioned either does not exist, has not joined this server, or is not online right now."));
        }
        //Something very bad has gone wrong, and it skipped over all of the returns.
        return false;
    }
}
