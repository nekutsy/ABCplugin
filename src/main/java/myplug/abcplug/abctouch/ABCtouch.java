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
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.entity.EntityInteractEvent;


public abstract class ABCtouch implements Player {
    @Subscribe
    public void EntityInteractEvent(@NotNull Player who, @NotNull Action action, @Nullable ItemStack item, @Nullable Block clickedBlock, @NotNull BlockFace clickedFace) {
        who.chat("тык");
    }
}
