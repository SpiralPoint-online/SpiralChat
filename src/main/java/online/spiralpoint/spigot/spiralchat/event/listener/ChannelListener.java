package online.spiralpoint.spigot.spiralchat.event.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class ChannelListener implements Listener {

    private static ChannelListener INSTANCE;

    public static ChannelListener instance() {
        if(INSTANCE == null) INSTANCE = new ChannelListener();
        return INSTANCE;
    }

    private ChannelListener() {}

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        //TODO: Check what channel the player is using and output to that channel.
    }

}
