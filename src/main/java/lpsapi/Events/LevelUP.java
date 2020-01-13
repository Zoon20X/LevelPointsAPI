package lpsapi.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LevelUP extends Event {

    private final Player player;
    private final int level;

    private static final HandlerList HANDLERS = new HandlerList();

    public LevelUP(Player player, int level) {
        this.player = player;
        this.level = (level + 1);
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getLevel() {
        return this.level;
    }

}
