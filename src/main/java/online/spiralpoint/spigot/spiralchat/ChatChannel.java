package online.spiralpoint.spigot.spiralchat;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ChatChannel {

    private static final ConcurrentMap<String, ChatChannel> CHAT_CHANNEL_MAP = new ConcurrentHashMap<>();

    public enum Mode {
        GLOBAL_SERVER, GLOBAL_WORLD, GLOBAL_GROUP, LOCAL_WORLD, LOCAL_GROUP, DIRECT_PLAYER;
    }

    private final String name;
    private final ChatChannel.Mode mode;
    private final List<Player> playerList;

    private ChatChannel(@NotNull final String name, @NotNull final ChatChannel.Mode mode) {
        this.name = name;
        this.mode = mode;
        this.playerList = new ArrayList<>();
    }

    private ChatChannel(@NotNull final String name, @NotNull final ChatChannel.Mode mode, @NotNull final List<Player> players) {
        this.name = name;
        this.mode = mode;
        this.playerList = players;
    }

    public void addPlayer(@NotNull final Player player) {
        if(this.playerList.contains(player)) return;
        this.playerList.add(player);
    }

    public void removePlayer(@NotNull final Player player) {
        this.playerList.remove(player);
    }

    public String getName() {
        return this.name;
    }

    public ChatChannel.Mode getMode() {
        return this.mode;
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public Player[] getPlayers() {
        return this.playerList.toArray(new Player[0]);
    }

}
