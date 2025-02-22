package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.Block;
import io.gomint.world.block.BlockLog;
import io.gomint.world.block.data.Axis;
import io.gomint.world.block.data.LogType;
import java.time.Duration;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:wood")
@RegisterInfo(sId = "minecraft:log", def = true)
@RegisterInfo(sId = "minecraft:log2")
@RegisterInfo(sId = "minecraft:crimson_stem")
@RegisterInfo(sId = "minecraft:warped_stem")
@RegisterInfo(sId = "minecraft:stripped_oak_log")
@RegisterInfo(sId = "minecraft:stripped_spruce_log")
@RegisterInfo(sId = "minecraft:stripped_birch_log")
@RegisterInfo(sId = "minecraft:stripped_jungle_log")
@RegisterInfo(sId = "minecraft:stripped_dark_oak_log")
@RegisterInfo(sId = "minecraft:stripped_acacia_log")
@RegisterInfo(sId = "minecraft:stripped_crimson_stem")
@RegisterInfo(sId = "minecraft:stripped_warped_stem")
@RegisterInfo(sId = "minecraft:warped_hyphae")
@RegisterInfo(sId = "minecraft:crimson_hyphae")
public class ItemLog extends ItemStack<io.gomint.inventory.item.ItemLog> implements io.gomint.inventory.item.ItemLog {

    private enum LogTypeMagic {
        OAK("minecraft:log", "minecraft:stripped_oak_log", (short) 0, "minecraft:wood", (short) 0, (short) 8),
        SPRUCE("minecraft:log", "minecraft:stripped_spruce_log", (short) 1, "minecraft:wood", (short) 1, (short) 9),
        BIRCH("minecraft:log", "minecraft:stripped_birch_log", (short) 2, "minecraft:wood", (short) 2, (short) 10),
        JUNGLE("minecraft:log", "minecraft:stripped_jungle_log", (short) 3, "minecraft:wood", (short) 3, (short) 11),
        ACACIA("minecraft:log2", "minecraft:stripped_acacia_log", (short) 0, "minecraft:wood", (short) 4, (short) 12),
        DARK_OAK("minecraft:log2", "minecraft:stripped_dark_oak_log", (short) 1, "minecraft:wood", (short) 5, (short) 13),
        CRIMSON("minecraft:crimson_stem", "minecraft:stripped_crimson_stem", (short) 0, "minecraft:crimson_hyphae", "minecraft:stripped_crimson_hyphae"),
        WARPED("minecraft:warped_stem", "minecraft:stripped_warped_stem", (short) 0, "minecraft:warped_hyphae", "minecraft:stripped_warped_hyphae");

        private final String logBlockId;
        private final String strippedLogBlockId;
        private final short dataValue;
        private final String woodBlockId;

        private String strippedWoodBlockId;
        private short woodDataValue = -1;
        private short strippedWoodDataValue = -1;

        LogTypeMagic(String logBlockId, String strippedLogBlockId, short dataValue, String woodBlockId, String strippedWoodBlockId) {
            this.logBlockId = logBlockId;
            this.strippedLogBlockId = strippedLogBlockId;
            this.dataValue = dataValue;
            this.woodBlockId = woodBlockId;

            this.strippedWoodBlockId = strippedWoodBlockId;
        }

        LogTypeMagic(String logBlockId, String strippedLogBlockId, short dataValue, String woodBlockId, short woodDataValue, short strippedWoodDataValue) {
            this.logBlockId = logBlockId;
            this.strippedLogBlockId = strippedLogBlockId;
            this.dataValue = dataValue;
            this.woodBlockId = woodBlockId;

            this.woodDataValue = woodDataValue;
            this.strippedWoodDataValue = strippedWoodDataValue;
        }
    }

    @Override
    public Duration burnTime() {
        return Duration.ofMillis(15000);
    }

    @Override
    public ItemType itemType() {
        return ItemType.LOG;
    }

    @Override
    public boolean stripped() {
        for (LogTypeMagic value : LogTypeMagic.values()) {
            if (value.strippedLogBlockId.equals(this.material()) ||
                (value.strippedWoodDataValue > -1 &&
                    value.woodBlockId.equals(this.material()) &&
                    this.data() == value.strippedWoodDataValue) ||
                this.material().equals(value.strippedWoodBlockId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemLog stripped(boolean stripped) {
        return this.calculate(LogTypeMagic.valueOf(this.type().name()), this.axis(), stripped, this.barkOnAllSides());
    }

    @Override
    public ItemLog type(LogType type) {
        return this.calculate(LogTypeMagic.valueOf(type.name()), this.axis(), this.stripped(), this.barkOnAllSides());
    }

    @Override
    public LogType type() {
        for (LogTypeMagic value : LogTypeMagic.values()) {
            if ((value.logBlockId.equals(this.material()) && (this.data() & 3) == value.dataValue) ||
                (value.strippedLogBlockId.equals(this.material())) ||
                (value.woodBlockId.equals(this.material()) && (value.woodDataValue == -1 || this.data() == value.woodDataValue)) ||
                (value.woodBlockId.equals(this.material()) && (value.strippedWoodDataValue == -1 || this.data() == value.strippedWoodDataValue)) ||
                this.material().equals(value.strippedWoodBlockId)) {
                return LogType.valueOf(value.name());
            }
        }

        return null;
    }

    @Override
    public io.gomint.inventory.item.ItemLog barkOnAllSides(boolean allSides) {
        return this.calculate(LogTypeMagic.valueOf(this.type().name()), this.axis(), this.stripped(), allSides);
    }

    @Override
    public boolean barkOnAllSides() {
        for (LogTypeMagic value : LogTypeMagic.values()) {
            if (this.material().equals(value.woodBlockId) ||
                this.material().equals(value.strippedWoodBlockId)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemLog axis(Axis axis) {
        return this.calculate(LogTypeMagic.valueOf(this.type().name()), axis, this.stripped(), this.barkOnAllSides());
    }

    @Override
    public Axis axis() {
        if ((this.stripped() && this.data() == 1) || (this.data() & 5) == 5) {
            return Axis.X;
        }
        if ((this.stripped() && this.data() == 2) || (this.data() & 6) == 6) {
            return Axis.Z;
        }

        return Axis.Y;
    }

    private ItemLog calculate(LogTypeMagic type, Axis axis, boolean stripped, boolean bark) {
        if (stripped) {
            if (bark) {
                if (type.strippedWoodDataValue > -1) {
                    this.material(type.woodBlockId);
                    this.data(type.strippedWoodDataValue);
                } else {
                    this.material(type.strippedWoodBlockId);
                    this.data((short) 0);
                }
            } else {
                this.material(type.strippedLogBlockId);
                this.data((short) 0);
            }
        } else {
            if (bark) {
                this.material(type.woodBlockId);

                if (type.woodDataValue > -1) {
                    this.data(type.woodDataValue);
                } else {
                    this.data((short) 0);
                }
            } else {
                this.material(type.logBlockId);
                this.data(type.dataValue);
            }
        }

        if (!bark) {
            if (stripped) {
                switch (axis) {
                    case Y:
                        this.data((short) 0);
                        break;
                    case X:
                        this.data((short) 1);
                        break;
                    case Z:
                        this.data((short) 2);
                        break;
                }
            } else {
                switch (axis) {
                    case Y:
                        break;
                    case X:
                        this.data((short) (this.data() + 5));
                        break;
                    case Z:
                        this.data((short) (this.data() + 6));
                        break;
                }
            }
        }

        return this;
    }

    @Override
    public Block block() {
        BlockLog block = (BlockLog) super.block();
        block.type(this.type());
        block.barkOnAllSides(this.barkOnAllSides());
        block.stripped(this.stripped());
        return block;
    }
}
