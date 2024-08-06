package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;

public class Bardo implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(50); // Representando el mana con el nivel
    }

    public void activateHeal(Player player) {
        for (Entity entity : player.getNearbyEntities(6, 6, 6)) {
            if (entity instanceof Player) {
                ((Player) entity).setHealth(Math.min(((Player) entity).getMaxHealth(), ((Player) entity).getHealth() + 4.0)); // Cura 2 corazones
            }
        }
        player.sendMessage("¡Has curado a los jugadores cercanos!");
    }

    @Override
    public String getClassName() {
        return "Bardo";
    }
}
