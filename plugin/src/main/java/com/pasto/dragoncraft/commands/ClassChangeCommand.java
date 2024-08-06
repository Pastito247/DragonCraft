package com.pasto.dragoncraft.commands;

import com.pasto.dragoncraft.classes.*;
import com.pasto.dragoncraft.classes.ClassManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class ClassChangeCommand implements CommandExecutor {

    private final ClassManager classManager;
    private final HashMap<UUID, Long> cooldowns = new HashMap<>();

    public ClassChangeCommand(ClassManager classManager) {
        this.classManager = classManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();

            if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "Uso: /cambiarclase <clase>");
                return false;
            }

            String className = args[0].toLowerCase();
            long cooldownTime = 7 * 24 * 60 * 60 * 1000L; // 7 días en milisegundos
            long lastUsed = cooldowns.getOrDefault(playerUUID, 0L);
            long timePassed = System.currentTimeMillis() - lastUsed;

            if (timePassed < cooldownTime) {
                long timeRemaining = cooldownTime - timePassed;
                long daysRemaining = timeRemaining / (24 * 60 * 60 * 1000);
                player.sendMessage(ChatColor.RED + "No puedes cambiar de clase todavía. Tiempo restante: " + daysRemaining + " días.");
                return true;
            }

            switch (className) {
                case "arcanista":
                    classManager.setPlayerClass(player, new Arcanista());
                    break;
                case "barbaro":
                    classManager.setPlayerClass(player, new Barbaro());
                    break;
                case "bardo":
                    classManager.setPlayerClass(player, new Bardo());
                    break;
                case "druida":
                    classManager.setPlayerClass(player, new Druida());
                    break;
                case "picaro":
                    classManager.setPlayerClass(player, new Picaro());
                    break;
                case "paladin":
                    classManager.setPlayerClass(player, new Paladin());
                    break;
                case "guerrero":
                    classManager.setPlayerClass(player, new Guerrero());
                    break;
                default:
                    player.sendMessage(ChatColor.RED + "Clase no válida. Clases disponibles: arcanista, barbaro, bardo, druida, picaro, paladin, guerrero.");
                    return false;
            }

            cooldowns.put(playerUUID, System.currentTimeMillis());
            player.sendMessage(ChatColor.GREEN + "¡Has cambiado tu clase a " + className + "!");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Este comando solo puede ser utilizado por jugadores.");
            return true;
        }
    }
}
