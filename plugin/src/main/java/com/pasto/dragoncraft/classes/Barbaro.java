package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Barbaro implements PlayerClass {
    private int experience = 0;
    private int level = 1;

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0); // Más vida
    }

    @Override
    public String getClassName() {
        return "Bárbaro";
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

    public void activateRage(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0)); // Fuerza 1 minuto
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0)); // Resistencia 1 minuto
        player.sendMessage("¡Has entrado en Furia!");
    }
}
