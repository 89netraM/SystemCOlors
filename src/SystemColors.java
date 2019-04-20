public class SystemColors {
	public static String getAccentColor(String fallback) {
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("windows")) {
			String winAccent = windows.AccentColor.getAccentColor();
			if (winAccent != null) {
				return winAccent;
			}
		}

		return fallback;
	}

	private SystemColors() { }
}