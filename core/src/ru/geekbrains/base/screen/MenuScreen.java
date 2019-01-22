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
    Vector2 tmp ;


    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("Logo.bmp");
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        directtion = new Vector2(screenX, Gdx.graphics.getHeight()-screenY);
        nprDirection = new Vector2(screenX, Gdx.graphics.getHeight()-screenY);
        tmp = new Vector2(screenX, Gdx.graphics.getHeight()-screenY);
        tmp.nor();
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
            if (pos.x<=directtion.x){
                pos.add(tmp.x*velocity,0);
            }
            if(pos.x>directtion.x){
                pos.sub(tmp.x*velocity,0);
            }
            if (pos.y<=directtion.y){
                pos.add(0,tmp.x*velocity);
            }
            if(pos.y>directtion.y){
                pos.sub(0,tmp.x*velocity);
            }
//            if (pos.x<=directtion.x && pos.y<=directtion.y){
//        pos.add(tmp.scl(velocity));}
//            if (pos.x>directtion.x && pos.y>directtion.y){
//                pos.sub(tmp.scl(velocity));
//            }
    }}

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
        img.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println(keycode);
        switch (keycode){
            case (19):
                pos.y++;
                break;
            case (20):
                pos.y--;
                break;
            case (21):
                pos.x--;
                break;
            case (22):
                pos.x++;
                break;
        }

        return super.keyDown(keycode);
    }


}
