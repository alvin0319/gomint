package io.gomint.server.world.block;

import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.BlockTripwireHook;
import io.gomint.world.block.BlockType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:tripwire_hook")
public class TripwireHook extends Block implements BlockTripwireHook {

    @Override
    public String blockId() {
        return "minecraft:tripwire_hook";
    }

    @Override
    public boolean transparent() {
        return true;
    }

    @Override
    public boolean solid() {
        return false;
    }

    @Override
    public float blastResistance() {
        return 0.0f;
    }

    @Override
    public BlockType blockType() {
        return BlockType.TRIPWIRE_HOOK;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

}
