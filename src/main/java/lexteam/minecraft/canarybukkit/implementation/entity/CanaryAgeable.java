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
package lexteam.minecraft.canarybukkit.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Ageable;

public class CanaryAgeable extends CanaryCreature implements Ageable {
	public CanaryAgeable(net.canarymod.api.entity.living.LivingBase entity) {
		super(entity);
	}

	public int getAge() {
		return 0;
	}

	public void setAge(int age) {
		throw new NotImplementedException();
	}

	public void setAgeLock(boolean lock) {
		throw new NotImplementedException();
	}

	public boolean getAgeLock() {
		return false;
	}

	public void setBaby() {
		if (isAdult()) {
			setAge(-24000);
		}
	}

	public void setAdult() {
		if (!isAdult()) {
			setAge(0);
		}
	}

	public boolean isAdult() {
		return getAge() >= 0;
	}

	public boolean canBreed() {
		return getAge() == 0;
	}

	public void setBreed(boolean breed) {
		throw new NotImplementedException();
	}
}