package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class player {

    Texture playerSprite;
    Rectangle player;
    Vector2 pos;
    Texture texture;

    float weight;
    public int playerX;
    public int playerY;

    public player() {
        playerSprite = new Texture(Gdx.files.internal("player1.png"));
        texture = new Texture(Gdx.files.internal("playeranimation.png"));
        player = new Rectangle();
        player.width = 64;
        player.height = 64;
        weight = 0.2f;
        this.pos = new Vector2(340, 300);
    }

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

}
