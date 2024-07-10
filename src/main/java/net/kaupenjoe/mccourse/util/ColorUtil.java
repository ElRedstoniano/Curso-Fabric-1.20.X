package net.kaupenjoe.mccourse.util;

import java.awt.*;

public class ColorUtil {
    public static Color removeAlpha(Color color){
        return new Color(color.getRed(),color.getBlue(),color.getGreen(),0);
    }
}
