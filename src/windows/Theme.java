package windows;

public class Theme {
	public static Boolean IsLight() {
		String AppsUseLightTheme = WindowsRegistry.ReadKey("HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Themes\\Personalize", "AppsUseLightTheme");

		if (AppsUseLightTheme != null) {
			if (AppsUseLightTheme.startsWith("0x")) {
				AppsUseLightTheme = AppsUseLightTheme.substring(2);
			}

			try {
				return Integer.parseInt(AppsUseLightTheme, 16) == 1;
			}
			catch (NumberFormatException ignored) { }
		}

		return null;
	}

	public static Boolean IsDark() {
		Boolean b = IsLight();
		return b == null ? null : !b;
	}

	private Theme() { }
}
