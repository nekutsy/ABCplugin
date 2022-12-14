package myplug.abcplug.abctouch;

import com.google.common.eventbus.Subscribe;
import myplug.abcplug.ABCplug;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Event;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.bukkit.event.block.Action;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import sun.security.provider.ConfigFile;
import javax.security.auth.login.Configuration;
import java.nio.channels.FileChannel;
import org.bukkit.command.CommandSender;
import org.bukkit.command.MessageCommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.command.BufferedCommandSender;
import org.bukkit.Bukkit;

public class ABCtouch implements Listener {
    @EventHandler
    public void BlockBreakEvent(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null) {
            try {
                Block b = event.getClickedBlock();
                Player p = event.getPlayer();
                FileConfiguration conf = ABCplug.config;
                FileConfiguration userConf = ABCplug.users;

                //p.chat(b.getType().toString());
                String name = "x" + b.getX() + "y" + b.getY() + "z" + b.getZ();
                if (conf.contains(name)) {
                    if (!userConf.contains(p.getName())) {
                        userConf.createSection(p.getName());
                    } else {
                        if (conf.getString(name + ".name") != null && !userConf.contains(p.getName() + "." + conf.getString(name + ".name"))) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), conf.getString(name + ".command").replace("_player", p.getName()));
                            userConf.set(p.getName() + "." + conf.getString(name + ".name"), name);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /*

    @EventHandler
    public void PlayerInteractEvent(@NotNull Player who, @NotNull Action action, @Nullable ItemStack item, @Nullable Block clickedBlock, @NotNull BlockFace clickedFace) {
        if (action.isLeftClick()) {
            try {
                Block b = clickedBlock;
                Player p = who;
                FileConfiguration conf = ABCplug.config;
                FileConfiguration userConf = ABCplug.users;

                //p.chat(b.getType().toString());
                String name = "x" + b.getX() + "y" + b.getY() + "z" + b.getZ();
                if (conf.contains(name)) {
                    if (!userConf.contains(p.getName())) {
                        userConf.createSection(p.getName());
                    } else {
                        if (conf.getString(name + ".name") != null && !userConf.contains(p.getName() + "." + conf.getString(name + ".name"))) {
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), conf.getString(name + ".command").replace("_player", p.getName()));
                            userConf.set(p.getName() + "." + conf.getString(name + ".name"), name);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     */
}

/*
                p.sendMessage(Component.text("+9999999 MONEY"));
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), conf.getString(name + ".command"));
                userConf.set(p.getName() + "." + conf.getString(name + ".name"), name);
 */