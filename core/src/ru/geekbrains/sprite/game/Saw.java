package ru.geekbrains.sprite.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Saw extends Sprite {
    private Rect worldBounds;
    private Vector2 v = new Vector2();
    private int damage = 900;
    private Object owner;

    public Saw() {
        regions = new TextureRegion[1];
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        checkAndHandleBounds();
        if (isOutside(worldBounds)) {
            destroy();
        }
        System.out.println(getRight()+" "+worldBounds.getLeft());
    }

    public void set(
            Object owner,
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int damage
    ) {
        this.owner = owner;
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public Object getOwner() {
        return owner;
    }

    private void checkAndHandleBounds() {
        if ((getRight()-0.05f) < worldBounds.getLeft()) v.scl(-1f,1f);
        if ((getLeft()+0.05f) > worldBounds.getRight()) v.scl(-1f,1f);

    }
}

