package myplug.abcplug;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import myplug.abcplug.abclistener.ABClistener;

public final class ABCplug extends JavaPlugin {
    private static ABCplug instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ABClistener(), this);
    }
}
