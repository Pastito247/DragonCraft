package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Barbaro implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0); // Más vida
    }

    public void activateRage(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 0)); // Fuerza 1 minuto
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 0)); // Resistencia 1 minuto
        player.sendMessage("¡Has entrado en Furia!");
    }

    @Override
    public String getClassName() {
        return "Bárbaro";
    }
}
