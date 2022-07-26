package com.ceesiz.maxspeed;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BallAcc implements Curd {

    public Sprite sprite;

    public Vector2 position;
    public Vector2 acceleration;
    public Vector2 velocity;

    public float time = 0f;
    public int tick = 0;

    public float traveledDistance = 0f;

    public void create() {
        sprite = new Sprite(new Texture(Gdx.files.internal("ball.png")));
        sprite.setSize(36, 36);
        sprite.setOriginCenter();

        this.position = new Vector2(50, Gdx.graphics.getHeight() * 0.75f);
        this.acceleration = new Vector2();
        this.velocity = new Vector2();
    }

    public void update(float dt) {
        this.acceleration.set(dt * 2, 0f);
    }

    public void lateUpdate(float dt) {
        if (position.x > 400)
            return;

        this.velocity.add(acceleration);
        this.traveledDistance += this.velocity.len();

        this.position.add(velocity);


        System.out.println("\t elapsed time: " + time +
                "\t\t ticks: " + tick +
                "\t\t traveled distance: " + traveledDistance + " m");


        time += dt;
        tick += 1;
    }

    public void render(SpriteBatch batch) {
        this.sprite.setPosition(this.position.x, this.position.y);
        batch.draw(
                sprite, sprite.getX(), sprite.getY(),
                sprite.getOriginX(), sprite.getOriginY(),
                sprite.getWidth(), sprite.getHeight(),
                sprite.getScaleX(), sprite.getScaleY(),
                sprite.getRotation()
        );
    }


}