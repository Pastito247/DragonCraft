package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Paladin implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(10.0); // Más resistencia base
    }

    public void activateShield(Player player, Player target) {
        target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1200, 1)); // 1 minuto de escudo
        player.sendMessage("¡Has protegido a " + target.getName() + "!");
    }

    @Override
    public String getClassName() {
        return "Paladín";
    }
}
