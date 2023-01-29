package com.mygdx.game;

import javax.swing.Spring;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Sky {
    private Texture tx;    
    private Vector2 pos;
    private int speed;

    public Sky() {
        this.tx = new Texture("sky.jpg");
        pos = new Vector2(0, 0);
        speed = 4;
    }

    public void render(SpriteBatch batch) {
        batch.draw(tx, pos.x, pos.y);
        batch.draw(tx, pos.x + 800, pos.y);
    }

    public void update() {
        pos.x -= speed;
        if (pos.x < -800) {
            pos.x = 0;
        }
    }
}
