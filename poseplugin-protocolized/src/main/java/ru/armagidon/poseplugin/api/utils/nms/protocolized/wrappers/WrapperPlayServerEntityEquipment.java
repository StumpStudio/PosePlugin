/**
 * PacketWrapper - ProtocolLib wrappers for Minecraft packets
 * Copyright (C) dmulloy2 <http://dmulloy2.net>
 * Copyright (C) Kristian S. Strangeland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ru.armagidon.poseplugin.api.utils.nms.protocolized.wrappers;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.ItemSlot;
import com.comphenix.protocol.wrappers.Pair;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class WrapperPlayServerEntityEquipment extends AbstractPacket {
	public static final PacketType TYPE =
			PacketType.Play.Server.ENTITY_EQUIPMENT;

	public WrapperPlayServerEntityEquipment() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerEntityEquipment(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve Entity ID.
	 * <p>
	 * Notes: entity's ID
	 * 
	 * @return The current Entity ID
	 */
	public int getEntityID() {
		return handle.getIntegers().read(0);
	}

	/**
	 * Set Entity ID.
	 *
	 * @param value - new value.
	 * @return
	 */
	public WrapperPlayServerEntityEquipment setEntityID(int value) {
		handle.getIntegers().write(0, value);
		return this;
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param world - the current world of the entity.
	 * @return The spawned entity.
	 */
	public Entity getEntity(World world) {
		return handle.getEntityModifier(world).read(0);
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param event - the packet event.
	 * @return The spawned entity.
	 */
	public Entity getEntity(PacketEvent event) {
		return getEntity(event.getPlayer().getWorld());
	}

	public ItemSlot getSlot() {
		return handle.getItemSlots().read(0);
	}

	public WrapperPlayServerEntityEquipment setSlot(ItemSlot value) {
		handle.getItemSlots().write(0, value);
		return this;
	}

	public WrapperPlayServerEntityEquipment setSlotStackPair(ItemSlot slot, ItemStack item) {
		List<Pair<ItemSlot, ItemStack>> slotStackPairs = handle.getSlotStackPairLists().read(0);
		slotStackPairs.removeIf(pair -> pair.getFirst().equals(slot));
		slotStackPairs.add(new Pair<>(slot, item));
		handle.getSlotStackPairLists().write(0, slotStackPairs);
		return this;
	}

	public WrapperPlayServerEntityEquipment setSlotStackPairsList(List<Pair<ItemSlot, ItemStack>> pairs) {
		handle.getSlotStackPairLists().write(0, pairs);
		return this;
	}

	public List<Pair<ItemSlot, ItemStack>> getSlotStackPairs() {
		return handle.getSlotStackPairLists().read(0);
	}

	/**
	 * Retrieve Item.
	 * <p>
	 * Notes: item in slot format
	 * 
	 * @return The current Item
	 */
	public ItemStack getItem() {
		return handle.getItemModifier().read(0);
	}

	/**
	 * Set Item.
	 * 
	 * @param value - new value.
	 */
	public WrapperPlayServerEntityEquipment setItem(ItemStack value) {
		handle.getItemModifier().write(0, value);
		return this;
	}
}
