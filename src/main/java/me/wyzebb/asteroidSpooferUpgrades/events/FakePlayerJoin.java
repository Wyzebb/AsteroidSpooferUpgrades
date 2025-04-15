package me.wyzebb.asteroidSpooferUpgrades.events;

import me.serbob.asteroidapi.events.Impl.FakePlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FakePlayerJoin implements Listener {

    @EventHandler
    public void onFakePlayerJoin(FakePlayerJoinEvent event) {
        Player plr = event.getFakePlayer().getEntityPlayer();
        plr.setViewDistance(0);
    }
}
