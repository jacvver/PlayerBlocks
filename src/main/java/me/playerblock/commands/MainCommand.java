package me.playerblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.playerblock.PlayerBlock.*;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
        if (!(s instanceof Player)) return false;
        Player p = (Player) s;

        if (c.getName().equalsIgnoreCase("blocos")) {
            if (args.length == 0) {
                p.sendMessage(" ");
                p.sendMessage("§7Blocos quebrados: " + getPlayerManager().getPlayer(p.getName()).getQuantidade());
                p.sendMessage(" ");
                return true;
            }
        }

        return false;
    }
}
