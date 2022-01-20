import processing.core.PApplet;

public class MoveBalls extends PApplet {

    public final int SCREEN_WIDTH;  // screen width
    public final int SCREEN_HEIGHT; //screen height
    public final int DIAMETER;  //diameter of the ball
    public final int TOTAL_BALLS;   //total no. of balls
    public static Ball[] balls; //declare ball object
    public static int speed;    //speed of the ball

    // constructor
    public MoveBalls() {
        SCREEN_WIDTH = 1400;
        SCREEN_HEIGHT = 800;
        DIAMETER = 15;
        TOTAL_BALLS = 4;
        speed = 0;
    }

    // override setting method to set the window size
    public void settings() {
        super.settings();
        size(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

    // override the setup method to initialize the balls instance
    public void setup () {
        background(220);
        int i;
        for (i = 0; i < this.TOTAL_BALLS; i++)
        {
            balls[i] = new Ball(0, getY(i), this.DIAMETER); // initialization
        }
    }

    // calculates the y coordinates of the ball
    private int getY(int i) {
        return this.SCREEN_HEIGHT * (i + 1) / 5;
    }

    // override the draw method to call the drawBalls method
    public void draw() {
        int i;
        for ( i = 0; i < this.TOTAL_BALLS; i++) {
            drawBalls(balls[i]);    // calling drawBalls method for each ball
            balls[i].x += i+2;
            if ( balls[0].x == 1400)
                resetXValue();  // calling the resetXValue method to reset the x coordinates
        }

    }

    // reset the x coordinate of each ball to 0
    private void resetXValue() {
        background(220);
        balls[0].x = 0;
        balls[1].x = 0;
        balls[2].x = 0;
        balls[3].x = 0;
    }

    // this method draws the circle
    public void drawBalls(Ball ball) {
        ellipse(ball.x, ball.y, ball.DIAMETER, ball.DIAMETER);
    }

    // Main method
    public static void main(String[] args) {
        PApplet.main("MoveBalls");

        balls = new Ball[4];
    }


}
