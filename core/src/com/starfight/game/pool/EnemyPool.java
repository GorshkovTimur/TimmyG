package com.starfight.game.pool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.starfight.game.base.SpritesPool;
import com.starfight.game.sprite.game.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    private Sound shootSound;
    private BulletPool bulletPool;

    public EnemyPool(BulletPool bulletPool) {
        this.shootSound = Gdx.audio.newSound(Gdx.files.internal("sounds/bullet.wav"));
        this.bulletPool = bulletPool;
    }

    @Override
    protected Enemy newObject() {
        return new Enemy(shootSound, bulletPool);
    }

    @Override
    public void dispose() {
        super.dispose();
        shootSound.dispose();
    }
}
