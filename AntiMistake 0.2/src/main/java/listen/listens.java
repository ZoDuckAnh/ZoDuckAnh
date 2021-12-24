package listen;

import daantiop.Main;
import filesmanage.files;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class listens implements Listener {

    Main das;
    antimistake.main.Main pl;

    public listens(antimistake.main.Main instance) {
        pl = instance;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
            if (p.hasPermission(files.cf().getString("PermCheck"))) {
                if (!pl.wl.contains(p)) {
                    pl.wl.add(p);
                }
        }
            int i2 = files.cf().getInt("Cooldown.Time");
        if (pl.wl.contains(p)) {
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(pl, new Runnable() {
                public void run() {
                    if (pl.wl.contains(p)) {
                        pl.getServer().dispatchCommand((CommandSender) pl.getServer().getConsoleSender(), ChatColor.translateAlternateColorCodes('&', files.cf().getString("Cooldown.Event").replace("%p", p.getName())));
                    }
                }
            } ,i2 * 20L);
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(pl.wl.contains(e.getPlayer())) {
            pl.wl.remove(e.getPlayer());
        }
    }

}
