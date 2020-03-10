package com.hdquan;

import java.awt.GraphicsEnvironment;
public class FontFamilyNames {
    String allFontNames[];
    public String [] getFontName() {
      GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
      allFontNames=ge.getAvailableFontFamilyNames();
      return allFontNames;
    }
}
