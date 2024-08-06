package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

public class Guerrero implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0); // Más daño de ataque
    }

    @Override
    public String getClassName() {
        return "Guerrero";
    }
}
