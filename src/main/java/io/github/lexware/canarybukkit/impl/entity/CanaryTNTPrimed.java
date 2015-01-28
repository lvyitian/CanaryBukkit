/**
 * This file is part of CanaryBukkit, a Bukkit implementation for CanaryLib.
 * Copyright (C) 2014-2015 CanaryBukkitTeam
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
package io.github.lexware.canarybukkit.impl.entity;

import io.github.lexware.canarybukkit.BukkitUtils;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

public class CanaryTNTPrimed extends CanaryExplosive implements TNTPrimed {
    public CanaryTNTPrimed(net.canarymod.api.entity.TNTPrimed entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.PRIMED_TNT;
    }

    public void setFuseTicks(int fuseTicks) {
        getHandle().setFuse(fuseTicks);
    }

    public int getFuseTicks() {
        return getHandle().getFuse();
    }

    public org.bukkit.entity.Entity getSource() {
        return BukkitUtils.getEntity(getHandle().getActivatedBy());
    }

    @Override
    protected net.canarymod.api.entity.TNTPrimed getHandle() {
        return (net.canarymod.api.entity.TNTPrimed) super.getHandle();
    }
}