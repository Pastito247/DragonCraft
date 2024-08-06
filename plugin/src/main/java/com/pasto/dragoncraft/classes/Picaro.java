package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Picaro implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.2); // Más velocidad de movimiento
    }

    public void activateInvisibility(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1200, 1)); // 1 minuto de invisibilidad
        player.sendMessage("¡Eres invisible!");
    }

    @Override
    public String getClassName() {
        return "Pícaro";
    }
}
