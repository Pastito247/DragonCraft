package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.Location;

public class Arcanista implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(50); // Representando el mana con el nivel
    }

    public void activateTeleport(Player player) {
        Location targetLocation = player.getTargetBlock(null, 50).getLocation();
        player.teleport(targetLocation);
        player.sendMessage("¡Has sido teletransportado!");
    }

    @Override
    public String getClassName() {
        return "Arcanista";
    }
}
