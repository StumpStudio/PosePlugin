package ru.armagidon.poseplugin.api.utils.misc.event;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.armagidon.poseplugin.api.PosePluginAPI;
//Listener of all necessary events
public class EventListener implements Listener
{
    public EventListener() {}

    @EventHandler
    public void join(PlayerJoinEvent event){
        //Add player to playerlist
        PosePluginAPI.getAPI().getPlayerMap().addPlayer(event.getPlayer());
        PosePluginAPI.getAPI().getPacketReaderManager().inject(event.getPlayer());
    }

    @EventHandler
    public void quit(PlayerQuitEvent event){
        //Stop current animation
        PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName()).getPose().stop();
        //Remove player from playerlist
        PosePluginAPI.getAPI().getPlayerMap().removePlayer(event.getPlayer());
        //Eject all packet reader out of player's pipeline
        PosePluginAPI.getAPI().getPacketReaderManager().eject(event.getPlayer());
    }

    private boolean containsPlayer(Player player) {
        return PosePluginAPI.getAPI().getPlayerMap().containsPlayer(player);
    }
}