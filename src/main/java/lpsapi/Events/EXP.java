package lpsapi.Events;

import levelpoints.lp.LP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class EXP implements LevelPointsInterface {
    private LP lpapi = (LP) Bukkit.getServer().getPluginManager().getPlugin("LP");

    @Override
    public void giveEXP(Player player, int EXP){
        lpapi.CustomXP(player, EXP, 0);

    }

    @Override
    public int checkEXP(Player player){
        int expamount = lpapi.getPlayersConfig().getInt(player.getName() + ".EXP.Amount");

       return expamount;

    }
}
