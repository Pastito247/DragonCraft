package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;

public class Druida implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(50); // Representando el mana con el nivel
    }

    public void activatePolymorph(Player player, String form) {
        switch (form.toLowerCase()) {
            case "lobo":
                player.setDisplayName("Lobo");
                break;
            case "oso":
                player.setDisplayName("Oso");
                break;
            case "ave":
                player.setDisplayName("Ave");
                break;
            case "pez":
                player.setDisplayName("Pez");
                break;
        }
        player.sendMessage("¡Te has transformado en un " + form + "!");
    }

    @Override
    public String getClassName() {
        return "Druida";
    }
}
