package me.playerblock;

import me.playerblock.commands.MainCommand;
import me.playerblock.entity.PlayerManager;
import me.playerblock.listeners.PlayerEvents;
import me.playerblock.utils.MYSQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerBlock extends JavaPlugin {

    private static MYSQL mysql;
    private static PlayerManager playerManager;
    private static PlayerBlock instance;

    @Override
    public void onEnable() {
        instance = this;
        mysql = new MYSQL("root", "vertrigo", "localhost", 3306, "playerblock");
        playerManager = new PlayerManager();

        register();
    }

    public void register() {
        getCommand("blocos").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
    }

    public static PlayerBlock getInstance() {
        return instance;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static MYSQL getMySQL() {
        return mysql;
    }
}
