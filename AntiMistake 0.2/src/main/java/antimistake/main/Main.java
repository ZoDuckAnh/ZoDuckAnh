package antimistake.main;

import filesmanage.files;
import listen.cancel;
import listen.listens;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public String c(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String prefix = "&8&l[&3&lAntiMistake&8&l] ";

    public static ArrayList<Player> wl = new ArrayList<>();

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new listens(this), this);
        pm.registerEvents(new cancel(), this);
        getCommand("am").setExecutor(new commands());
        files.setup(this);
        if (files.cf().getInt("Mode") == 1) {
            getServer().getConsoleSender().sendMessage(c(prefix + "&eMode: 1"));
        }
        if (files.cf().getInt("Mode") == 2) {
            getServer().getConsoleSender().sendMessage(c(prefix + "&eMode: 2"));
        }
        if (files.cf().getInt("Mode") != 1 && files.cf().getInt("Mode") != 2) {
            getServer().getConsoleSender().sendMessage(c(prefix + "&cInvaild mode, disable plugin!"));
        }
        getServer().getConsoleSender().sendMessage(c("&e&l--------------- AntiMistake ---------------"));
        getServer().getConsoleSender().sendMessage(c(" "));
        getServer().getConsoleSender().sendMessage(c("   &eVersion: 0.2.0"));
        getServer().getConsoleSender().sendMessage(c("   &eAuthor: Cattori - Salmon"));
        getServer().getConsoleSender().sendMessage(c(" "));
    }

    @Override
    public void onDisable() {
    }
}
