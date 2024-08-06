package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Paladin implements PlayerClass {
    private int experience = 0;
    private int level = 1;

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0)); // Resistencia base
    }

    @Override
    public String getClassName() {
        return "Paladín";
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

    public void activateShield(Player player, Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 1));
        player.sendMessage("¡Has protegido a " + target.getName() + " con un escudo!");
    }
}
