package net.asberg.macos;

public class Theme {
	public static Boolean IsLight() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("macos")) { // What's the name for MacOS?
			Integer theme = MacOSDefaults.ReadDefault("AppleInterfaceStyle");

			if (theme != null) {
				if (theme == 0) {
					return false;
				}
				else {
					return true;
				}
			}
		}

		return null;
	}

	public static Boolean IsDark() {
		Boolean b = IsLight();
		return b == null ? null : !b;
	}

	private Theme() { }
}