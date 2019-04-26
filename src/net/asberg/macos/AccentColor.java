package net.asberg.macos;

import java.awt.*;

public class AccentColor {
	public static Integer getAccentColor() {
		return SystemColor.controlHighlight.getRGB();
	}

	private AccentColor() { }
}