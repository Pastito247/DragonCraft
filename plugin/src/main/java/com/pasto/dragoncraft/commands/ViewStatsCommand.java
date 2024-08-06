package com.pasto.dragoncraft.commands;

import com.pasto.dragoncraft.classes.*;
import com.pasto.dragoncraft.classes.ClassManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ViewStatsCommand implements CommandExecutor {

    private final ClassManager classManager;

    public ViewStatsCommand(ClassManager classManager) {
        this.classManager = classManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerClass playerClass = classManager.getPlayerClass(player);

            if (playerClass != null) {
                int level = playerClass.getLevel(player);
                player.sendMessage(ChatColor.GREEN + "Tu clase: " + playerClass.getClassName());
                player.sendMessage(ChatColor.GREEN + "Nivel: " + level);
                player.sendMessage(ChatColor.GREEN + "Experiencia: " + (level * 100 - 100) + "/100");
            } else {
                player.sendMessage(ChatColor.RED + "No tienes una clase asignada.");
            }
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Este comando solo puede ser utilizado por jugadores.");
            return true;
        }
    }
}
