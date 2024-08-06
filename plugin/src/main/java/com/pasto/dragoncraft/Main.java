package com.pasto.dragoncraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    private ClassManager classManager;
    private LevelManager levelManager;

    @Override
    public void onEnable() {
        classManager = new ClassManager();
        levelManager = new LevelManager();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("DragonCraft se ha habilitado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DragonCraft se ha deshabilitado!");
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity().getKiller() instanceof Player) {
            Player player = event.getEntity().getKiller();
            levelManager.addExperience(player, 10); // Añadir experiencia al jugador
        }
    }
}
