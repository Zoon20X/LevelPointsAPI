package lpsapi.Events;

import levelpoints.levelpoints.LevelPoints;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.io.File;
import java.io.IOException;

public class EXP implements LevelPointsInterface {
    private LevelPoints lpapi = (LevelPoints) Bukkit.getServer().getPluginManager().getPlugin("LevelPoints");

    @Override
    public void giveEXP(Player player, int EXP){
        lpapi.uc.GainEXP(player, EXP);

    }

    @Override
    public int checkEXP(Player player){
        File userdata = new File(lpapi.userFolder, player.getUniqueId() + ".yml");
        FileConfiguration UsersConfig = YamlConfiguration.loadConfiguration(userdata);

        int expamount = UsersConfig.getInt("EXP.Amount");

       return expamount;

    }

    @Override
    public int checkLevel(Player player){
        File userdata = new File(lpapi.userFolder, player.getUniqueId() + ".yml");
        FileConfiguration UsersConfig = YamlConfiguration.loadConfiguration(userdata);
        int level = UsersConfig.getInt("Level");

        return level;

    }
}
