package lpsapi.Events;

import levelpoints.lp.LP;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class EXP implements LevelPointsInterface {
    private LP lpapi = (LP) Bukkit.getServer().getPluginManager().getPlugin("LP");

    @Override
    public void giveEXP(Player player, int EXP){
        try {
            lpapi.CustomXP(player, EXP, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int checkEXP(Player player){
        File userdata = new File(lpapi.userFolder, player.getUniqueId() + ".yml");
        FileConfiguration UsersConfig = YamlConfiguration.loadConfiguration(userdata);

        int expamount = UsersConfig.getInt(player.getName() + ".EXP.Amount");

       return expamount;

    }

    @Override
    public int checkLevel(Player player){
        File userdata = new File(lpapi.userFolder, player.getUniqueId() + ".yml");
        FileConfiguration UsersConfig = YamlConfiguration.loadConfiguration(userdata);
        int level = UsersConfig.getInt(player.getName() + ".level");

        return level;

    }
}
