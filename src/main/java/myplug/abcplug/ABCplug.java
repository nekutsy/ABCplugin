package myplug.abcplug;

import myplug.abcplug.abctouch.ABCtouch;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import myplug.abcplug.abclistener.ABClistener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public final class ABCplug extends JavaPlugin {
    static File configFile;
    public static FileConfiguration config;

    private static ABCplug instance;
    public static ABCplug getInstance() {
        return instance;
    }

    private void configInit() {
        configFile = new File(getDataFolder(), "config.yml");
        loadYamls();
    }
    public void saveYamls() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadYamls() {
        try {
            config.load(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onEnable() {
        instance = this;
        loadYamls();
        Bukkit.getPluginManager().registerEvents(new ABClistener(), this);
        Bukkit.getPluginManager().registerEvents(new ABCtouch(), this);
    }

    @Override
    public void onDisable() {
        saveYamls();
    }
}