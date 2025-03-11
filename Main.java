package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

class Main {

    static JFrame f = new JFrame("pong");
    public static void main(String[] args) {
        
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setSize(650,515);

        PongGame game = new PongGame();

        f.add(game);

        f.setVisible(true); //Shows the window


        Timer timer = new Timer(33, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
    
                game.repaint();
                game.gameLogic();
                

            }

        });

        timer.start();

 


    }
}
