package GraphicsEngine;

import GraphicsCreator.AnimationCreator;
import GraphicsCreator.SpriteCreator;
import GraphicsCreator.TextureCreator;
import GraphicsCreator.UICreator;
import InputEngine.InputEngine;
import InputEngine.KeyboardHandler;
import Main.MainApplet;
import Misc.GlobalProperties;
import Objects.Chunk;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Properties;

/**
 * Created by tristan on 3/14/2017.
 */
public class Render
{
    public TextureCreator textureCreator;
    public SpriteCreator spriteCreator;
    public UICreator uiCreator;
    public AnimationCreator animationCreator;

    public MapRender mapRender;
    public ShaderRender shaderRender;
    public CharacterRender characterRender;
    public UIRender uiRender;

    private BufferedImage frame = new BufferedImage(Integer.parseInt(GlobalProperties.global.getProperty("width")), Integer.parseInt(GlobalProperties.global.getProperty("height")), BufferedImage.TYPE_3BYTE_BGR);

    public Render()
    {
        // Initialize creators
        // TODO: Threaded texture creator
        textureCreator = new TextureCreator();
        Thread graphics = new Thread(textureCreator);
        graphics.setPriority(Thread.MAX_PRIORITY);
        graphics.start();
        spriteCreator = new SpriteCreator();
        uiCreator = new UICreator();
        animationCreator = new AnimationCreator();

        // Initialize renders
        mapRender = new MapRender();
        characterRender = new CharacterRender();
        uiRender = new UIRender();
        shaderRender = new ShaderRender();
    }

    public Image newFrame()
    {
        frame = mapRender.draw(frame);
        frame = characterRender.draw(frame);
        frame = shaderRender.draw(frame);

        return frame;
    }
}
