package me.playerblock.listeners;

import me.playerblock.entity.PlayerOBJ;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import static me.playerblock.PlayerBlock.*;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        getPlayerManager().loadPlayer(p.getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        getPlayerManager().savePlayer(getPlayerManager().getPlayer(p.getName()));
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        Player p = e.getPlayer();
        PlayerOBJ po = getPlayerManager().getPlayer(p.getName());

        po.setQuantidade(po.getQuantidade() + 1);
    }

}
