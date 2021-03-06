package br.com.greenblood.core;

import android.graphics.Rect;
import br.com.greenblood.math.Vector2D;

public class GameCore {
    public static final int TILE_SIZE = 50;
    private static float scale;

    public static int tilesToPixels(int tile) {
        return (int) (tile * TILE_SIZE * scale);
    }

    public static int tilesToPixels(float tile) {
        return tilesToPixels((int) tile);
    }

    public static int pixelsToTiles(int pixel) {
        return (int) (pixel / scale / TILE_SIZE) ;
    }

    public static int pixelsToTiles(float pixel) {
        return pixelsToTiles((int) pixel);
    }

    public static void setAppliedScale(float scale) {
        GameCore.scale = scale;
    }

    public static int tileSize() {
        return (int) (TILE_SIZE * scale);
    }

    public static float scale() {
        return scale;
    }

	public static Vector2D tilesToPixel(Vector2D pos) {
		return new Vector2D(GameCore.tilesToPixels(pos.x()), GameCore.tilesToPixels(pos.y()));
	}
	
	
	
	private static float screenDensity;
	private static int oneDp;
	public static void setDensity(float density){
		screenDensity = density;
		oneDp = pixels(1);
	}
	
	private static Object res;
	public static int pixels(float dp){
		return (int) (screenDensity * dp + 0.5f);
	}

	public static int oneDp() {
		return oneDp;
	}
}
