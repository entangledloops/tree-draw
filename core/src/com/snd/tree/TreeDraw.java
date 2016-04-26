package com.snd.tree;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TreeDraw extends ApplicationAdapter
{
  private String version = "(unknown)";

  private Camera   camera;
  //private Viewport viewport;

  private SpriteBatch spriteBatch;
  private BitmapFont  bitmapFont;
  private ShapeRenderer shapeRenderer;
	
	@Override
	public void create()
	{
    camera = new OrthographicCamera(3840f, 2160f * (Gdx.graphics.getWidth() / Gdx.graphics.getHeight()));
    camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
    //viewport = new FillViewport(camera.viewportWidth, camera.viewportHeight, camera);

    spriteBatch = new SpriteBatch();
    bitmapFont = new BitmapFont();
    shapeRenderer = new ShapeRenderer();

    bitmapFont.setColor(Color.WHITE);

    try
    {
      List<String> lines = Files.readAllLines(Paths.get("../../build-info.properties"), Charset.forName("UTF-8"));
      final String major = ""+Integer.parseInt(lines.get(1).split("=")[1]);
      final String revision = ""+Integer.parseInt(lines.get(2).split("=")[1]);
      final String minor = ""+Integer.parseInt(lines.get(3).split("=")[1]);
      version = major + "." + minor + "." + revision;
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

    Gdx.graphics.setTitle("TreeDraw v" + version);
    Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
	}

	@Override
	public void render()
  {
    Gdx.graphics.setTitle("TreeDraw v" + version + " - " + Gdx.graphics.getFramesPerSecond() + " fps");
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    camera.update();

    //spriteBatch.setProjectionMatrix(camera.combined);
    spriteBatch.begin();
    bitmapFont.draw(spriteBatch, "101010110", 50, 150);
    spriteBatch.end();

    shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.setColor(1.0f, 0, 0, 1.0f);
    shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
    shapeRenderer.line(0, 0, 0, 1900, 1000, 0);
    shapeRenderer.end();
	}

  @Override
  public void resize(int width, int height)
  {
    super.resize(width, height);
    //viewport.update(width, height);
  }
}
