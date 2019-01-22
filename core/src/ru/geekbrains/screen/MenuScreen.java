package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    private static final float V_LEN = 0.005f;
    Texture img;
    Texture background;

    Vector2 pos;
    Vector2 v;
    Vector2 buf;

    @Override
    public void show() {
        super.show();
        background = new Texture("1.png");
        img = new Texture("logo.bmp");
        pos = new Vector2(-0.5f, -0.5f);
        v = new Vector2(0.002f, 0.002f);
        buf = new Vector2(0,0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.5f, 0.2f, 0.3f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, -0.5f, -0.5f, 1f, 1f);
        batch.draw(img, pos.x, pos.y, 0.5f, 0.5f);
        batch.end();
        buf.set(super.getTouch());
        if(buf.sub(pos).len()>V_LEN) {
            pos.add(v);
        } else {
            pos.set(super.getTouch());
        }

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        v.set(touch.cpy().sub(pos).setLength(V_LEN));
        return super.touchDown(touch, pointer);
    }
}
