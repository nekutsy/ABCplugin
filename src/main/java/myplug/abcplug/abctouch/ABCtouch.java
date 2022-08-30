package myplug.abcplug.abctouch;

import com.google.common.eventbus.Subscribe;
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
        event.getPlayer().chat(event.getClickedBlock().getType().toString());
    }
}
