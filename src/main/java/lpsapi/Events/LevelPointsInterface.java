package lpsapi.Events;

import org.bukkit.entity.Player;

public interface LevelPointsInterface {


     void giveEXP(Player player, int EXP);

     public int checkEXP(Player player);
}
