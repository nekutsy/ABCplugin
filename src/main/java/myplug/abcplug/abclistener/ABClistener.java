package myplug.abcplug.abclistener;

import myplug.abcplug.ABCplug;

import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.event.player.PlayerJoinEvent;

public class ABClistener implements Listener {
@EventHandler
    public void onChat(AsyncChatEvent event) {
    event.renderer((source, sourceDisplayName, message, viewer) ->
            Component.text()
                    .append(sourceDisplayName.color(TextColor.fromHexString("#00AA00")))
                    .append(Component.text(">>>").color(TextColor.fromHexString("#008800")))
                    .append(message.color(TextColor.fromHexString("#AAAAAA")))
                    .build());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        try {
            event.getPlayer().sendMessage(Component.text(ABCplug.config.getString("join")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
