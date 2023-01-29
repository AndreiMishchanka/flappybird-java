package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class FlappyBirdGame extends ApplicationAdapter {
	private BitmapFont FontRed; 
	SpriteBatch batch;
	Bird bird;
	Sky bg;	
	Wall wall;
	boolean isGameOver;
	Texture restartTx;
	boolean isGamePaused;
	Texture continueTx;
	int count;
	
	@Override
	public void create () {
		batch = new SpriteBatch();		
		bg = new Sky();
		bird = new Bird();
		wall = new Wall();
		isGameOver = false;
		isGamePaused = false;
		count = 0;
		restartTx = new Texture("restart.png");
		continueTx = new Texture("continue.png");
		FontRed = new BitmapFont();
        FontRed.setColor(Color.RED);		
	}

	@Override
	public void render () {
		update();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		bg.render(batch);		
		wall.render(batch);			
		if (!isGameOver) {
			bird.render(batch);
			if (isGamePaused) {				
				batch.draw(continueTx, 200, 200);
			}
		}else if (isGameOver){
			batch.draw(restartTx, 200, 200);			
		}
		FontRed.draw(batch, String.format("SCORE: %s", Integer.toString(count)), 700, 580);	
		batch.end();
	}

	public void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) && !isGameOver && !isGamePaused) {
			isGamePaused = true;
			return;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && isGamePaused) {
			isGamePaused = false;
			return;			
		}

		if (isGamePaused) {
			return;
		}
		
		bg.update();
		bird.update();
		wall.update();

		for (int i = 0; i < Wall.walls.length; i++) {
			if (Wall.walls[i].pos.x < bird.pos.x && bird.pos.x < Wall.walls[i].pos.x + 50) {
				if (Wall.walls[i].pos.x + 47 < bird.pos.x && !isGameOver) {
					count++;
				}
				if (!Wall.walls[i].EmptySpace.contains(bird.pos.x, bird.pos.y + 15)) {
					isGameOver = true;
				}
			}
		}
		if (bird.pos.y < 0 || bird.pos.y > 600) {
			isGameOver = true;
		}		

		if (Gdx.input.isKeyPressed(Input.Keys.ENTER) && isGameOver) {
			isGameOver = false;
			bird.restart();
			wall.restart();
			count = 0;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
