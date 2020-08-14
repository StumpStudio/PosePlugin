package ru.armagidon.poseplugin.api.utils.nms.npc;

import net.minecraft.server.v1_15_R1.*;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import ru.armagidon.poseplugin.api.utils.items.ItemUtil;
import ru.armagidon.poseplugin.api.utils.nms.NMSUtils;
import ru.armagidon.poseplugin.api.utils.nms.item.ItemUtil_v1_15_R1;
import ru.armagidon.poseplugin.api.utils.nms.util.PacketContainer;

import java.util.Arrays;

import static ru.armagidon.poseplugin.api.utils.nms.NMSUtils.asNMSCopy;
import static ru.armagidon.poseplugin.api.utils.nms.npc.FakePlayer_v1_15_R1.FakePlayerStaff.getEquipmentBySlot;
import static ru.armagidon.poseplugin.api.utils.nms.npc.FakePlayer_v1_15_R1.FakePlayerStaff.getFixedRotation;

public class FakePlayerUpdaterImpl_v1_15_R1 implements FakePlayerUpdater {

    private final FakePlayer_v1_15_R1 npc;
    private final ItemUtil util;

    private byte pOverlays;


    public FakePlayerUpdaterImpl_v1_15_R1(FakePlayer_v1_15_R1 npc) {
        this.npc = npc;
        this.pOverlays = ((EntityPlayer)asNMSCopy(npc.getParent())).getDataWatcher().get(DataWatcherRegistry.a.a(16));
        this.util = new ItemUtil_v1_15_R1(new org.bukkit.inventory.ItemStack(Material.AIR));
    }

    public void updateEquipment(){
        PacketContainer<PacketPlayOutEntityEquipment> container = resetEquipment(npc.getFake().getId(), npc.getParent().getEquipment());
        npc.getTrackers().forEach(container::send);
    }

    private PacketContainer<PacketPlayOutEntityEquipment> resetEquipment(int id, EntityEquipment equipment){
        PacketPlayOutEntityEquipment[] eq = Arrays.stream(EnumItemSlot.values()).
                map(slot->{
                    ItemStack itemStack = getEquipmentBySlot(equipment, slot);
                    if(!slot.equals(EnumItemSlot.MAINHAND)&&!slot.equals(EnumItemSlot.OFFHAND)) {
                        util.setSource(itemStack);
                        itemStack = util.removeTag("PosePluginItem").getSource();
                    }
                    return new PacketPlayOutEntityEquipment(id,slot,CraftItemStack.asNMSCopy(itemStack));
                }).
                toArray(PacketPlayOutEntityEquipment[]::new);
        return new PacketContainer<>(eq);
    }

    public void updateOverlays(){
        byte overlays = ((EntityPlayer) NMSUtils.asNMSCopy(npc.getParent())).getDataWatcher().get(DataWatcherRegistry.a.a(16));
        if(overlays!=pOverlays){
            pOverlays = overlays;
            npc.getMetadataAccessor().setOverlays(pOverlays);
            npc.getMetadataAccessor().merge(false);
            npc.getTrackers().forEach(p-> npc.getMetadataAccessor().showPlayer(p));
        }
    }

    public void updateHeadRotation() {
        PacketPlayOutEntityHeadRotation rotation = new PacketPlayOutEntityHeadRotation(npc.getFake(), getFixedRotation(npc.getParent().getLocation().getYaw()));
        PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook lookPacket = new PacketPlayOutEntity.PacketPlayOutRelEntityMoveLook(npc.getFake().getId(), (short) 0, (short) 0, (short) 0, getFixedRotation(npc.getParent().getLocation().getYaw()), (byte) 0, true);
        npc.getTrackers().forEach(p -> {
            NMSUtils.sendPacket(p, lookPacket);
            NMSUtils.sendPacket(p, rotation);
        });
    }
}
