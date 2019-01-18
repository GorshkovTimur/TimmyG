package ru.geekbrains.base.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {

    SpriteBatch batch;
    Texture img;
    final private float velocity = 1f;

    Vector2 pos = new Vector2(0,0);
    Vector2 directtion;
    Vector2 nprDirection;


    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("Logo.bmp");
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        directtion = new Vector2(Gdx.graphics.getWidth()-screenX, Gdx.graphics.getHeight()-screenY);
        nprDirection = new Vector2(screenX,screenY);
        nprDirection.nor();
        return super.touchDown(screenX, screenY, pointer, button);

    }


    @Override
    public void render(float delta) {

        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x,pos.y);
        batch.end();
        if (directtion!=null){
            if (pos.x<(directtion.x) && pos.y<(directtion.y)){
                System.out.println(pos.x+" "+pos.y+" "+directtion.x+" "+directtion.y);
        pos.add(nprDirection.scl(velocity));}
    }}

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }


}
