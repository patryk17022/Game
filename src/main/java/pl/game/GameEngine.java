package pl.game;

import pl.game.gameStates.GameStateManager;
import pl.game.utility.KeyListener;

import javax.swing.*;
import java.awt.*;

public class GameEngine {


    public static double deltaTime;
    private static GameStateManager manager;
    private static JFrame window;

    private static int width = 1280;
    private static int height = 720;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private static void Initialize() throws Exception{
        window = new JFrame("Game");
        KeyListener key = new KeyListener();
        window.addKeyListener(key);
        window.addMouseListener(key);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0,0,width, height);
        window.getContentPane().setBackground(Color.black);
        window.setVisible(true);
        manager = new GameStateManager();
    }

    private static void run() throws Exception{

        long last_time = System.nanoTime();
        boolean isGameOn = true;

        while (isGameOn) {

            long time = System.nanoTime();
            deltaTime = (time - last_time) / 1000000000.0;
            last_time = time;

            window.createBufferStrategy(2);

            isGameOn = manager.Update(window);

            window.getBufferStrategy().show();

        }
    }

    public static void main(String[] a) {
        try {

            Initialize();
            run();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
