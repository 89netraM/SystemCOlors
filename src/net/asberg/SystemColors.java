package net.asberg;

import net.asberg.windows.AccentColor;
import net.asberg.windows.Theme;

public class SystemColors {
	public static int getAccentColor(int fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			Integer winAccent = AccentColor.getAccentColor();
			if (winAccent != null) {
				return winAccent;
			}
		}

		return fallback;
	}

	public static boolean isLightTheme(boolean fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			Boolean b = Theme.IsLight();
			if (b != null) {
				return b;
			}
		}

		return fallback;
	}
	public static boolean isDarkTheme(boolean fallback) {
		return !isLightTheme(!fallback);
	}

	private SystemColors() { }
}