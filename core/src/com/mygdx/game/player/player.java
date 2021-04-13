package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class player {

    Texture playerSprite;
    Rectangle player;
    Vector2 pos;
    float velocityY = 0;
    boolean grounded;
    float jumpVelocity = 5;
    float weight;
    int playerX = 341;
    int playerY =150;

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayer(int playerX, int playerY) {
        playerSprite = new Texture(Gdx.files.internal("player1.png"));
        player = new Rectangle();
        player.x = playerX;
        player.y = playerY;
        player.width = 64;
        player.height = 64;
        weight = 0.2f;
        this.pos = new Vector2(340,300);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void update(float deltaTime){
        if (playerY == 150){
            grounded = true;
        } else{
            grounded = false;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && grounded)
            playerY += jumpVelocity * getWeight();
        else if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !grounded && this.velocityY > 0)
            playerY += jumpVelocity * getWeight() * deltaTime;


    }







}
