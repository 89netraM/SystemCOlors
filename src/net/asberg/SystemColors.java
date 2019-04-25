package net.asberg;

public class SystemColors {
	public static int getAccentColor(int fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		Integer accentColor = null;
		if (os.contains("windows")) {
			accentColor = net.asberg.windows.AccentColor.getAccentColor();
		}
		else if (os.contains("macos")) { // What's the name for MacOS?
			accentColor = net.asberg.macos.AccentColor.getAccentColor();
		}

		if (accentColor != null) {
			return accentColor;
		}
		else {
			return fallback;
		}
	}

	public static boolean isLightTheme(boolean fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			Boolean b = net.asberg.windows.Theme.IsLight();
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