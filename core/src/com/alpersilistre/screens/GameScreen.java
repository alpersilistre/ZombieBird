package com.alpersilistre.screens;

import com.alpersilistre.gameworld.GameRenderer;
import com.alpersilistre.gameworld.GameWorld;
import com.alpersilistre.zbhelpers.InputHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen
{
    String LOG_TAG = getClass().getSimpleName();

    private GameWorld world;
    private GameRenderer renderer;

    private float runTime = 0;

    public GameScreen()
    {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = (gameWidth * screenHeight) / screenWidth;

        int midPointY = (int) (gameHeight / 2);

        Gdx.app.log(LOG_TAG, "Attached");
        world = new GameWorld(midPointY);
        renderer = new GameRenderer(world, (int)gameHeight, midPointY);

        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
    }

    @Override
    public void show()
    {
        Gdx.app.log(LOG_TAG, "Show called");
    }

    @Override
    public void render(float delta)
    {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height)
    {
        Gdx.app.log(LOG_TAG, "Resize called");
    }

    @Override
    public void pause()
    {
        Gdx.app.log(LOG_TAG, "Pause called");
    }

    @Override
    public void resume()
    {
        Gdx.app.log(LOG_TAG, "Resume called");
    }

    @Override
    public void hide()
    {
        Gdx.app.log(LOG_TAG, "Hide called");
    }

    @Override
    public void dispose()
    {

    }
}
