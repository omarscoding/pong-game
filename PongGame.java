package pong;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480; 

    private Ball gameBall;
    private Paddle userPaddle, pcPaddle ;
    private int userMouseY, userScore, pcScore, bounceCount ;



    public PongGame(){
        gameBall = new Ball(320, 220, 3, 3, 3, 10, Color.yellow);

        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE) ;

        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED) ;

        userMouseY = 0;

        bounceCount = 0;

        addMouseMotionListener(this) ;

    }

    public void paintComponent(Graphics g){

        // paint game
        g.setColor(Color.black);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        // paint ball
        gameBall.paint(g);
        // paint paddle
        userPaddle.paint(g);
        pcPaddle.paint(g);
        //score
        g.setColor(Color.WHITE);
        g.drawString("SCORE - User [" + userScore + "]  PC [" + pcScore + "]", 250, 20 );
        

    }

    public void gameLogic(){
        gameBall.moveBall();
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);

        // user paddle moves towards y position of mouse
        userPaddle.moveTowards(userMouseY);

        // pc paddle
        pcPaddle.moveTowards(gameBall.getY());

        //check for paddle collison
        if (userPaddle.checkCollision(gameBall)) {

            gameBall.reverseX();
            bounceCount ++;
        }
        // check pc paddle collison
        if (pcPaddle.checkCollision(gameBall)) {
            gameBall.reverseX();
            bounceCount ++;
        }

        if (bounceCount == 3){
            gameBall.increaseSpeed();
        }

        //game win / lose

        if (gameBall.getX() < 0 ){
             pcScore ++;
             reset();
        }
        else if (gameBall.getX() > WINDOW_WIDTH){
            userScore ++;
            reset();
        }
    


    }

    public void reset(){
        // creates new ball and resets everything else 
        gameBall = new Ball(320, 220, 3, 3, 3, 10, Color.yellow);
        userPaddle = new Paddle(10, 200, 75, 3, Color.BLUE) ;
        pcPaddle = new Paddle(610, 200, 75, 3, Color.RED) ;
        bounceCount = 0;

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY(); 
        

    }



}