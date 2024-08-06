package com.pasto.dragoncraft;

import com.pasto.dragoncraft.classes.*;
import com.pasto.dragoncraft.commands.AdminCommands;
import com.pasto.dragoncraft.commands.ClassChangeCommand;
import com.pasto.dragoncraft.commands.ViewStatsCommand;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.block.Action;

public class Main extends JavaPlugin implements Listener {

    private ClassManager classManager;

    @Override
    public void onEnable() {
        classManager = new ClassManager();
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ExperienceListener(classManager), this);
        getLogger().info("DragonCraft se ha habilitado!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DragonCraft se ha deshabilitado!");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking() && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            PlayerClass playerClass = classManager.getPlayerClass(player);
            if (playerClass instanceof Arcanista) {
                ((Arcanista) playerClass).activateTeleport(player);
            } else if (playerClass instanceof Barbaro) {
                ((Barbaro) playerClass).activateRage(player);
            } else if (playerClass instanceof Bardo) {
                ((Bardo) playerClass).activateHeal(player);
            } else if (playerClass instanceof Druida) {
                ((Druida) playerClass).activatePolymorph(player, "lobo"); // Cambia "lobo" a la forma deseada
            } else if (playerClass instanceof Picaro) {
                ((Picaro) playerClass).activateInvisibility(player);
            } else if (playerClass instanceof Paladin) {
                ((Paladin) playerClass).activateShield(player, player); // Cambia player al objetivo deseado
            } else if (playerClass instanceof Guerrero) {
                ((Guerrero) playerClass).activateRegeneration(player);
            }
        }
        this.getCommand("cambiarclase").setExecutor(new ClassChangeCommand(classManager));
        this.getCommand("darxp").setExecutor(new AdminCommands(classManager));
        this.getCommand("cambiarclaseadmin").setExecutor(new AdminCommands(classManager));
        this.getCommand("verstats").setExecutor(new ViewStatsCommand(classManager));
    }
}
