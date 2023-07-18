package me.squid;

import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class Events implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity victim = event.getEntity();
        Entity attacker = event.getDamager();

        // Seeing if the attacker is a player and victim is a sheep
        if(victim instanceof Sheep && attacker instanceof Player) {
            Player player = (Player) attacker;

            EconomyResponse response = SheepPlugin.econ.withdrawPlayer(player, 1); // IDK how much to be removed

            if(response.errorMessage != null) {
                SheepPlugin.log.warning(response.errorMessage);
            }
        }
    }

}
