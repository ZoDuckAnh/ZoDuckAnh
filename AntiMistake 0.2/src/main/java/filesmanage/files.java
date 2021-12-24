package filesmanage;

import antimistake.main.Main;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class files {

    public static File cffile;
    public static FileConfiguration cf;
    public static File datafile;
    public static FileConfiguration dt;

    public static void setup(Main pl) {

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdirs();
        }
        cffile = new File(pl.getDataFolder(), "config.yml");

        datafile = new File(pl.getDataFolder(), "data.yml");
        if (!cffile.exists()) {
            pl.saveResource("config.yml", true);
            pl.getServer().getConsoleSender().sendMessage(pl.c(pl.prefix + "&eCouldn't load config, create config file"));
        }
        if (!datafile.exists()) {
            pl.saveResource("data.yml", true);
            pl.getServer().getConsoleSender().sendMessage(pl.c(pl.prefix + "&eCouldn't load data, create data file"));
        }
            cf = YamlConfiguration.loadConfiguration(cffile);
            cf.options().copyDefaults(true);
            dt = YamlConfiguration.loadConfiguration(datafile);
        dt.options().copyDefaults(true);

    }
    public static Configuration cf(){
        return cf;
    }
    public static Configuration dt(){
        return dt;
    }
 public static void reload(){
        cf = YamlConfiguration.loadConfiguration(cffile);
     dt = YamlConfiguration.loadConfiguration(datafile);
 }

}
