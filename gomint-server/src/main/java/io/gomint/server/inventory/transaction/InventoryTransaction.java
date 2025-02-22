package io.gomint.server.inventory.transaction;

import io.gomint.inventory.item.ItemStack;
import io.gomint.server.entity.EntityPlayer;
import io.gomint.server.inventory.Inventory;

/**
 * @author geNAZt
 * @version 1.0
 */
public class InventoryTransaction<I, S, T> implements Transaction<I, S, T> {

    private final EntityPlayer owner;
    private final Inventory<I> inventory;
    private final int slot;
    private final ItemStack<S> sourceItem;
    private final ItemStack<T> targetItem;
    private final byte inventoryWindowId;

    public InventoryTransaction(EntityPlayer owner, Inventory<I> inventory, int slot,
                                ItemStack<S> sourceItem, ItemStack<T> targetItem, byte inventoryWindowId) {
        this.owner = owner;
        this.inventory = inventory;
        this.slot = slot;
        this.sourceItem = sourceItem;
        this.targetItem = targetItem;
        this.inventoryWindowId = inventoryWindowId;
    }

    public EntityPlayer getOwner() {
        return this.owner;
    }

    @Override
    public Inventory<I> inventory() {
        return this.inventory;
    }

    @Override
    public int slot() {
        return this.slot;
    }

    @Override
    public ItemStack<S> sourceItem() {
        return this.sourceItem;
    }

    @Override
    public ItemStack<T> targetItem() {
        return this.targetItem;
    }

    @Override
    public boolean hasInventory() {
        return true;
    }

    @Override
    public void commit() {
        this.inventory.removeViewerWithoutAction(this.owner);
        this.inventory.item(this.slot, this.targetItem);
        this.inventory.addViewerWithoutAction(this.owner);
    }

    @Override
    public void revert() {
        this.inventory.sendContents(this.owner.connection());
    }

    @Override
    public byte getInventoryWindowId() {
        return this.inventoryWindowId;
    }

    @Override
    public String toString() {
        return "{\"_class\":\"InventoryTransaction\", " +
            "\"owner\":" + (this.owner == null ? "null" : this.owner) + ", " +
            "\"inventory\":" + (this.inventory == null ? "null" : this.inventory) + ", " +
            "\"slot\":\"" + this.slot + "\"" + ", " +
            "\"sourceItem\":" + (this.sourceItem == null ? "null" : this.sourceItem) + ", " +
            "\"targetItem\":" + (this.targetItem == null ? "null" : this.targetItem) + ", " +
            "\"inventoryWindowId\":\"" + this.inventoryWindowId + "\"" +
            "}";
    }

}
