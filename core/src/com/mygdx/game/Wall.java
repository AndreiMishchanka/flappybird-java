package com.mygdx.game;

import java.util.Random;

import javax.swing.text.Position;
import javax.xml.transform.Templates;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Wall {
    class WallPair {
        Vector2 pos;
        float speed;
        int deviation;
        Rectangle EmptySpace;

        public WallPair (Vector2 pos) {
            this.pos = pos;
            this.speed = 2;
            this.deviation = new Random().nextInt(250);
            this.EmptySpace = new Rectangle(pos.x, pos.y - deviation + 300, 50, distanceBetween);
        }

        public void update() {
            pos.x -= speed;
            EmptySpace.x = pos.x;
            if (pos.x < -50) {
                pos.x = 800;
                deviation = new Random().nextInt(250);
                EmptySpace = new Rectangle(pos.x, pos.y - deviation + 300, 50, distanceBetween);
            }
        }
    }

    static WallPair[] walls;
    Texture tx;
    int distanceBetween;

    public Wall (){
        tx = new Texture("wall.png");
        walls = new WallPair[4];
        distanceBetween = 250;        
        int startPosX = 400;
        for (int i = 0; i < 4; i++) {
            walls[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < 4; i++) {
            batch.draw(tx, walls[i].pos.x, walls[i].pos.y - walls[i].deviation);
            batch.draw(tx, walls[i].pos.x, walls[i].pos.y + distanceBetween + tx.getHeight() - walls[i].deviation);
        }
    }

    public void update() {
        for (int i = 0; i < 4; i++) {
            walls[i].update();
        }
    }

    public void restart() {
        walls = new WallPair[4];
        distanceBetween = 250;        
        int startPosX = 400;
        for (int i = 0; i < 4; i++) {
            walls[i] = new WallPair(new Vector2(startPosX, 0));
            startPosX += 220;
        }
    }
}
 