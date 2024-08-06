package com.pasto.dragoncraft;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class LevelManager {

    private final Map<Player, Integer> playerLevels = new HashMap<>();
    private final Map<Player, Integer> playerExperience = new HashMap<>();

    public void addExperience(Player player, int amount) {
        int currentExp = playerExperience.getOrDefault(player, 0);
        currentExp += amount;

        int currentLevel = playerLevels.getOrDefault(player, 1);
        int expForNextLevel = getExperienceForNextLevel(currentLevel);

        if (currentExp >= expForNextLevel) {
            playerLevels.put(player, currentLevel + 1);
            playerExperience.put(player, currentExp - expForNextLevel);
            player.sendMessage("¡Has subido al nivel " + (currentLevel + 1) + "!");
        } else {
            playerExperience.put(player, currentExp);
        }
    }

    public int getExperienceForNextLevel(int level) {
        return 100 * level; // Por ejemplo, 100 * nivel actual de experiencia
    }

    public int getPlayerLevel(Player player) {
        return playerLevels.getOrDefault(player, 1);
    }

    public int getPlayerExperience(Player player) {
        return playerExperience.getOrDefault(player, 0);
    }
}
