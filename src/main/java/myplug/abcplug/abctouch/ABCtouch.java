package myplug.abcplug.abctouch;

import com.google.common.eventbus.Subscribe;
import myplug.abcplug.ABCplug;
import net.kyori.adventure.text.Component;
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

public class ABCtouch implements Listener {
    @EventHandler
    public void BlockBreakEvent(PlayerInteractEvent event) {
        Block b = event.getClickedBlock();
        Player p = event.getPlayer();

        p.chat(b.getType().toString());
        String name = "x" + b.getX() + "y" + b.getY() + "z" + b.getZ();
        if (ABCplug.config.contains(name)) {
            p.sendMessage(Component.text("+9999999 MONEY"));
            ABCplug.users.set(p.getName().toString() + name, true);
        }
        ABCplug.users.set(p.getName().toString() + name, true);
    }
}
