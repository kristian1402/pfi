package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.player.player;

public class MyGdxGame extends ApplicationAdapter {

	OrthographicCamera camera;
	SpriteBatch batch;
	Texture img; //For the background image
	Music jumpSound;
	Texture playerSprite;
	com.mygdx.game.player.player player;
	int backgroundOffset;

	
	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		img = new Texture("background.png");
		jumpSound = Gdx.audio.newMusic(Gdx.files.internal("jump.mp3"));
		playerSprite = new Texture(Gdx.files.internal("player1.png"));
		player = new player();

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		camera.update();
			//Begins batch and draws sprites
		backgroundOffset++;
		if (backgroundOffset % Gdx.graphics.getWidth() == 0){
			backgroundOffset = 0;
		}

		batch.begin();
		batch.draw(img,-backgroundOffset,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw(playerSprite, player.getPlayerX(), player.getPlayerY(),64,128);
		batch.end();

		/*	//User input
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			player.x -= 50; Gdx.graphics.getDeltaTime();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			player.x += 50; Gdx.graphics.getDeltaTime();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
			jumpSound.play();
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
