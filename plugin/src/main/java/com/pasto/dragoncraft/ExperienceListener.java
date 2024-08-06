package com.pasto.dragoncraft;

import com.pasto.dragoncraft.classes.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ExperienceListener implements Listener {
    private final ClassManager classManager;

    public ExperienceListener(ClassManager classManager) {
        this.classManager = classManager;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            PlayerClass playerClass = classManager.getPlayerClass(player);

            if (playerClass != null) {
                if (event.getEntityType() == EntityType.ZOMBIE) {
                    playerClass.addExperience(player, 50); // Ejemplo de cantidad de experiencia
                } else if (event.getEntityType() == EntityType.COW) {
                    playerClass.addExperience(player, 10); // Ejemplo de cantidad de experiencia
                }
                // Añadir más tipos de enemigos/animales y experiencia
            }
        }
    }
}
