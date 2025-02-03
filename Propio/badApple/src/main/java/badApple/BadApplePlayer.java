package badApple;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.PixmapIO;

public class BadApplePlayer extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture blackTexture;
    private Texture whiteTexture;
    private Music music;
    private boolean isWhite = false;
    private int frameCount = 0;

    // FrameBuffer para capturar la salida
    private FrameBuffer frameBuffer;

    @Override
    public void create() {
        batch = new SpriteBatch();

        // Cargar las texturas (imágenes blanca y negra)
        blackTexture = new Texture(Gdx.files.internal("assets/black.png"));
        whiteTexture = new Texture(Gdx.files.internal("assets/white.png"));

        // Crear un FrameBuffer de tamaño de la pantalla
        frameBuffer = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);

        // Cargar la música
        music = Gdx.audio.newMusic(Gdx.files.internal("assets/badapple.mp3"));
        music.setLooping(false);
        music.play();
    }

    @Override
    public void render() {
        // Alternar entre las imágenes blanca y negra cada 0.1 segundos
        if (music.getPosition() % 0.1f < 0.05f) {
            isWhite = !isWhite;
        }

        // Captura la imagen en el FrameBuffer
        captureFrame();

        // Dibujar la textura actual en la pantalla
        batch.begin();
        if (isWhite) {
            batch.draw(whiteTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        } else {
            batch.draw(blackTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        blackTexture.dispose();
        whiteTexture.dispose();
        music.dispose();
        frameBuffer.dispose();
    }

    private void captureFrame() {
        // Capturar la imagen del FrameBuffer
        frameBuffer.begin();

        // Dibujar la textura actual en el FrameBuffer
        batch.begin();
        if (isWhite) {
            batch.draw(whiteTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        } else {
            batch.draw(blackTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
        batch.end();

        // Termina la captura en el FrameBuffer
        frameBuffer.end();

        // Obtener el Pixmap del FrameBuffer
        Pixmap pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        Texture texture = frameBuffer.getColorBufferTexture();

        // Preparar la TextureData solo una vez
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }

        // Consumir el Pixmap
        pixmap.drawPixmap(texture.getTextureData().consumePixmap(), 0, 0);

        // Guardar el Pixmap como un archivo PNG
        saveFrame(pixmap);
    }

    private void saveFrame(Pixmap pixmap) {
        // Guardar la imagen como un archivo PNG
        FileHandle fileHandle = Gdx.files.local("frame_" + String.format("%04d", frameCount++) + ".png");
        PixmapIO.writePNG(fileHandle, pixmap);  // Usamos PixmapIO para guardar la imagen
        pixmap.dispose();  // Liberar el Pixmap después de guardarlo
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Bad Apple Player");
        config.setWindowedMode(800, 600);
        new Lwjgl3Application(new BadApplePlayer(), config);
    }
}