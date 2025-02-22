/*
 * Copyright (c) 2020, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.server.crafting;

import io.gomint.inventory.item.ItemAir;
import io.gomint.inventory.item.ItemStack;
import io.gomint.jraknet.PacketBuffer;
import io.gomint.server.inventory.Inventory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

/**
 * Resembles a shaped crafting recipe, i.e. a recipe that requires its
 * arrangement to be arranged in specific way and does not accept work
 * if any ingredient is not in the right spot.
 *
 * @author BlackyPaw
 * @version 1.0
 */
public class ShapedRecipe extends CraftingRecipe {

    public static final int ID = RECIPE_ID.getAndIncrement();

    private final String name;
    private final String block;

    /**
     * -- GETTER --
     * Gets the width of this shaped recipe.
     *
     * @return The width of this shaped recipe
     */
    private final int width;
    /**
     * -- GETTER --
     * Gets the height of this shaped recipe.
     *
     * @return The height of this shaped recipe
     */
    private final int height;

    private final ItemStack<?>[] arrangement;
    private final ItemStack<?>[] outcome;

    private Collection<ItemStack<?>> ingredients;

    /**
     * New shaped recipe
     *
     * @param width       The width of the recipe
     * @param height      The height of the recipe
     * @param ingredients Input of the recipe
     * @param outcome     Output of the recipe
     * @param uuid        UUID of the recipe
     */
    public ShapedRecipe(String name, String block, int width, int height, ItemStack<?>[] ingredients, ItemStack<?>[] outcome, UUID uuid, int priority) {
        super(outcome, uuid, priority);
        assert ingredients.length == width * height : "Invalid arrangement: Fill out empty slots with air!";

        this.name = name;
        this.block = block;

        this.width = width;
        this.height = height;
        this.arrangement = ingredients;
        this.outcome = outcome;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public ItemStack<?>[] ingredients() {
        if (this.ingredients == null) {
            // Got to sort out possible AIR slots and combine types:
            this.ingredients = new ArrayList<>();

            for (int j = 0; j < this.height; ++j) {
                for (int i = 0; i < this.width; ++i) {
                    ItemStack<?> stack = this.arrangement[j * this.width + i];
                    if (!(stack instanceof ItemAir)) {
                        this.ingredients.add(stack);
                    }
                }
            }
        }

        return this.ingredients.toArray(new ItemStack[0]);
    }

    @Override
    public void serialize(PacketBuffer buffer) {
    }

    @Override
    public int[] isCraftable(Inventory<?> inputInventory) {
        ItemStack<?>[] inputItems = inputInventory.contents();
        ItemStack<?>[] ingredients = this.ingredients();
        int[] consumeSlots = new int[ingredients.length];
        Arrays.fill(consumeSlots, -1);

        for (int rI = 0; rI < ingredients.length; rI++) {
            ItemStack<?> recipeWanted = ingredients[rI];
            boolean found = false;

            for (int i = 0; i < inputItems.length; i++) {
                ItemStack<?> input = inputItems[i];

                if (canBeUsedForCrafting(recipeWanted, input)) {
                    // Check if we already consumed this
                    int alreadyConsumed = 0;
                    for (int consumeSlot : consumeSlots) {
                        if (consumeSlot == i) {
                            alreadyConsumed++;
                        }
                    }

                    if (input.amount() >= alreadyConsumed + 1) {
                        consumeSlots[rI] = i;
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                return null;
            }
        }

        return consumeSlots;
    }

    @Override
    public int getId() {
        return ID;
    }
}
