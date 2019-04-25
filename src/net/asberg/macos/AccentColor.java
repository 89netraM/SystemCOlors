package net.asberg.macos;

import java.util.HashMap;
import java.util.Map;

public class AccentColor {
	// <id, [light theme, dark theme]>
	private static final Map<Integer, int[]> colorMap = new HashMap<>();
	static {
		colorMap.put(null, new int[] {0x007AFF, 0x0A84FF}); // Blue
		colorMap.put(-1,   new int[] {0x8E8E93, 0x98989D}); // Gray
		colorMap.put(0,    new int[] {0xFF3B30, 0xFF453A}); // Red
		colorMap.put(1,    new int[] {0xFF9500, 0xFF9F0A}); // Orange
		colorMap.put(2,    new int[] {0xFFCC00, 0xFFD60A}); // Yellow
		colorMap.put(3,    new int[] {0x28CD41, 0x32D74B}); // Green
		colorMap.put(4,    new int[] {0xA2845E, 0xAC8E68}); // Probably brown 🤷️
		colorMap.put(5,    new int[] {0xFF375F, 0xBF5AF2}); // Purple
		colorMap.put(6,    new int[] {0xFF2D55, 0xFF375F}); // Pink
	}

	public static Integer getAccentColor() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("macos")) { // What's the name for MacOS?
			Integer color = MacOSDefaults.ReadDefault("AppleAccentColor");
			int[] accentColor = colorMap.get(color);

			if (Theme.IsDark() == Boolean.TRUE) {
				return accentColor[1];
			}
			else {
				return accentColor[0];
			}
		}

		return null;
	}

	private AccentColor() { }
}