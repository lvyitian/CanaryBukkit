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
package uk.jamierocks.canarybukkit.impl;

import io.github.lexware.unolib.Wrapper;
import net.canarymod.bansystem.Ban;
import org.bukkit.BanEntry;

import java.util.Date;

public class CanaryBanEntry extends Wrapper<Ban> implements BanEntry {

    private String target;
    private String source;
    private String reason;
    private Date created;
    private Date expires;

    public CanaryBanEntry(Ban ban) {
        super(ban);
        this.target = ban.getSubject();
        this.created = new Date(ban.getIssuedDate());
        this.source = ban.getBanningPlayer();
        this.expires = new Date(ban.getExpiration());
        this.reason = ban.getReason();
    }

    @Override
    public String getTarget() {
        return this.target;
    }

    @Override
    public Date getCreated() {
        return this.created;
    }

    @Override
    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public Date getExpiration() {
        return this.expires;
    }

    @Override
    public void setExpiration(Date expiration) {
        this.expires = expiration;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void save() {
        this.getHandle().setIssuedDate(this.created.getTime());
        this.getHandle().setBanningPlayer(this.source);
        this.getHandle().setExpiration(this.expires.getTime());
        this.getHandle().setReason(this.reason);
    }
}
