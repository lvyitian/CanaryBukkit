/*
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
package uk.jamierocks.canarybukkit.impl.entity;

import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;

public class CanaryBat extends CanaryAmbient implements Bat {

    public CanaryBat(net.canarymod.api.entity.living.animal.Bat entity) {
        super(entity);
    }

    public EntityType getType() {
        return EntityType.BAT;
    }

    public boolean isAwake() {
        return !getHandle().isHanging();
    }

    public void setAwake(boolean awake) {
        getHandle().setHanging(!awake);
    }

    @Override
    protected net.canarymod.api.entity.living.animal.Bat getHandle() {
        return (net.canarymod.api.entity.living.animal.Bat) super.getHandle();
    }
}
