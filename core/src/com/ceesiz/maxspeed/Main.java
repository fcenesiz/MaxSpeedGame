package com.ceesiz.maxspeed;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {

	public boolean skippedFirstFrame = false;
	SpriteBatch batch;
	Scene scene;

	@Override
	public void create () {
		batch = new SpriteBatch();
		scene = new Scene();
		scene.create();
	}

	public void update(float dt){
		scene.update(dt);
	}

	public void lateUpdate(float dt){
		scene.lateUpdate(dt);
	}

	@Override
	public void render () {
		if (skippedFirstFrame){
			float dt = Gdx.graphics.getDeltaTime();
			this.update(dt);
			this.lateUpdate(dt);

			ScreenUtils.clear(0, 0, 0, 1);
			batch.begin();
			scene.render(batch);
			batch.end();
		}
		skippedFirstFrame = true;
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
