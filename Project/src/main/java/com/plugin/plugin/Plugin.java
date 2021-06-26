package com.plugin.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new MyListener(), this);
        getServer().getPluginManager().registerEvents(new DoubleJump(), this);
        Bukkit.getConsoleSender().sendMessage("Plugin on Enabled");

        AddRecipe();
        AddCommand();

    }
    private void AddCommand(){
        getCommand("rlqhsxpa").setExecutor(new Command());
        getCommand("기본템").setExecutor(new Command());
        getCommand("qkq").setExecutor(new QkqCommand());
        getCommand("밥").setExecutor(new QkqCommand());
    }
    private void AddRecipe(){
        ShapelessRecipe iron = new ShapelessRecipe(new ItemStack(Material.IRON_INGOT,8)).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.RAW_IRON).addIngredient(Material.COAL);
        ShapelessRecipe gold = new ShapelessRecipe(new ItemStack(Material.GOLD_INGOT,8)).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.RAW_GOLD).addIngredient(Material.COAL);
        ShapelessRecipe copper = new ShapelessRecipe(new ItemStack(Material.COPPER_INGOT,8)).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.RAW_COPPER).addIngredient(Material.COAL);
        ShapedRecipe enchanted_golden_apple = new ShapedRecipe(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE)).shape(new String[]{"AAA","ABA","AAA"}).setIngredient('A',Material.GOLD_BLOCK).setIngredient('B',Material.APPLE);

        getServer().addRecipe(iron);
        getServer().addRecipe(gold);
        getServer().addRecipe(copper);
        getServer().addRecipe(enchanted_golden_apple);
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Plugin on Disabled");
    }
}
