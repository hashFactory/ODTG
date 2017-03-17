package GraphicsEngine;

import GraphicsCreator.AnimationCreator;
import GraphicsCreator.SpriteCreator;
import GraphicsCreator.TextureCreator;
import GraphicsCreator.UICreator;
import InputEngine.KeyboardHandler;
import Main.MainApplet;
import Objects.Chunk;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * Created by tristan on 3/14/2017.
 */
public class Render
{
    //TODO: Possibly find a better way to deal with this
    public int cameraX, cameraY;

    public TextureCreator textureCreator;
    public SpriteCreator spriteCreator;
    public UICreator uiCreator;
    public AnimationCreator animationCreator;

    public MapRender mapRender;
    public ShaderRender shaderRender;
    public CharacterRender characterRender;
    public UIRender uiRender;

    // TODO: Settings properties
    public Properties windowProperties = new Properties();

    public Render()
    {
        // Initialize creators
        // TODO: Threaded texture creator
        Thread graphics = new Thread(textureCreator);
        graphics.setPriority(Thread.MAX_PRIORITY);
        textureCreator = new TextureCreator();
        spriteCreator = new SpriteCreator();
        uiCreator = new UICreator();
        animationCreator = new AnimationCreator();

        // Initialize renders
        mapRender = new MapRender();
        characterRender = new CharacterRender();
        uiRender = new UIRender();
        shaderRender = new ShaderRender();

        // Load window properties
    }

    public Image newFrame()
    {
        KeyboardHandler.interpret();
        Chunk[] chunks = new Chunk[3];
        BufferedImage frame = new BufferedImage(1000, 700, BufferedImage.TYPE_3BYTE_BGR);
        frame.setRGB(100, 100, 73465);
        frame = mapRender.draw(frame);
        frame = characterRender.draw(frame);
        frame = shaderRender.draw(frame);
        //frame = mapRender.draw(frame);
        return frame;
    }
}
