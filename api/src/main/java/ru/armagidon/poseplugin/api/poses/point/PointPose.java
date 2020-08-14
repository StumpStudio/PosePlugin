package ru.armagidon.poseplugin.api.poses.point;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import ru.armagidon.poseplugin.api.PosePluginAPI;
import ru.armagidon.poseplugin.api.personalListener.PersonalEventHandler;
import ru.armagidon.poseplugin.api.poses.EnumPose;
import ru.armagidon.poseplugin.api.poses.PluginPose;
import ru.armagidon.poseplugin.api.utils.items.ItemUtil;
import ru.armagidon.poseplugin.api.utils.nms.npc.FakePlayer;
import ru.armagidon.poseplugin.api.utils.property.Property;

public class PointPose extends PluginPose {

    private final FakePlayer npc;
    private PointMode mode;
    private final Location to;

    public PointPose(Player target) {
        super(target);
        this.npc = PosePluginAPI.getAPI().getNMSFactory().createFakePlayer(target, Pose.STANDING);

        getProperties().registerProperty("mode",new Property<>(PointMode.RIGHT,this::setMode));
        getProperties().register();

        this.mode = getProperties().getProperty("mode", PointMode.class).getValue();
        this.to = target.getLocation().clone();
    }

    @Override
    public void initiate() {
        super.initiate();
        npc.setHeadRotationEnabled(true);
        npc.setUpdateEquipmentEnabled(false);
        npc.setUpdateOverlaysEnabled(true);
        npc.initiate();
        npc.getCustomEquipmentInterface().setHelmet(getEquipmentBySlot(PlayerArmorChangeEvent.SlotType.HEAD, getPlayer().getEquipment()));
        npc.getCustomEquipmentInterface().setChestPlate(getEquipmentBySlot(PlayerArmorChangeEvent.SlotType.CHEST, getPlayer().getEquipment()));
        npc.getCustomEquipmentInterface().setLeggings(getEquipmentBySlot(PlayerArmorChangeEvent.SlotType.LEGS, getPlayer().getEquipment()));
        npc.getCustomEquipmentInterface().setBoots(getEquipmentBySlot(PlayerArmorChangeEvent.SlotType.FEET, getPlayer().getEquipment()));
    }

    @Override
    public void play(Player receiver) {
        PosePluginAPI.getAPI().getPlayerHider().hide(getPlayer());
        PosePluginAPI.getAPI().getNameTagHider().hideTag(getPlayer());
        PosePluginAPI.getAPI().getArmorHider().hideArmor(getPlayer());
        if(receiver==null){
            npc.broadCastSpawn();
        } else {
            npc.spawnToPlayer(receiver);
        }

        //Requires PosePluginItems resource-pack
        ItemStack bow = PosePluginAPI.getAPI().getNMSFactory().createItemUtil(new ItemStack(Material.BOW)).addTag("PosePluginItem","BOW").getSource();

        npc.getCustomEquipmentInterface().setItemInMainHand(bow);
        npc.setHandActive(mode.equals(PointMode.RIGHT));
    }

    @Override
    public void stop() {
        super.stop();
        PosePluginAPI.getAPI().getPlayerHider().show(getPlayer());
        PosePluginAPI.getAPI().getNameTagHider().showTag(getPlayer());
        PosePluginAPI.getAPI().getArmorHider().showArmor(getPlayer());
        npc.remove();
        npc.destroy();
    }

    @Override
    public EnumPose getPose() {
        return EnumPose.POINTING;
    }

    @PersonalEventHandler
    public void onMove(PlayerMoveEvent event){
        if (event.getTo().getX() != event.getFrom().getX() || event.getTo().getY() != event.getFrom().getY() || event.getTo().getZ() != event.getFrom().getZ()) {
            Location t = to.clone().setDirection(getPlayer().getLocation().getDirection());
            t.setYaw(getPlayer().getLocation().getYaw());
            t.setPitch(getPlayer().getLocation().getPitch());
            event.setTo(t);
        }
    }

    @PersonalEventHandler
    public void onArmorChange(PlayerArmorChangeEvent event){
        if(event.getNewItem()==null) return;
        ItemUtil util = PosePluginAPI.getAPI().getNMSFactory().createItemUtil(event.getNewItem()).removeTag("PosePluginItem");
        switch (event.getSlotType()){
            case HEAD:
                npc.getCustomEquipmentInterface().setHelmet(util.getSource());
                break;
            case CHEST:
                npc.getCustomEquipmentInterface().setChestPlate(util.getSource());
                break;
            case LEGS:
                npc.getCustomEquipmentInterface().setLeggings(util.getSource());
                break;
            case FEET:
                npc.getCustomEquipmentInterface().setBoots(util.getSource());
                break;
        }
    }

    public void setMode(PointMode mode) {
        this.mode = mode;
        npc.setHandActive(mode.equals(PointMode.RIGHT));
    }

    public enum PointMode{
        LEFT,
        RIGHT
    }

    private ItemStack getEquipmentBySlot(PlayerArmorChangeEvent.SlotType slot, EntityEquipment eq){
        ItemStack out;
        switch (slot){
            case HEAD:
                out =  eq.getHelmet();
                break;
            case CHEST:
                out = eq.getChestplate();
                break;
            case LEGS:
                out = eq.getLeggings();
                break;
            case FEET:
                out = eq.getBoots();
                break;
            default:
                out = new ItemStack(Material.AIR);
                break;
        }
        return out!=null?out:new ItemStack(Material.AIR);
    }
}
