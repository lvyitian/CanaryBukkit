/**
 * This file is part of CanaryMod-BukkitAPI, a CanaryMod plugin, licensed under the MIT License (MIT).
 *
 * Copyright (c) Lexteam <https://github.com/Lexteam>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lexteam.minecraft.canarybukkit;

import lexteam.minecraft.canarybukkit.data.Constants;
import lexteam.minecraft.canarybukkit.implementation.CanaryServer;

import org.bukkit.Bukkit;
import net.canarymod.Canary;
import net.canarymod.plugin.Plugin;

public class CanaryBukkit extends Plugin {
	private CanaryServer server;

	@Override
	public boolean enable() {
		if(Bukkit.getServer() != null) {
			server = new CanaryServer(Canary.getServer(), getLogman());
		}
		Bukkit.setServer(server);
		
		// Enable Listener
		Canary.hooks().registerListener(new CanaryListener(), this);
		
		if(!Constants.bukkitDir.exists()) {
			Constants.pluginsDir.mkdirs();
		}
		server.loadPlugins();
		server.enablePlugins();
		
		return true;
	}

	@Override
	public void disable() {
		server.disablePlugins();
	}
}
