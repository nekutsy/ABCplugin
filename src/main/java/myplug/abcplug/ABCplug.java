package myplug.abcplug;

import myplug.abcplug.abctouch.ABCtouch;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import myplug.abcplug.abclistener.ABClistener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Event;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.bukkit.event.block.Action;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;


public final class ABCplug extends JavaPlugin {
    private static ABCplug instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ABClistener(), this);
        Bukkit.getPluginManager().registerEvents(new ABCtouch(), this);
    }

}

/*
    @Override
    public void PlayerInteractEvent(@NotNull Player who, @NotNull Action action, @Nullable ItemStack item, @Nullable Block clickedBlock, @NotNull BlockFace clickedFace) {

    }
 */
