package net.asberg.macos;

import java.awt.*;

public class Theme {
	public static Boolean IsLight() {
		return SystemColor.window.getRGB() > 0xfff;
	}

	public static Boolean IsDark() {
		Boolean b = IsLight();
		return b == null ? null : !b;
	}

	private Theme() { }
}