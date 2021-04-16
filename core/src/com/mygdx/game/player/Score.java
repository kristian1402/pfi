package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Score {
    private int currentScore;
    private int highScore = 0;
    public SpriteBatch batch;
    public BitmapFont score;
    private player player;

    public Score(){
        score = new BitmapFont();
        score.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        score.setColor(Color.WHITE);
        score.getData().setScale(2,2);

        player = new player();

        batch = new SpriteBatch();

        if (currentScore > highScore){
            highScore = currentScore;
        }
    }
    public void render(){
        batch.begin();
        score.draw(batch,"SCORE: "+currentScore,player.getPlayerX()-60, player.getPlayerY()+520);
        batch.end();
        currentScore++;
    }

    public void dispose(){
        batch.dispose();
        score.dispose();
        player.dispose();
    }
}

