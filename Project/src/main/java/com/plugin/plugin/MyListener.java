package com.plugin.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.getPlayer().sendTitle("환영합니다!","현재 마인크래프트 서버에 접속중입니다.",-1,60,-1);
    }
}
