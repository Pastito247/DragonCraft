package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Guerrero implements PlayerClass {

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(10.0); // Más daño de ataque
    }

    public void activateRegeneration(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0)); // 1 minuto de regeneración
        player.sendMessage("¡Has activado la regeneración!");
    }

    @Override
    public String getClassName() {
        return "Guerrero";
    }
}
