package com.pasto.dragoncraft.classes;

import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class Druida implements PlayerClass {
    private int experience = 0;
    private int level = 1;

    @Override
    public void applyClassAttributes(Player player) {
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20.0);
        player.setLevel(level); // Representando el mana con el nivel
    }

    @Override
    public String getClassName() {
        return "Druida";
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

    public void activatePolymorph(Player player, String form) {
        LivingEntity entity;
        switch (form.toLowerCase()) {
            case "lobo":
                entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                break;
            case "oso":
                entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.POLAR_BEAR);
                break;
            case "ave":
                entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.PARROT);
                break;
            case "pez":
                entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.COD);
                break;
            default:
                player.sendMessage("Forma no reconocida.");
                return;
        }
        entity.setCustomName(player.getName());
        player.sendMessage("¡Te has transformado en un " + form + "!");
    }
}
