package com.plugin.plugin;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJump implements Listener{
    @EventHandler
    public void Jump (PlayerToggleFlightEvent event){
        if(event.getPlayer().getGameMode() == GameMode.SURVIVAL ||
          event.getPlayer().getGameMode() == GameMode.ADVENTURE){
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
        Location l = event.getPlayer().getLocation();
        l.add(0,-1,0);
        if((event.getPlayer().getGameMode() == GameMode.SURVIVAL || event.getPlayer().getGameMode() == GameMode.ADVENTURE)&& //플레이어가 서바이벌, 모험모드일때만 적용
                l.getBlock().getType().isSolid()){ //밟고 있는 블럭이 고체블럭인지 감지
            event.getPlayer().setAllowFlight(true); //더블점프 감지를위해 날기 허용
            if(event.getPlayer().isFlying()) event.getPlayer().setFlying(false);//서버의 랙으로 날기가 취소되지 않았을 경우 움직일때 날기를 꺼줌
        }
    }
}
