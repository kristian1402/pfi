package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.mygdx.game.player.Score.*;

public class player {

    public OrthographicCamera camera;
    private Rectangle player;
    private ShapeRenderer collider;
    private SpriteBatch batch;
    private Texture playerSprite;
    Vector2 playerPos;
    Vector2 velocity;
    Vector2 gravity;
    boolean grounded;

    float weight;
    public int playerX = 100;
    public int playerY = 50;

    public player() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        playerPos = new Vector2(100,50);
        velocity = new Vector2(0,15);
        gravity = new Vector2(0,-0.2f);
        collider = new ShapeRenderer();
        playerSprite = new Texture(Gdx.files.internal("player1.png"));
        player = new Rectangle(playerX,playerY,64,64);
        batch = new SpriteBatch();

        weight = 0.2f;
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void render(){
        batch.begin();
        velocity.add(gravity);
        batch.draw(playerSprite,playerPos.x,playerPos.y,64,128);

            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                playerPos.add(velocity);
                //velocity.add(gravity);
            }

        batch.end();

        collider.begin(ShapeRenderer.ShapeType.Line);
        collider.rect(playerX+8, playerY,50,128);
        collider.end();

        playerX+=5;

        camera.position.x = playerX;
        camera.update();
    }

    public void dispose(){
        playerSprite.dispose();
        batch.dispose();
    }
}
