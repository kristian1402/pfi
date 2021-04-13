package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class player {

    Texture playerSprite;
    Rectangle player;
    Vector2 pos;
    Texture texture;

    float velocityY = 0;
    boolean grounded;
    float jumpVelocity = 5;
    float weight;
    int playerX = 150;
    int playerY = 150;

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public player(int playerX, int playerY) {
        playerSprite = new Texture(Gdx.files.internal("player1.png"));
        texture = new Texture(Gdx.files.internal("playeranimation.png"));
        player = new Rectangle();
        player.x = playerX;
        player.y = playerY;
        player.width = 64;
        player.height = 64;
        weight = 0.2f;
        this.pos = new Vector2(340,300);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.x -= 50; Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.x += 50; Gdx.graphics.getDeltaTime();
        }
    }

    public float getWeight() {
        return weight;
    }

    public void update(){
        grounded = playerY == 150;

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && grounded)
            playerY += jumpVelocity * getWeight();
        else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && this.velocityY > 0)
            playerY += jumpVelocity * getWeight() * Gdx.graphics.getDeltaTime();


    }

}
