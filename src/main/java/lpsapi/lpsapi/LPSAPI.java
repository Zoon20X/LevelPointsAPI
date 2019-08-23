package lpsapi.lpsapi;

import levelpoints.lp.LP;
import lpsapi.Events.EXP;
import lpsapi.Events.LevelPointsInterface;
import lpsapi.Events.LevelUP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LPSAPI extends JavaPlugin implements LPSAPIInterface {
    public LevelUP levelupevent;
    private LP lpapi;


    public EXP exp;


    @Override
    public void onEnable() {
        // Plugin startup logic

        lpapi = (LP) Bukkit.getServer().getPluginManager().getPlugin("LP");

        if (lpapi != null) {
            exp = new EXP();

            getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "=============================");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "LevelPoints API");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Developer: Zoon20X");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Version: " + this.getDescription().getVersion());
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "LevelPoints: " + lpapi.getDescription().getVersion());
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_AQUA + "Enabled");
            getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "=============================");
        }else{
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "=============================");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "LevelPoints API");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Developer: Zoon20X");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Version: " + this.getDescription().getVersion());
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Not Running LevelPoints");
            getServer().getConsoleSender().sendMessage(ChatColor.DARK_RED + "Disabled");
            getServer().getConsoleSender().sendMessage(ChatColor.RED + "=============================");
            Bukkit.getPluginManager().disablePlugin(this);
        }



    }

    @Override
    public void LevelUpEventTrigger(Player player, int level){
        LevelUP levelupevent = new LevelUP(player, level); // Initialize your Event
        Bukkit.getPluginManager().callEvent(levelupevent); // This fires the event and allows any listener to listen to the event
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
