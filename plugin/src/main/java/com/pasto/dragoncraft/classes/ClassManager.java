package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class ClassManager {
    private final Map<Player, PlayerClass> playerClasses = new HashMap<>();

    public void setPlayerClass(Player player, PlayerClass playerClass) {
        playerClasses.put(player, playerClass);
        playerClass.applyClassAttributes(player);
    }

    public PlayerClass getPlayerClass(Player player) {
        return playerClasses.get(player);
    }
}
