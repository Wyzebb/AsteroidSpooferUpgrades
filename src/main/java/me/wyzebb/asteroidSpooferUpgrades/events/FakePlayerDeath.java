package me.wyzebb.asteroidSpooferUpgrades.events;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Guild;
import github.scarsz.discordsrv.dependencies.jda.api.entities.Member;
import github.scarsz.discordsrv.objects.managers.AccountLinkManager;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.serbob.asteroidapi.events.Impl.FakePlayerDeathEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.wyzebb.asteroidSpooferUpgrades.AsteroidSpooferUpgrades.plugin;

public class FakePlayerDeath implements Listener {

    private final MiniMessage mm;

    public FakePlayerDeath() {
        this.mm = MiniMessage.miniMessage();
    }

    @EventHandler
    public void onFakePlayerDeath(FakePlayerDeathEvent event) {
        AccountLinkManager manager = DiscordSRV.getPlugin().getAccountLinkManager();
        String discordId = manager.getDiscordId(event.getFakePlayer().getEntityPlayer().getUniqueId());

        Member guildMember = null;
        if (discordId != null) {
            Guild mainGuild = DiscordSRV.getPlugin().getMainGuild();
            guildMember = mainGuild.getMemberById(discordId);
        }

        String dmDeathMessage = plugin.getConfig().getString("death-messages.dm", "You just died on the server!");
        String broadcastDeathMessage = plugin.getConfig().getString("death-messages.broadcast", "<red>Offline Player <b>{player}</b> just died!</red>");

        broadcastDeathMessage = broadcastDeathMessage.replace("{player}", event.getFakePlayer().getEntityPlayer().getName());

        Bukkit.broadcast(mm.deserialize(broadcastDeathMessage));

        if (guildMember != null) {
            DiscordUtil.privateMessage(guildMember.getUser(), dmDeathMessage);
        }
    }
}
