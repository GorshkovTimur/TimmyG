package ru.geekbrains.sprite.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;

public class ExitButton extends ScaledTouchUpButton {

    public ExitButton(TextureRegion region) {
        super(region);
        setHeightProportion(0.2f);
        setBottom(-0.3f);
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        setScale(0.5f);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        return super.touchUp(touch, pointer);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
