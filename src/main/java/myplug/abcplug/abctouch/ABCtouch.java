package myplug.abcplug.abctouch;

import com.google.common.eventbus.Subscribe;
import myplug.abcplug.ABCplug;
import net.kyori.adventure.text.Component;
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

public class ABCtouch implements Listener {
    @EventHandler
    public void BlockBreakEvent(PlayerInteractEvent event) {
        Block b = event.getClickedBlock();
        Player p = event.getPlayer();
        FileConfiguration conf = ABCplug.config;
        FileConfiguration userConf = ABCplug.users;

        p.chat(b.getType().toString());
        String name = "x" + b.getX() + "y" + b.getY() + "z" + b.getZ();
        if (conf.contains(name) && !userConf.contains(conf.getString(name))) {
            p.sendMessage(Component.text("+9999999 MONEY"));
            userConf.set(p.getName() + "." + conf.getString(name), name);

        }
    }
}
