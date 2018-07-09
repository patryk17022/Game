package pl.game.gameStates;


import pl.game.utility.KeyListener;
import javax.swing.JFrame;

public class GameStateManager {

    public static double deltaTime;

    public static void main(String[] a) {
        try {
            JFrame window = new JFrame("Game");
            window.addKeyListener(new KeyListener());
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setSize(1280, 720);
            //  window.getContentPane().setBackground(Color.black);

            window.setVisible(true);

            StateGame st = new StateGame();

            long last_time = System.nanoTime();
            boolean isGameOn = true;

            while (isGameOn) {

                long time = System.nanoTime();
                deltaTime = (time - last_time) / 1000000000.0;
                last_time = time;

                window.createBufferStrategy(2);

                st.Update(window);

                window.getBufferStrategy().show();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
