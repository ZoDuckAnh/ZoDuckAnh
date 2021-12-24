package antimistake.main;

import filesmanage.files;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands implements CommandExecutor {

    public String c(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        Player p = (Player) s;
        if(label.equalsIgnoreCase("am")){
            if (args.length >= 1) {
                if (s.hasPermission("am.admin")) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        files.reload();
                        s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Reload")));
                        return false;
                    }
                    if (files.cf().getInt("Mode") == 1) {
                        if (args[0].equalsIgnoreCase(files.cf().getString("Password"))) {
                            if (Main.wl.contains(p)) {
                                Main.wl.remove(p);
                                s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Success")));
                                return false;
                            } else {
                                s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Confirmed")));
                                return false;
                            }
                        } else {
                            if (Main.wl.contains(p)) {
                                if (files.cf().getBoolean("AM.KickWrong") == true) {
                                    p.kickPlayer(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Wrong")));
                                }
                                s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Wrong")));
                                return false;
                            } else {
                                s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Confirmed")));
                                return false;
                            }
                        }
                    }
                    if (files.cf().getInt("Mode") == 2) {
                        if (files.dt().getString(p.getName()) == null) {
                            if (Main.wl.contains(p)) {
                                s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.SetPass")));
                                return false;
                            }
                        }
                            if (args[0].equalsIgnoreCase("setpass")) {
                                if (args[1] == null) {
                                    s.sendMessage("nhập pass dô");
                                    return false;
                                } else {
                                    files.dt().set(p.getName(), args[1]);
                                    return false;
                                }
                            }
                                if (args[0].equalsIgnoreCase(files.dt().getString(p.getName()))) {
                                    Main.wl.remove(p);
                                    s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Success")));
                                } else {
                                    if (files.cf().getBoolean("AM.KickWrong") == true) {
                                        p.kickPlayer(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Wrong")));
                                    }
                                    s.sendMessage(c(files.cf().getString("Prefix") + " " + files.cf().getString("Message.Wrong")));
                                    return false;

                        }
                    }

                return false;

                }
            }
            s.sendMessage(c(""));
            s.sendMessage(c("&e&l&m------------&e&l AntiMistake &e&l&m------------"));
            s.sendMessage(c("&b /am: &fhelp"));
            s.sendMessage(c("&b /am reload: &freload config"));
            s.sendMessage(c("&a /am <password>"));
            s.sendMessage(c("&a /am setpass <password>"));
            }

        return false;
    }
}
