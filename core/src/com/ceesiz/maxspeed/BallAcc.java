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

    public float maxSpeed = 20f; // m/s
    public float minSpeed = 11f; // m/s
    public float traveledDistance = 0f; // m

    public void create() {
        sprite = new Sprite(new Texture(Gdx.files.internal("ball.png")));
        sprite.setSize(36, 36);
        sprite.setOriginCenter();

        this.position = new Vector2(50, Gdx.graphics.getHeight() * 0.75f);
        this.acceleration = new Vector2();
        this.velocity = new Vector2();


    }

    public void update(float dt) {
        if (tick == 0) {
            this.velocity.set(minSpeed - 5f, 0f);
        }
        this.acceleration.set(2.5f, 0f); // m/s²
    }

    public void lateUpdate(float dt) {
        if (position.x > 400)
            return;

        this.velocity.mulAdd(acceleration, dt); // m/s

        this.lowerLimit(velocity, minSpeed);
        this.velocity.limit(maxSpeed);
        this.traveledDistance += this.velocity.len() * dt; // m
        this.position.mulAdd(velocity, dt); // m


        System.out.print("\t elapsed time: " + time);
        System.out.print("\t\t ticks: " + tick);
        System.out.print("\t\t traveled distance: " + traveledDistance + " m");
        System.out.println("\t\t speed: " + (velocity.len()));

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

    private void lowerLimit(Vector2 vector, float limit){
        float limit2 = limit * limit;
        float len2 = vector.len2();
        if (len2 < limit2){
            vector.scl((float) Math.sqrt(limit2 / len2));
        }
    }

}