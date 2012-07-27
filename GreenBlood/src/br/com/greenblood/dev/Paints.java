package br.com.greenblood.dev;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Paints {
    public static final Paint BLACK, BLUE, WHITE, RED;
    public static final Paint STROKE_BLUE;
    
    static{
        BLACK = new Paint();
        BLACK.setColor(Color.BLACK);
        
        BLUE = new Paint();
        BLUE.setColor(Color.BLUE);
        
        WHITE = new Paint();
        WHITE.setColor(Color.WHITE);
        
        RED = new Paint();
        RED.setColor(Color.RED);
        
        STROKE_BLUE = new Paint();
        STROKE_BLUE.setColor(Color.BLUE);
        STROKE_BLUE.setStyle(Style.STROKE);
    }
}
