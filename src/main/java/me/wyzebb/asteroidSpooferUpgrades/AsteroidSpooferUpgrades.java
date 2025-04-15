package me.wyzebb.asteroidSpooferUpgrades;

import me.wyzebb.asteroidSpooferUpgrades.events.FakePlayerDeath;
import me.wyzebb.asteroidSpooferUpgrades.events.FakePlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class AsteroidSpooferUpgrades extends JavaPlugin {
    public static AsteroidSpooferUpgrades plugin;

    @Override
    public void onEnable() {
        plugin = this;

        saveDefaultConfig();
        getConfig().options().copyDefaults(true);

        getServer().getPluginManager().registerEvents(new FakePlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new FakePlayerJoin(), this);
    }
}
