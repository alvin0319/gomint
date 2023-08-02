package io.gomint.server.world;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author geNAZt
 * @version 1.0
 */
public enum SoundMagicNumbers {

    ITEM_USE_ON(0),
    HIT(1),
    STEP(2),
    FLY(3),
    JUMP(4),
    BREAK(5),
    PLACE(6),
    HEAVY_STEP(7),
    GALLOP(8),
    FALL(9),
    AMBIENT(10),
    AMBIENT_BABY(11),
    AMBIENT_IN_WATER(12),
    BREATHE(13),
    DEATH(14),
    DEATH_IN_WATER(15),
    DEATH_TO_ZOMBIE(16),
    HURT(17),
    HURT_IN_WATER(18),
    MAD(19),
    BOOST(20),
    BOW(21),
    SQUISH_BIG(22),
    SQUISH_SMALL(23),
    FALL_BIG(24),
    FALL_SMALL(25),
    SPLASH(26),
    FIZZ(27),
    FLAP(28),
    SWIM(29),
    DRINK(30),
    EAT(31),
    TAKEOFF(32),
    SHAKE(33),
    PLOP(34),
    LAND(35),
    SADDLE(36),
    ARMOR(37),
    MOB_ARMOR_STAND_PLACE(38),
    ADD_CHEST(39),
    THROW(40),
    ATTACK(41),
    ATTACK_NODAMAGE(42),
    ATTACK_STRONG(43),
    WARN(44),
    SHEAR(45),
    MILK(46),
    THUNDER(47),
    EXPLODE(48),
    FIRE(49),
    IGNITE(50),
    FUSE(51),
    STARE(52),
    SPAWN(53),
    SHOOT(54),
    BREAK_BLOCK(55),
    LAUNCH(56),
    BLAST(57),
    LARGE_BLAST(58),
    TWINKLE(59),
    REMEDY(60),
    UNFECT(61),
    LEVELUP(62),
    BOW_HIT(63),
    BULLET_HIT(64),
    EXTINGUISH_FIRE(65),
    ITEM_FIZZ(66),
    CHEST_OPEN(67),
    CHEST_CLOSED(68),
    SHULKERBOX_OPEN(69),
    SHULKERBOX_CLOSED(70),
    ENDERCHEST_OPEN(71),
    ENDERCHEST_CLOSED(72),
    POWER_ON(73),
    POWER_OFF(74),
    ATTACH(75),
    DETACH(76),
    DENY(77),
    TRIPOD(78),
    POP(79),
    DROP_SLOT(80),
    NOTE(81),
    THORNS(82),
    PISTON_IN(83),
    PISTON_OUT(84),
    PORTAL(85),
    WATER(86),
    LAVA_POP(87),
    LAVA(88),
    BURP(89),
    BUCKET_FILL_WATER(90),
    BUCKET_FILL_LAVA(91),
    BUCKET_EMPTY_WATER(92),
    BUCKET_EMPTY_LAVA(93),
    ARMOR_EQUIP_CHAIN(94),
    ARMOR_EQUIP_DIAMOND(95),
    ARMOR_EQUIP_GENERIC(96),
    ARMOR_EQUIP_GOLD(97),
    ARMOR_EQUIP_IRON(98),
    ARMOR_EQUIP_LEATHER(99),
    ARMOR_EQUIP_ELYTRA(100),
    RECORD_13(101),
    RECORD_CAT(102),
    RECORD_BLOCKS(103),
    RECORD_CHIRP(104),
    RECORD_FAR(105),
    RECORD_MALL(106),
    RECORD_MELLOHI(107),
    RECORD_STAL(108),
    RECORD_STRAD(109),
    RECORD_WARD(110),
    RECORD_11(111),
    RECORD_WAIT(112),
    STOP_JUKEBOX(113),
    GUARDIAN_FLOP(114),
    ELDERGUARDIAN_CURSE(115),
    MOB_WARNING(116),
    MOB_WARNING_BABY(117),
    TELEPORT(118),
    SHULKER_OPEN(119),
    SHULKER_CLOSE(120),
    HAGGLE(121),
    HAGGLE_YES(122),
    HAGGLE_NO(123),
    HAGGLE_IDLE(124),
    CHORUSGROW(125),
    CHORUSDEATH(126),
    GLASS(127),
    POTION_BREWED(128),
    CAST_SPELL(129),
    PREPARE_ATTACK(130),
    PREPARE_SUMMON(131),
    PREPARE_WOLOLO(132),
    FANG(133),
    CHARGE(134),
    CAMERA_TAKE_PICTURE(135),
    LEASHKNOT_PLACE(136),
    LEASHKNOT_BREAK(137),
    GROWL(138),
    WHINE(139),
    PANT(140),
    PURR(141),
    PURREOW(142),
    DEATH_MIN_VOLUME(143),
    DEATH_MID_VOLUME(144),
    IMITATE_BLAZE(145),
    IMITATE_CAVE_SPIDER(146),
    IMITATE_CREEPER(147),
    IMITATE_ELDER_GUARDIAN(148),
    IMITATE_ENDER_DRAGON(149),
    IMITATE_ENDERMAN(150),
    IMITATE_EVOCATION_ILLAGER(152),
    IMITATE_GHAST(153),
    IMITATE_HUSK(154),
    IMITATE_ILLUSION_ILLAGER(155),
    IMITATE_MAGMA_CUBE(156),
    IMITATE_POLAR_BEAR(157),
    IMITATE_SHULKER(158),
    IMITATE_SILVERFISH(159),
    IMITATE_SKELETON(160),
    IMITATE_SLIME(161),
    IMITATE_SPIDER(162),
    IMITATE_STRAY(163),
    IMITATE_VEX(164),
    IMITATE_VINDICATION_ILLAGER(165),
    IMITATE_WITCH(166),
    IMITATE_WITHER(167),
    IMITATE_WITHER_SKELETON(168),
    IMITATE_WOLF(169),
    IMITATE_ZOMBIE(170),
    IMITATE_ZOMBIE_PIGMAN(171),
    IMITATE_ZOMBIE_VILLAGER(172),
    BLOCK_END_PORTAL_FRAME_FILL(173),
    BLOCK_END_PORTAL_SPAWN(174),
    RANDOM_ANVIL_USE(175),
    BOTTLE_DRAGONBREATH(176),
    PORTAL_TRAVEL(177);

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundMagicNumbers.class);

    private final int soundId;

    SoundMagicNumbers(int soundId) {
        this.soundId = soundId;
    }

    public int soundId() {
        return this.soundId;
    }

    public static SoundMagicNumbers valueOf(int id) {
        for (SoundMagicNumbers soundMagicNumbers : values()) {
            if (soundMagicNumbers.soundId == id) {
                return soundMagicNumbers;
            }
        }

        LOGGER.warn("Unknown sound: {}", id);
        return null;
    }

}
