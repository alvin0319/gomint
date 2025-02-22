package io.gomint.server.network.packet.types.recipe;

import io.gomint.jraknet.PacketBuffer;
import java.util.UUID;

public class MultiRecipe extends RecipeWithTypeId {

    public static final String TYPE_REPAIR_ITEM = "00000000-0000-0000-0000-000000000001";
    public static final String TYPE_MAP_EXTENDING = "D392B075-4BA1-40AE-8789-AF868D56F6CE";
    public static final String TYPE_MAP_EXTENDING_CARTOGRAPHY = "8B36268C-1829-483C-A0F1-993B7156A8F2";
    public static final String TYPE_MAP_CLONING = "85939755-BA10-4D9D-A4CC-EFB7A8E943C4";
    public static final String TYPE_MAP_CLONING_CARTOGRAPHY = "442D85ED-8272-4543-A6F1-418F90DED05D";
    public static final String TYPE_MAP_UPGRADING = "AECD2294-4B94-434B-8667-4499BB2C9327";
    public static final String TYPE_MAP_UPGRADING_CARTOGRAPHY = "98C84B38-1085-46BD-B1CE-DD38C159E6CC";
    public static final String TYPE_BOOK_CLONING = "D1CA6B84-338E-4F2F-9C6B-76CC8B4BD98D";
    public static final String TYPE_BANNER_DUPLICATE = "B5C5D105-75A2-4076-AF2B-923EA2BF4BF0";
    public static final String TYPE_BANNER_ADD_PATTERN = "D81AAEAF-E172-4440-9225-868DF030D27B";
    public static final String TYPE_FIREWORKS = "00000000-0000-0000-0000-000000000002";
    public static final String TYPE_MAP_LOCKING_CARTOGRAPHY = "602234E4-CAC1-4353-8BB7-B1EBFF70024B";

    private UUID recipeId;
    private int recipeNetId;

    public MultiRecipe(int typeId, UUID recipeId, int recipeNetId) {
        super(typeId);
        this.recipeId = recipeId;
        this.recipeNetId = recipeNetId;
    }

    public UUID getRecipeId() {
        return recipeId;
    }

    public int getRecipeNetId() {
        return recipeNetId;
    }

    @Override
    public void encode(PacketBuffer buffer) {
        buffer.writeUUID(this.recipeId);
        buffer.writeSignedVarInt(this.recipeNetId);
    }

    public static MultiRecipe decode(int typeId, PacketBuffer buffer) {
        return new MultiRecipe(typeId, buffer.readUUID(), buffer.readSignedVarInt());
    }
}
