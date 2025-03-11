package pong;

import java.awt.*;

public class Paddle {

    private int height, x, y, speed;
    private Color color;
    
    static final int PADDLE_WIDTH = 15 ;

    public Paddle(int x, int y, int height, int speed, Color color) {
        
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;

    }

    public void paint(Graphics g) {

        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);


    }

    public void moveTowards(int moveToY){

        int centerY = y + height / 2 ;

        if (Math.abs(centerY - moveToY) > speed) {

            if (centerY > moveToY){
                y -= speed;

            }

            if (centerY < moveToY) {
                y += speed;

            }
        }
    }

    //checks if paddle is colliding with the ball
    // if colliding return true vice versa 
    public boolean checkCollision(Ball b) {

        int rightX = x + PADDLE_WIDTH;

        int bottomY = y  + height;

        //check collison

        if (b.getX() > (x - b.getSize()) && b.getX() < rightX) {
            // so now we know its within the horizontal range
            if (b.getY() > y && b.getY() < bottomY){
                //we know its between top and bottom of paddle
                return true;
            }
        }

        return false;

    }
}
