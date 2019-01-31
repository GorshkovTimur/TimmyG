package com.starfight.game.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.starfight.game.math.Rect;
import com.starfight.game.math.Rnd;
import com.starfight.game.pool.EnemyPool;
import com.starfight.game.sprite.game.Enemy;

import java.util.Random;


public class EnemyEmitter {
    private Random rnd;
    private static final float ENEMY_SMALL_HEIGHT = 0.1f;
    private static final float ENEMY_SMALL_BULLET_HEIGHT = 0.01f;
    private static final float ENEMY_SMALL_BULLET_VY = -0.3f;
    private static final int ENEMY_SMALL_DAMAGE = 1;
    private static final float ENEMY_SMALL_RELOAD_INTERVAL = 3f;
    private static final int ENEMY_SMALL_HP = 1;

    private Vector2 enemySmallV = new Vector2(0, -0.2f);
    private TextureRegion[] enemySmallRegion;

    private TextureRegion bulletRegion;

    private float generateInterval = 2f;
    private float generateTimer;
    private String[] enemyArr = {"enemy0","enemy1","enemy2"};
    private TextureRegion[] textureRegion;
    private EnemyPool enemyPool;

    private Rect worldBounds;

    public EnemyEmitter(TextureAtlas atlas, EnemyPool enemyPool, Rect worldBounds) {
        this.enemyPool = enemyPool;
        textureRegion =new TextureRegion[]{ atlas.findRegion("enemy0"),atlas.findRegion("enemy1"),atlas.findRegion("enemy2")} ;
        this.bulletRegion = atlas.findRegion("bulletEnemy");
        this.worldBounds = worldBounds;
    }

    public void generate(float delta) {
        rnd = new Random();
        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            enemy.set(
                    enemySmallRegion = Regions.split(textureRegion[rnd.nextInt(2)], 1,2,2),
                    enemySmallV,
                    bulletRegion,
                    ENEMY_SMALL_BULLET_HEIGHT,
                    ENEMY_SMALL_BULLET_VY,
                    ENEMY_SMALL_DAMAGE,
                    ENEMY_SMALL_RELOAD_INTERVAL,
                    ENEMY_SMALL_HEIGHT,
                    ENEMY_SMALL_HP,
                    worldBounds
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }
}
