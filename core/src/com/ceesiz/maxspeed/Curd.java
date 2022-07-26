package com.ceesiz.maxspeed;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Curd {

    void create();
    void update(float dt);
    void lateUpdate(float dt);
    void render(SpriteBatch batch);

}
