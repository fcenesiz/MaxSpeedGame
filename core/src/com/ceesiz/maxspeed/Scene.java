package com.ceesiz.maxspeed;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Scene implements Curd{

    private List<Curd> balls;

    @Override
    public void create() {
        balls = new ArrayList<>();


        balls.add(new BallAcc());
        //balls.add(new BallVel());

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
