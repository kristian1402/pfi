package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.player.player;

public class MyGdxGame extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img; //For the background image
	Texture playerSprite;
	player player;
	int backgroundOffset = 1;
	ShapeRenderer shapeRenderer; //bruges til at lave en kasse rundt om player, så man kan se kollisioner. kun midlertidig

	
	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.update();

		batch = new SpriteBatch();
		img = new Texture("backgroundimage.png");

		shapeRenderer = new ShapeRenderer();

		player = new player();
		playerSprite = new Texture(Gdx.files.internal("player1.png"));
		player.playerX = 150;
		player.playerY = 50;


	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.position.x = player.getPlayerX();
		camera.update();
			//Begins batch and draws sprites

		backgroundOffset+=5;
		if (backgroundOffset > Gdx.graphics.getWidth()){
			backgroundOffset = 0;
		}

		batch.begin();
		for(int i = 0; i <= player.getPlayerX()+512; i += img.getWidth()){
			batch.draw(img, i, 0);
		}
		batch.draw(playerSprite,player.getPlayerX(),player.getPlayerY(),64,128);
		batch.setProjectionMatrix(camera.combined);
		batch.end();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(player.getPlayerX(), player.getPlayerY(), 48,128);
		shapeRenderer.end();

		player.playerX+=5;
/*
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			player.playerX+=5;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			player.playerX-=5;
		}

 */

	}

	@Override
	public void dispose() {
		img.dispose();
		playerSprite.dispose();
		batch.dispose();
	}
}
