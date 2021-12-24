package listen;

import antimistake.main.Main;
import filesmanage.files;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;

public class cancel implements Listener {

    Main jc;
    public String c(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    @EventHandler
    public void c1(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void c2(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void c3(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void cs(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void c4(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void c5(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                p.sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }


    public void c6(AsyncPlayerChatEvent e) {
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                e.getPlayer().sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        if (jc.wl.contains(e.getPlayer())) {
            e.setCancelled(true);
            if (files.cf().getBoolean("AM.SpamMsg"))
                e.getPlayer().sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (jc.wl.contains(p.getPlayer()))
                e.setCancelled(true);
        }
    }


    public void onPlayerChat(PlayerCommandPreprocessEvent e) {
        if (jc.wl.contains(e.getPlayer()))
            if (e.getMessage().startsWith("/am") || e.getMessage().startsWith("/l") || e.getMessage().startsWith("/login") || e.getMessage().startsWith("/reg") || e.getMessage().startsWith("/register")) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
                if (files.cf().getBoolean("AM.SpamMsg"))
                    e.getPlayer().sendMessage(c(String.valueOf(String.valueOf(files.cf().getString("Prefix"))) + " " + files.cf().getString("Message.IsStaff")));
            }
    }
}
