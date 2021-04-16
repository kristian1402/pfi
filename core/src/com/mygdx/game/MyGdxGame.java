package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.player.Score;
import com.mygdx.game.player.player;


public class MyGdxGame extends ApplicationAdapter {

	//OrthographicCamera camera;
	SpriteBatch batch;
	Texture img; //For the background image
	player player;
	Score scoreRender;

	@Override
	public void create() {
		//camera = new OrthographicCamera();
		//camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		batch = new SpriteBatch();
		img = new Texture("backgroundimage.png");
		player = new player();
		scoreRender = new Score();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			//Begins batch and draws sprites

		batch.begin();
		for(int i = 0; i <= player.playerX+512; i += img.getWidth()){
			batch.draw(img, i, 0);
		}
		batch.setProjectionMatrix(player.camera.combined);
		batch.end();
		player.render();
		scoreRender.render();
	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
		player.dispose();
		scoreRender.dispose();
	}
}
