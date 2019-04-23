package windows;

public class AccentColor {
	public static Integer getAccentColor() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("windows") && (os.endsWith("10") || os.endsWith("8"))) {
			String AccentColor = WindowsRegistry.ReadKey("HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\DWM", "AccentColor");
			if (AccentColor != null && (AccentColor = AccentColor.toUpperCase()).matches("(?:0X)?[0-9|A-F]{8}")) {
				if (AccentColor.startsWith("0X")) {
					AccentColor = AccentColor.substring(2);
				}

				int f = Integer.parseUnsignedInt(AccentColor, 16);
				return ((f & 0x0000ff) << 16) | (f & 0x00ff00) | ((f & 0xff0000) >> 16);
			}
		}

		return null;
	}

	private AccentColor() { }
}