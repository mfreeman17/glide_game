package com.matt.Glide_Game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matt.Glide_Game.AssetConstants;
import com.matt.Glide_Game.Constants;
import com.matt.Glide_Game.sprites.Bird;
import com.matt.Glide_Game.sprites.Orb;

public class PlayState extends State {
    private Bird bird;
    private Orb orb;
    private Texture obstacle;
    private Texture background;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird= new Bird(20,50);
        orb = new Orb(90,60, false);
        background = new Texture(AssetConstants.BACKGROUND);
        cam.setToOrtho(false, Constants.WIDTH/2, Constants.HEIGHT/2);
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            bird.jump();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        orb.update(dt);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x- (cam.viewportWidth/2), 0, cam.viewportWidth, cam.viewportHeight);
        sb.draw(bird.getTexture(), bird.getPos().x,bird.getPos().y);
        sb.draw(orb.getTexture(),orb.getPos().x,orb.getPos().y);
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
