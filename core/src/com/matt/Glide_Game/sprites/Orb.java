package com.matt.Glide_Game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.matt.Glide_Game.AssetConstants;
import com.matt.Glide_Game.Constants;

public class Orb {
    private Vector3 pos;
    private Texture orb;
    private Vector3 vel;
    private Animation ani;
    boolean up;

    public Orb(int x, int y, boolean up) {
        pos = new Vector3(x, y, 0);
        vel = new Vector3(0, 0, 0);
        orb = new Texture(AssetConstants.ORB);
        ani = new Animation( new TextureRegion(orb), 5, 0.6f);
        this.up=up;

    }

    public TextureRegion getTexture() {
        TextureRegion frame = ani.getFrame();
        return frame;
    }


    public Vector3 getPos() {
        return pos;
    }
    private void velocity1(){

        if (pos.y<0){
            pos.y=0;
            vel.y=0;
            up=true;
        }
        if (pos.y> com.matt.Glide_Game.Constants.HEIGHT/2-75){
            pos.y= Constants.HEIGHT/2-75;
            vel.y=0;
            up=false;
        }
        vel.x=-20;
        if(up)
            vel.y+=3;
        else{
            vel.y-=3;
        }
    }
    public void update(float dt){
        ani.update(dt);
        velocity1();
        vel.scl(dt);
        pos.add(vel.x,vel.y,0);
        vel.scl(1/dt);

    }
}

