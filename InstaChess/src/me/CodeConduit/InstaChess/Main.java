package me.CodeConduit.InstaChess;

import me.CodeConduit.InstaChess.commands.ChessAccept;
import me.CodeConduit.InstaChess.commands.ChessRequest;
import me.CodeConduit.InstaChess.listeners.BaseChessGameListener;
import me.CodeConduit.InstaChess.listeners.ChessActivator;
import me.CodeConduit.InstaChess.uis.BaseChessGameUI;
import org.bukkit.plugin.java.JavaPlugin;

/*
        __________________________________________________________
       / /                                                   / /\ \
       \_\___________________________________________________\_\/ /
       / /    _____    __            __                    / /
      / /    / ____\  / /           /_/          /\       / /
     / /    / /__    / /___  ___   __  ______ __/ /_     / /
    / /     \___ \  /   __/ / __\ / / / __  //_  __/    / /
   / /     ____/ / / /\ \  / /   / / / /_/ /  / /      / /
  / /     \_____/ /_/ /_/ /_/   /_/ / ____/  /_/      / /__
 / /    ========================== / / ==========    / / \ \
| |                               /_/               | |   | |
 \_\_________________________________________________\_\_/_/
*/

public class Main extends JavaPlugin {

    //Activates on startup
    public void onEnable() {
        enableCommands(true);
        enableListeners(true);
        BaseChessGameUI.initialize();
    }

    //Method for enabling/disabling all listeners
    public void enableListeners(Boolean enable) {
        if (enable) {
            new ChessActivator(this);
            new BaseChessGameListener(this);
        }
    }

    //Method for enabling/disabling all commands
    public void enableCommands(Boolean enable) {
        if (enable) {
            new ChessRequest(this);
            new ChessAccept(this);
        }
    }
}
