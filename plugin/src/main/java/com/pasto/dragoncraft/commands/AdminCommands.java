package com.pasto.dragoncraft.commands;

import com.pasto.dragoncraft.classes.*;
import com.pasto.dragoncraft.classes.ClassManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {

    private final ClassManager classManager;

    public AdminCommands(ClassManager classManager) {
        this.classManager = classManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("dragoncraft.admin")) {
            if (args.length < 2) {
                sender.sendMessage(ChatColor.RED + "Uso: /darxp <jugador> <cantidad> o /cambiarclaseadmin <jugador> <clase>");
                return false;
            }

            Player target = sender.getServer().getPlayer(args[0]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Jugador no encontrado.");
                return false;
            }

            if (label.equalsIgnoreCase("darxp")) {
                int amount;
                try {
                    amount = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Cantidad inválida.");
                    return false;
                }

                PlayerClass playerClass = classManager.getPlayerClass(target);
                if (playerClass != null) {
                    playerClass.addExperience(target, amount);
                    sender.sendMessage(ChatColor.GREEN + "Has dado " + amount + " de experiencia a " + target.getName() + ".");
                } else {
                    sender.sendMessage(ChatColor.RED + "El jugador no tiene una clase asignada.");
                }
                return true;

            } else if (label.equalsIgnoreCase("cambiarclaseadmin")) {
                String className = args[1].toLowerCase();
                switch (className) {
                    case "arcanista":
                        classManager.setPlayerClass(target, new Arcanista());
                        break;
                    case "barbaro":
                        classManager.setPlayerClass(target, new Barbaro());
                        break;
                    case "bardo":
                        classManager.setPlayerClass(target, new Bardo());
                        break;
                    case "druida":
                        classManager.setPlayerClass(target, new Druida());
                        break;
                    case "picaro":
                        classManager.setPlayerClass(target, new Picaro());
                        break;
                    case "paladin":
                        classManager.setPlayerClass(target, new Paladin());
                        break;
                    case "guerrero":
                        classManager.setPlayerClass(target, new Guerrero());
                        break;
                    default:
                        sender.sendMessage(ChatColor.RED + "Clase no válida. Clases disponibles: arcanista, barbaro, bardo, druida, picaro, paladin, guerrero.");
                        return false;
                }

                sender.sendMessage(ChatColor.GREEN + "Has cambiado la clase de " + target.getName() + " a " + className + ".");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "No tienes permisos para ejecutar este comando.");
            return true;
        }
        return false;
    }
}
