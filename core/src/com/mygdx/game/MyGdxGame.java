package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
	Music jumpSound;
	Texture playerSprite;
	player player;
	int backgroundOffset = 1;
	ShapeRenderer shapeRenderer; //bruges til at lave en kasse rundt om player, så man kan se kollisioner. kun midlertidig

	
	@Override
	public void create() {
		player = new player(400,300);
		camera = new OrthographicCamera();
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch = new SpriteBatch();
		img = new Texture("backgroundimage.png");
		jumpSound = Gdx.audio.newMusic(Gdx.files.internal("jump.mp3"));
		playerSprite = new Texture(Gdx.files.internal("player1.png"));
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void render() {
		player.update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		camera.update();
			//Begins batch and draws sprites
		backgroundOffset++;
		if (backgroundOffset > Gdx.graphics.getWidth()){
			backgroundOffset = 0;
		}

		batch.begin();
		batch.draw(img,-backgroundOffset,0);
		batch.draw(playerSprite, player.getPlayerX(),player.getPlayerY(),64,128);
		batch.end();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(player.getPlayerX()+8, player.getPlayerY(), 50,128);
		shapeRenderer.end();

	}


	@Override
	public void dispose() {
		img.dispose();
		playerSprite.dispose();
		batch.dispose();
	}
}
