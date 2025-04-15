package me.wyzebb.asteroidSpooferUpgrades;

import org.bukkit.plugin.java.JavaPlugin;

public final class AsteroidSpooferUpgrades extends JavaPlugin {
    public static AsteroidSpooferUpgrades plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
