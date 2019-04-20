package windows;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.List;

public interface AccentColor extends Library {
	public static String getAccentColor() {
		String os = System.getProperty("os.name");
		if (os.startsWith("Windows") && (os.endsWith("10") || os.endsWith("8"))) {
			final AccentColor dwmapi = Native.load("dwmapi", AccentColor.class);
			final AccentColor.DWMCOLORIZATIONcolors colors = new AccentColor.DWMCOLORIZATIONcolors.ByReference();
			dwmapi.DwmpGetColorizationParameters(colors);

			return String.format("%06X", colors.ColorizationColor & 0xFFFFFF);
		}
		else {
			return null;
		}
	}

	class DWMCOLORIZATIONcolors extends Structure {
		static class ByReference extends DWMCOLORIZATIONcolors implements Structure.ByReference { }

		int ColorizationColor = 0;
		int ColorizationAfterglow = 0;
		int ColorizationColorBalance = 0;
		int ColorizationAfterglowBalance = 0;
		int ColorizationBlurBalance = 0;
		int ColorizationGlassReflectionIntensity = 0;
		int ColorizationOpaqueBlend = 0;

		@Override
		protected List<String> getFieldOrder() {
			return Arrays.asList(
				"ColorizationColor",
				"ColorizationAfterglow",
				"ColorizationColorBalance",
				"ColorizationAfterglowBalance",
				"ColorizationBlurBalance",
				"ColorizationGlassReflectionIntensity",
				"ColorizationOpaqueBlend"
			);
		}
	}

	void DwmpGetColorizationParameters(DWMCOLORIZATIONcolors colors);
}