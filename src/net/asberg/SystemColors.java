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

		Boolean isLight = null;
		if (os.contains("windows")) {
			isLight = net.asberg.windows.Theme.IsLight();
		}
		else if (os.contains("macos")) { // What's the name for MacOS?
			isLight = net.asberg.macos.Theme.IsLight();
		}

		if (isLight != null) {
			return isLight;
		}
		else {
			return fallback;
		}
	}
	public static boolean isDarkTheme(boolean fallback) {
		return !isLightTheme(!fallback);
	}

	private SystemColors() { }
}