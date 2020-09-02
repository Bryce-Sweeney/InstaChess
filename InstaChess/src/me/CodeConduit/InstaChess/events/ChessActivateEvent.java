package me.CodeConduit.InstaChess.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChessActivateEvent extends Event {
    //Variables
    Player sender;
    Player receiver;

    //Constructor
    public ChessActivateEvent(Player sender, Player receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    //Event parameters
    public Player getSender() {
        return sender;
    }

    public Player getReceiver() {
        return receiver;
    }

    //Handler stuff
    private static final HandlerList handlers = new HandlerList();
    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList(){
        return handlers;
    }
}