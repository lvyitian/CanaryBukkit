/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014 Lexteam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package lexteam.minecraft.canarybukkit.implementation.entity;

import lexteam.minecraft.canarybukkit.BukkitUtils;
import lexteam.minecraft.canarybukkit.CanaryUtils;
import net.canarymod.api.DamageType;
import net.canarymod.api.entity.living.LivingBase;
import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class CanaryLivingEntity extends CanaryEntity implements LivingEntity {

    public CanaryLivingEntity(net.canarymod.api.entity.living.LivingBase entity) {
        super(entity);
    }

    public void _INVALID_damage(int amount) {
        throw new NotImplementedException("_INVALID_damage(int)");
    }

    public void _INVALID_damage(int amount, Entity source) {
        throw new NotImplementedException("_INVALID_damage(int, Entity)");
    }

    public int _INVALID_getHealth() {
        return Float.floatToIntBits(getEntity().getHealth());
    }

    public int _INVALID_getLastDamage() {
        return 0;
    }

    public int _INVALID_getMaxHealth() {
        return (int) Math.round(getEntity().getMaxHealth());
    }

    public void _INVALID_setHealth(int health) {
        throw new NotImplementedException("_INVALID_setHealth(int)");
    }

    public void _INVALID_setLastDamage(int damage) {
        throw new NotImplementedException("_INVALID_setLastDamage(int)");
    }

    public void _INVALID_setMaxHealth(int health) {
        getEntity().setMaxHealth(health);
    }

    public boolean addPotionEffect(PotionEffect effect) {
        getEntity().addPotionEffect(CanaryUtils.getPotionEffect(effect));
        return true;
    }

    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return addPotionEffect(effect);
    }

    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        for (PotionEffect effect : effects) {
            addPotionEffect(effect);
        }

        return true;
    }

    public void damage(double amount) {
        getEntity().dealDamage(DamageType.GENERIC, (float) amount);
    }

    public void damage(double amount, Entity source) {
        // getEntity().attackEntity(source, amount);
        throw new NotImplementedException("damage(double, Entity)");
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        ArrayList<PotionEffect> ret = new ArrayList<PotionEffect>();
        for (net.canarymod.api.potion.PotionEffect potionEffect : getEntity().getAllActivePotionEffects()) {
            ret.add(BukkitUtils.getPotionEffect(potionEffect));
        }
        return ret;
    }

    public boolean getCanPickupItems() {
        throw new NotImplementedException("getCanPickupItems()");
    }

    public String getCustomName() {
        return getEntity().getName();
    }

    public EntityEquipment getEquipment() {
        throw new NotImplementedException("getEquipment()");
    }

    public double getEyeHeight() {
        return getEntity().getEyeHeight();
    }

    public double getEyeHeight(boolean ignoreSneaking) {
        return 0;
    }

    public Location getEyeLocation() {
        throw new NotImplementedException("getEyeLocation()");
    }

    public double getHealth() {
        return getEntity().getHealth();
    }

    public Player getKiller() {
        LivingBase temp = getEntity().getLastAssailant();
        if (temp != null && temp.isPlayer()) {
            return (new CanaryPlayer((net.canarymod.api.entity.living.humanoid.Player) temp));
        }
        else {
            return null;
        }
    }

    public double getLastDamage() {
        throw new NotImplementedException("getLastDamage()");
    }

    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("getLastTwoTargetBlocks(HashSet<Byte>, int)");
    }

    public Entity getLeashHolder() throws IllegalStateException {
        throw new NotImplementedException("getLeashHolder()");
    }

    public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("getLineOfSight(HashSet<Byte>, int)");
    }

    public double getMaxHealth() {
        return getEntity().getMaxHealth();
    }

    public int getMaximumAir() {
        throw new NotImplementedException("getMaximumAir()");
    }

    public int getMaximumNoDamageTicks() {
        return getEntity().getInvulnerabilityTicks();
        // TODO check if that is what this means
    }

    public int getNoDamageTicks() {
        return getEntity().getInvulnerabilityTicks();
    }

    public int getRemainingAir() {
        throw new NotImplementedException("getRemainingAir()");
    }

    public boolean getRemoveWhenFarAway() {
        throw new NotImplementedException("getRemoveWhenFarAway()");
    }

    public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {
        throw new NotImplementedException("getTargetBlock(HashSet<Byte>, int)");
    }

    public boolean hasLineOfSight(Entity other) {
        throw new NotImplementedException("hasLineOfSight(Entity)");
    }

    public boolean hasPotionEffect(PotionEffectType type) {
        throw new NotImplementedException("hasPotionEffect(PotionEffectType)");
    }

    public boolean isCustomNameVisible() {
        throw new NotImplementedException("isCustomNameVisible()");
    }

    public boolean isLeashed() {
        throw new NotImplementedException("isLeashed()");
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        throw new NotImplementedException("launchProjectile(Class<? extends T>)");
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        throw new NotImplementedException("launchProjectile(Class<? extends T>, Vector)");
    }

    public void removePotionEffect(PotionEffectType type) {
        getEntity().removePotionEffect(CanaryUtils.getPotionEffectType(type));
    }

    public void resetMaxHealth() {
        throw new NotImplementedException("resetMaxHealth()");
    }

    public void setCanPickupItems(boolean pickup) {
        throw new NotImplementedException("setCanPickupItems(boolean)");
    }

    public void setCustomName(String name) {
        throw new NotImplementedException("setCustomName(String)");
    }

    public void setCustomNameVisible(boolean flag) {
        throw new NotImplementedException("setCustomNameVisible(boolean)");
    }

    public void setHealth(double health) {
        getEntity().setHealth((float) health);
    }

    public void setLastDamage(double damage) {
        throw new NotImplementedException("setLastDamage(double)");
    }

    public boolean setLeashHolder(Entity holder) {
        throw new NotImplementedException("setLeashHolder(Entity)");
    }

    public void setMaxHealth(double health) {
        getEntity().setMaxHealth(health);
    }

    public void setMaximumAir(int ticks) {
        throw new NotImplementedException("setMaximumAir(int)");
    }

    public void setMaximumNoDamageTicks(int ticks) {
        getEntity().setInvulnerabilityTicks(ticks);
        // TODO check if that is what this means
    }

    public void setNoDamageTicks(int ticks) {
        getEntity().setInvulnerabilityTicks(ticks);
    }

    public void setRemainingAir(int ticks) {
        throw new NotImplementedException("setRemainingAir(int)");
    }

    public void setRemoveWhenFarAway(boolean remove) {
        throw new NotImplementedException("setRemoveWhenFarAway(boolean)");
    }

    public Arrow shootArrow() {
        throw new NotImplementedException("shootArrow()");
    }

    public Egg throwEgg() {
        throw new NotImplementedException("throwEgg()");
    }

    public Snowball throwSnowball() {
        throw new NotImplementedException("throwSnowball()");
    }

    protected LivingBase getEntity() {
        return (LivingBase) super.getEntity();
    }

}
