package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;

public class player {

    private final Object main;
    private Rectangle player;
    private ShapeRenderer collider;
    private SpriteBatch batch;
    private Texture playerSprite;
    private int currentScore;
    private float highScore = 0;

    public BitmapFont score;
    public OrthographicCamera camera;

    float weight;
    public int playerX = 100;
    public int playerY = 50;

    public player() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        main = new MyGdxGame();
        collider = new ShapeRenderer();
        playerSprite = new Texture(Gdx.files.internal("player1.png"));
        player = new Rectangle(playerX,playerY,64,64);
        batch = new SpriteBatch();

        weight = 0.2f;

        score = new BitmapFont();
        score.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        score.setColor(Color.WHITE);
        score.getData().setScale(2,2);

        if (currentScore > highScore){
            highScore = currentScore;
        }

    }

    public void render(){
        batch.begin();
        batch.draw(playerSprite,playerX,playerY,64,128);
        score.draw(batch,"SCORE: "+currentScore, playerX-517, playerY+520);
        batch.end();

        collider.begin(ShapeRenderer.ShapeType.Line);
        collider.rect(playerX+8, playerY,50,128);
        collider.end();

        currentScore++;
        playerX+=5;

        camera.position.x = playerX;
        camera.update();
    }

    public void dispose(){
        playerSprite.dispose();
        batch.dispose();
    }
}
