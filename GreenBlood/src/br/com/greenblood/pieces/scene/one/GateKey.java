package br.com.greenblood.pieces.scene.one;

import android.graphics.Bitmap;
import android.graphics.Rect;
import br.com.digitalpages.commons.awt.Listener;
import br.com.greenblood.img.Sprite;
import br.com.greenblood.pieces.StaticObject;
import br.com.greenblood.pieces.movable.Player;
import br.com.greenblood.util.ImageLoader;
import br.com.greenblood.world.GameWorld;

//TODO: After grabbing touch action
public class GateKey extends StaticObject {
	private final Player player;
	private boolean passingTroughThis;
	
	public GateKey(Rect bounds) {
		super(bounds);

		setSprite(new Sprite(
				new Bitmap[] { ImageLoader.image("boss/gate_key.PNG") },
				0, false));
		
		setCollidable(false);
		player = GameWorld.player();
	}

	@Override
	public void processLogics(long uptime) {
		Rect playerBounds = player.currentBoundingBounds();
		Rect thisBounds = currentBounds();
		if(Rect.intersects(playerBounds, thisBounds)){
			player.setOnNextActionListener(grabListener);
			passingTroughThis = true;
		}else if(passingTroughThis){
			passingTroughThis = false;
			player.setOnNextActionListener(null);
		}
	}
	
	private final Listener<Void> grabListener = new Listener<Void>() {
		@Override
		public boolean on(Void t) {
			GameWorld.world().displayItemView();
			player.setOnNextActionListener(null);
			kill();
			return false;
		}
	};

}
