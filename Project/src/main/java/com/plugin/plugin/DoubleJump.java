package com.plugin.plugin;

import com.sun.tools.javac.tree.DCTree;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJump implements Listener{
    @EventHandler
    public void Jump (PlayerToggleFlightEvent event){
        if(event.getPlayer().getGameMode() != GameMode.CREATIVE){
            event.setCancelled(true);
            event.getPlayer().getWorld().playSound(event.getPlayer().getLocation(),Sound.ENTITY_BAT_TAKEOFF,10000,1);
            event.getPlayer().getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE,event.getPlayer().getLocation(),10);
            event.getPlayer().setVelocity(new Vector(
                    event.getPlayer().getVelocity().getX() * 3,
                    0.8D,
                    event.getPlayer().getVelocity().getZ() * 3));
            event.getPlayer().setAllowFlight(false);
        }
    }
    @EventHandler
    public  void onMove(PlayerMoveEvent event){
        if(event.getPlayer().getGameMode() != GameMode.CREATIVE &&
                event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR &&
                event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.WATER &&
                event.getPlayer().getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.LAVA){
            event.getPlayer().setAllowFlight(true);
        }
        if(event.getPlayer().isFlying()) event.getPlayer().setFlying(false);
    }
}
