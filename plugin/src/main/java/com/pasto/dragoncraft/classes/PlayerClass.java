package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;

public interface PlayerClass {
    void applyClassAttributes(Player player);
    String getClassName();
    void addExperience(Player player, int amount);
    int getLevel(Player player);
}
