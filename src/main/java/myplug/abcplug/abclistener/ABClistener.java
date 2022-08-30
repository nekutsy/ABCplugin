package myplug.abcplug.abclistener;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;

public class ABClistener implements Listener {
@EventHandler
    public void onChat(AsyncChatEvent event) {
    event.renderer((source, sourceDisplayName, message, viewer) ->
            Component.text()
                    .append(sourceDisplayName)
                    .append(Component.text(">>"))
                    .append(message)
                    .build());
    }
}
