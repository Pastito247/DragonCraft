package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

public class Arcanista implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(50); // Representando el mana con el nivel
    }

    @Override
    public String getClassName() {
        return "Arcanista";
    }
}
