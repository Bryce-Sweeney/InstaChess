package me.CodeConduit.InstaChess;

import me.CodeConduit.InstaChess.commands.ChessAccept;
import me.CodeConduit.InstaChess.commands.ChessRequest;
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
    }

    //Method for enabling/disabling all listeners
    public void enableListeners(Boolean enable) {
        if (enable) {

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
