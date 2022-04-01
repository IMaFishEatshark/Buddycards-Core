package com.wildcard.buddycards.gear;

import com.wildcard.buddycards.Buddycards;
import com.wildcard.buddycards.registries.BuddycardsItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public enum BuddycardsArmorMaterial implements ArmorMaterial {
    BUDDYSTEEL(12, 36, new int[]{3, 8, 6, 3}, Ingredient.of(BuddycardsItems.BUDDYSTEEL_INGOT.get()), "buddysteel"),
    LUMINIS(8, 18, new int[]{3, 8, 6, 3}, Ingredient.of(BuddycardsItems.CRIMSON_LUMINIS.get()), "luminis"),
    ZYLEX(8, 18, new int[]{3, 8, 6, 3}, Ingredient.of(BuddycardsItems.ZYLEX.get()), "zylex");

    BuddycardsArmorMaterial(int enchVal, int dura, int[] red, Ingredient mat, String nameIn) {
        ench = enchVal;
        duraMult = dura;
        material = mat;
        name = nameIn;
        dam_red = red;
    }
    int ench;
    int duraMult;
    Ingredient material;
    String name;
    int[] dam_red;

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};

    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return HEALTH_PER_SLOT[slotIn.getIndex()] * duraMult;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return dam_red[slotIn.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return ench;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return material;
    }

    @Override
    public String getName() {
        return Buddycards.MOD_ID + ":" + name;
    }

    @Override
    public float getToughness() {
        return 1;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
