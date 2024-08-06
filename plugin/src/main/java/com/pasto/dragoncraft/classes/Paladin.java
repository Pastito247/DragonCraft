package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

public class Paladin implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(10.0); // Más resistencia base
    }

    @Override
    public String getClassName() {
        return "Paladín";
    }
}
