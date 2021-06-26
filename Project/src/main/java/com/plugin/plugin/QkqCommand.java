package com.plugin.plugin;

import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
public class QkqCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender,org.bukkit.command.Command command,String Label, String[] args){
        if(sender instanceof Player){
            Player player=(Player)sender;
            player.sendMessage("빵을 지급합니다.");
            ItemStack item = new ItemStack((Material.BREAD));
            item.setAmount(64);
            player.getInventory().addItem(item);
            return true;
        }else{
            sender.sendMessage("플레이어만 이 명령어를 사용할 수 있습니다.");
            return false;
        }
    }
}