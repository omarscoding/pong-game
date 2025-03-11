package pong;

import java.awt.*;

public class Ball {
    private int x, y, cx, cy, speed, size;
    private Color color ;

    static final int MAX_SPEED = 6;

    public Ball(int x, int y, int cx, int cy, int speed, int size, Color color){

        this.x = x;
        this.y = y;
        this.cx = cx;
        this.cy = cy; 
        this.speed = speed;
        this.size= size;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);

    }

    public void moveBall(){

        x += cx;
        y += cy;

    }

    public void bounceOffEdges(int top, int bottom){

        if (y > bottom - size) {
            reverseY();
        }
        if (y < top) {
            reverseY();
        }

        
    }
    
    public void reverseY() {

        cy *= -1 ;

    }

    public void reverseX() {

        cx *= -1;

    }

    public int getY(){
        return y;
        
    }

    public int getX(){
        return x;
    }
    
    public int getSize (){
        return size; 
    }

    public void increaseSpeed(){
        if (speed < MAX_SPEED){
            speed ++;

            cx = (cx / Math.abs(cx) * speed) ;

            if (cy < 0) {
                cy = -1 * speed;
            }
            else {
                cy = speed;
            }
        }

    }

}
