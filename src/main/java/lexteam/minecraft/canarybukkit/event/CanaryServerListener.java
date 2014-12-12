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
package lexteam.minecraft.canarybukkit.event;

import lexteam.minecraft.canarybukkit.impl.CanaryServer;
import lexteam.minecraft.canarybukkit.impl.command.CanaryCommandSender;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.command.ConsoleCommandHook;
import net.canarymod.hook.system.ServerListPingHook;
import net.canarymod.plugin.PluginListener;

import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.util.CachedServerIcon;

public class CanaryServerListener implements PluginListener {
    private CanaryServer server;

    public CanaryServerListener(CanaryServer server) {
        this.server = server;
    }

    @HookHandler
    public void onCommand(final ConsoleCommandHook hook) {
        String commandLine = "";
        for (String s : hook.getCommand()) {
            commandLine += s + " ";
        }
        if (server.dispatchCommand(new CanaryCommandSender(hook.getCaller()), commandLine)) {
            hook.setCanceled();
        }
    }

    @HookHandler
    public void onServerListPing(final ServerListPingHook hook) {
        server.getPluginManager().callEvent(
                new ServerListPingEvent(hook.getRequesterAddress(), hook.getMotd().getFullText(), hook
                        .getCurrentPlayers(), hook.getMaxPlayers()) {
                    @Override
                    public void setMotd(String motd) {
                        super.setMotd(motd);
                        hook.setMotd(motd);
                    }

                    @Override
                    public void setMaxPlayers(int maxPlayers) {
                        super.setMaxPlayers(maxPlayers);
                        hook.setMaxPlayers(maxPlayers);
                    }

                    @Override
                    public void setServerIcon(CachedServerIcon icon) throws IllegalArgumentException,
                            UnsupportedOperationException {
                        super.setServerIcon(icon);
                    }
                });
    }
}
