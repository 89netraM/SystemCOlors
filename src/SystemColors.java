public class SystemColors {
	public static int getAccentColor(int fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			Integer winAccent = windows.AccentColor.getAccentColor();
			if (winAccent != null) {
				return winAccent;
			}
		}

		return fallback;
	}

	public static boolean isLightTheme(boolean fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			Boolean b = windows.Theme.IsLight();
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