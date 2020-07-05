package ru.armagidon.poseplugin.api.personalListener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;
import ru.armagidon.poseplugin.api.PosePluginAPI;
import ru.armagidon.poseplugin.api.player.PosePluginPlayer;

public class PersonalEventDispatcher implements Listener
{
    @EventHandler(ignoreCancelled = true,priority = EventPriority.LOWEST)
    public void onMove(PlayerMoveEvent event){
        if(playerAbsent(event.getPlayer())) return;
        PosePluginPlayer player = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        player.callPersonalEvent(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(playerAbsent(p)) return;
        PosePluginPlayer player = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(p.getName());
        player.callPersonalEvent(e);
    }

    private boolean playerAbsent(Player player) {
        return !PosePluginAPI.getAPI().getPlayerMap().containsPlayer(player);
    }
    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onInteract(PlayerInteractEvent event) {
        if (playerAbsent(event.getPlayer())) return;
        PosePluginPlayer p = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        p.callPersonalEvent(event);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.LOWEST)
    public void onInteractAtEntity(PlayerInteractAtEntityEvent event) {
        if (playerAbsent(event.getPlayer())) return;
        PosePluginPlayer p = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        p.callPersonalEvent(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void gameMode(PlayerGameModeChangeEvent event) {
        if (playerAbsent(event.getPlayer())) return;
        PosePluginPlayer p = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        p.callPersonalEvent(event);
    }

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event){
        if(playerAbsent(event.getPlayer())) return;
        PosePluginPlayer player = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        player.callPersonalEvent(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onClick(PlayerInteractEvent event){
        if(playerAbsent(event.getPlayer())) return;
        PosePluginPlayer player = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR)||event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            player.callPersonalEvent(event);
        }
    }
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onGameModeChange(PlayerGameModeChangeEvent event){
        if(playerAbsent(event.getPlayer())) return;
        PosePluginPlayer player = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        player.callPersonalEvent(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onSneak(PlayerToggleSneakEvent event){
        //If player's not in player list, ignore him
        if(playerAbsent(event.getPlayer())) return;
        PosePluginPlayer p =PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getPlayer().getName());
        p.callPersonalEvent(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void death(PlayerDeathEvent event){
        //If player's not in player list, ignore him
        if(playerAbsent(event.getEntity())) return;
        PosePluginPlayer p = PosePluginAPI.getAPI().getPlayerMap().getPosePluginPlayer(event.getEntity().getName());
        p.callPersonalEvent(event);
    }

}
