package com.matt.Glide_Game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.matt.Glide_Game.Constants;
import com.matt.Glide_Game.AssetConstants;

public class Bird {
    public static final int GRAVITY = -6;
    public static final int JUMP = 150;
    private Vector3 pos;
    private Texture texture;
    private Vector3 vel;
    private Rectangle bounds;


    public Bird (int x, int y){
        pos = new Vector3(x,y,0);
        vel = new Vector3 (0,0,0);
        texture = new Texture(AssetConstants.Glider);
        bounds = new Rectangle(x,y, texture.getWidth(), texture.getHeight());
    }
    public Texture getTexture() {
        return texture;
    }


    public Vector3 getPos() {
        return pos;
    }
    public void jump(){
        vel.add(0,JUMP,0);
    }

    public void update(float dt){
        vel.add(0,GRAVITY,0);
        vel.scl(dt);
        pos.add(0, vel.y, 0);
        if (pos.y<0){
            pos.y=0;

        }
        if (pos.y> com.matt.Glide_Game.Constants.HEIGHT/2-75){
            pos.y= Constants.HEIGHT/2-75;
            vel.y=0;
        }
        vel.scl(1/dt);
        bounds.setPosition(pos.x, pos.y);

    }
    public Rectangle getBounds(){
        return  bounds;
    }
}
