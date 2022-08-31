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
    File configFile;
    File groupsFile;
    File usersFile;
    File historyFile;
    public static FileConfiguration config;
    public static FileConfiguration groups;
    public static FileConfiguration users;
    public static FileConfiguration history;
    private static ABCplug instance;
    public static ABCplug getInstance() {
        return instance;
    }
    private void firstRun() throws Exception {
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
        if (!groupsFile.exists()) {
            groupsFile.getParentFile().mkdirs();
            copy(getResource("groups.yml"), groupsFile);
        }
        if (!usersFile.exists()) {
            usersFile.getParentFile().mkdirs();
            copy(getResource("users.yml"), usersFile);
        }
        if (!historyFile.exists()) {
            historyFile.getParentFile().mkdirs();
            copy(getResource("history.yml"), historyFile);
        }
    }
    @Override
    public void onEnable() {
        instance = this;
        configFile = new File(getDataFolder(), "config.yml");
        groupsFile = new File(getDataFolder(), "groups.yml");
        usersFile = new File(getDataFolder(), "users.yml");
        historyFile = new File(getDataFolder(), "history.yml");

        config = new YamlConfiguration();
        groups = new YamlConfiguration();
        users = new YamlConfiguration();
        history = new YamlConfiguration();
        loadYamls();

        Bukkit.getPluginManager().registerEvents(new ABClistener(), this);
        Bukkit.getPluginManager().registerEvents(new ABCtouch(), this);
    }
    @Override
    public void onDisable(){
        saveYamls();
    }
    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadYamls() {
        try {
            config.load(configFile);
            groups.load(groupsFile);
            users.load(usersFile);
            history.load(historyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveYamls() {
        try {
            config.save(configFile);
            groups.save(groupsFile);
            users.save(usersFile);
            history.save(historyFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}