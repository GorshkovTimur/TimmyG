package com.starfight.game.pool;


import com.starfight.game.base.SpritesPool;
import com.starfight.game.sprite.game.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
