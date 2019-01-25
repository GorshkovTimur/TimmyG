package ru.geekbrains.sprite.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayButton extends ScaledTouchUpButton {


    @Override
    public void draw(SpriteBatch batch) {
        System.out.println(pos.x+" "+pos.y);
        super.draw(batch);
    }

    public PlayButton(TextureRegion region) {
        super(region);
        setHeightProportion(0.2f);
        setBottom(0f);

    }

    @Override
    public void action() {
        System.out.println("kuraga");
    }
}
