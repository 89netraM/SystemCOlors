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

	private SystemColors() { }
}