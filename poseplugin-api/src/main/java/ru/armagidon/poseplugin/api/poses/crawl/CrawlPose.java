package ru.armagidon.poseplugin.api.poses.crawl;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import ru.armagidon.poseplugin.api.PosePluginAPI;
import ru.armagidon.poseplugin.api.poses.AbstractPose;
import ru.armagidon.poseplugin.api.poses.EnumPose;
import ru.armagidon.poseplugin.api.ticking.Tickable;
import ru.armagidon.poseplugin.api.utils.nms.ToolFactory;
import ru.armagidon.poseplugin.api.utils.versions.PoseAvailabilitySince;

@PoseAvailabilitySince(version = "1.15")
public class CrawlPose extends AbstractPose implements Tickable {

    private final CrawlHandler handler;

    public CrawlPose(Player target) {
        super(target);
        this.handler = ToolFactory.create(CrawlHandler.class, new Class[]{Player.class}, target);
        registerProperties();
    }

    private void registerProperties(){
        getProperties().register();
    }


    @Override
    public void initiate() {
        super.initiate();
        PosePluginAPI.getAPI().getTickingBundle().addToTickingBundle(CrawlPose.class, this);
    }

    @Override
    public void play(Player receiver) {
        handler.init();
    }

    @Override
    public void stop() {
        super.stop();
        PosePluginAPI.getAPI().getTickingBundle().removeFromTickingBundle(CrawlPose.class, this);
        handler.dispose();
    }

    @Override
    public EnumPose getType() {
        return EnumPose.CRAWLING;
    }

    @EventHandler
    public void onMount(EntityMountEvent event){
        if(event.getEntity().equals(getPlayer())){
            getPosePluginPlayer().stopCurrentPose();
        }
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent event){
        if (event.getPlayer().equals(getPlayer())) {
            getPosePluginPlayer().stopPosingSilently();
        }
    }

    @Override
    public void tick() {
        handler.tick();
    }
}