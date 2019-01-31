package com.starfight.game;

import com.badlogic.gdx.Game;
import com.starfight.game.screen.MenuScreen;

public class Star2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
