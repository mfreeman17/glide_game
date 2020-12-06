package com.matt.Glide_Game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matt.Glide_Game.AssetConstants;
import com.matt.Glide_Game.Constants;

public class MenuState extends State{
    private Texture background;
    private Texture playButton;
    public MenuState (GameStateManager gsm){
        super(gsm);
        background = new Texture(com.matt.Glide_Game.AssetConstants.BACKGROUND);
        playButton = new Texture(AssetConstants.PLAY);
    }
    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();

    }


    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, com.matt.Glide_Game.Constants.WIDTH, com.matt.Glide_Game.Constants.HEIGHT);
        int pbWidth = playButton.getWidth();
        int pbHeight = playButton.getHeight();
        sb.draw(playButton, com.matt.Glide_Game.Constants.WIDTH/2-pbWidth/2, Constants.HEIGHT/2-pbWidth/2-100);
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}
