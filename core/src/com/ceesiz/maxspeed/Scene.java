package com.ceesiz.maxspeed;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Scene implements Curd{

    private List<Curd> balls;

    public BallVel ballVel;
    public BallAcc ballAcc;

    @Override
    public void create() {
        balls = new ArrayList<>();

        ballVel = new BallVel();
        ballAcc = new BallAcc();

        balls.add(ballAcc);

        for (Curd ball :
                balls) {
            ball.create();
        }
    }

    @Override
    public void update(float dt) {
        for (Curd ball :
                balls) {
            ball.update(dt);
        }
    }

    @Override
    public void lateUpdate(float dt) {
        for (Curd ball :
                balls) {
            ball.lateUpdate(dt);
        }
    }

    @Override
    public void render(SpriteBatch batch) {
        for (Curd ball :
                balls) {
            ball.render(batch);
        }
    }

}
