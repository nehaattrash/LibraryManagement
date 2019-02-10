package com.librarymanagement.utility;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSizeUtility {
	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static  int getMaxWidth() {
		int width = (int)(screenSize.getWidth());
		return width;
	}
	public static int getMaxHeight() {
		int height = (int)(screenSize.getHeight());
		return height;
	}
}
