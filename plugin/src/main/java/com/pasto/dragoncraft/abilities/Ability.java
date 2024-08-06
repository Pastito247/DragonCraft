package com.pasto.dragoncraft.abilities;

import org.bukkit.entity.Player;

public interface Ability {
    void activate(Player player);
    String getName();
}
