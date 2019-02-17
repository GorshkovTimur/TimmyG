package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprite.game.Saw;

public class SawPool extends SpritesPool<Saw> {
    @Override
    protected Saw newObject() {
        return new Saw();
    }
}
