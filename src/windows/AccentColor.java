package windows;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import java.util.Arrays;
import java.util.List;

public interface AccentColor extends Library {
	static Integer getAccentColor() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.startsWith("windows") && (os.endsWith("10") || os.endsWith("8"))) {
			final AccentColor dwmapi = Native.load("dwmapi", AccentColor.class);
			final AccentColor.DWMCOLORIZATIONcolors colors = new AccentColor.DWMCOLORIZATIONcolors.ByReference();
			dwmapi.DwmpGetColorizationParameters(colors);

			return colors.ColorizationColor;
		}
		else {
			return null;
		}
	}

	class DWMCOLORIZATIONcolors extends Structure {
		static class ByReference extends DWMCOLORIZATIONcolors implements Structure.ByReference { }

		public int ColorizationColor = 0;
		public int ColorizationAfterglow = 0;
		public int ColorizationColorBalance = 0;
		public int ColorizationAfterglowBalance = 0;
		public int ColorizationBlurBalance = 0;
		public int ColorizationGlassReflectionIntensity = 0;
		public int ColorizationOpaqueBlend = 0;

		DWMCOLORIZATIONcolors() { }

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