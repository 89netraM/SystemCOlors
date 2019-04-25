package net.asberg.macos;

import java.util.concurrent.TimeUnit;

// Borrowed from: https://stackoverflow.com/questions/33477294/menubar-icon-for-dark-mode-on-os-x-in-java/33477375#33477375

class MacOSDefaults {
	static Integer ReadDefault(String name) {
		Integer ret = null;

		try {
			Process p = Runtime.getRuntime().exec("defaults read -g " + name);
			p.waitFor(100, TimeUnit.MILLISECONDS);
			ret = p.exitValue();
		}
		catch (Exception ignored) { }

		return ret;
	}

	private MacOSDefaults() { }
}