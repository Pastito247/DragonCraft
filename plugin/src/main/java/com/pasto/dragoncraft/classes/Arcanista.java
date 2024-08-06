package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.Location;

public class Arcanista implements PlayerClass {
    private int experience = 0;
    private int level = 1;

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(level); // Representando el mana con el nivel
    }

    @Override
    public String getClassName() {
        return "Arcanista";
    }

    @Override
    public void addExperience(Player player, int amount) {
        experience += amount;
        if (experience >= 100 * level) { // Ejemplo de fórmula de nivel
            experience = 0;
            level++;
            applyClassAttributes(player);
            player.sendMessage("¡Has subido al nivel " + level + "!");
        }
    }

    @Override
    public int getLevel(Player player) {
        return level;
    }

    public void activateTeleport(Player player) {
        Location targetLocation = player.getTargetBlock(null, 50).getLocation();
        player.teleport(targetLocation);
        player.sendMessage("¡Has sido teletransportado!");
    }
}
