package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Bird {
    Texture tx;
    Vector2 pos;
    float vy;
	float gravity;

    public Bird() {
        this.tx = new Texture("bird.png");
        this.pos = new Vector2(100, 380);   
        vy = 0;
		gravity = -0.7f;    
    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            vy = 10;
        }

        vy += gravity;
        pos.y += vy; 
    }

    public void restart() {
        this.pos = new Vector2(100, 380);   
        vy = 0;
		gravity = -0.7f;  
    }
}
