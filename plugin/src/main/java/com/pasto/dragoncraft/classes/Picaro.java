package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

public class Picaro implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2); // Más velocidad de movimiento
    }

    @Override
    public String getClassName() {
        return "Pícaro";
    }
}
