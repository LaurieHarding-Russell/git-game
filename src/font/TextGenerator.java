package src.font;

import org.lwjgl.stb.STBTTFontinfo;
import org.lwjgl.system.MemoryStack;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static java.awt.Font.MONOSPACED;
import static java.awt.Font.PLAIN;
import static org.lwjgl.stb.STBTruetype.stbtt_GetFontVMetrics;
import static org.lwjgl.stb.STBTruetype.stbtt_InitFont;

public class TextGenerator {

    int fontHeight;

    void loadFont() {
        Font font = new Font(MONOSPACED, PLAIN, 16);

        int imageWidth = 0;
        int imageHeight = 0;

        for (int i = 32; i < 256; i++) {
            if (i == 127) {
                continue;
            }
            char character = (char) i;
            BufferedImage charImage = createCharImage(font, character);

            imageWidth += charImage.getWidth();
            imageHeight = Math.max(imageHeight, charImage.getHeight());
        }
        fontHeight = imageHeight;
    }

    private BufferedImage createCharImage(Font font, char character) {

        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphicsRender = image.createGraphics();

        graphicsRender.setFont(font);
        FontMetrics metrics = graphicsRender.getFontMetrics();
        graphicsRender.dispose();

        int charWidth = metrics.charWidth(character);
        int charHeight = metrics.getHeight();

        image = new BufferedImage(charWidth, charHeight, BufferedImage.TYPE_INT_ARGB);
        graphicsRender = image.createGraphics();

        graphicsRender.setFont(font);
        graphicsRender.setPaint(Color.WHITE);
        graphicsRender.drawString(String.valueOf(character), 0, metrics.getAscent());
        graphicsRender.dispose();
        return image;
    }
}
