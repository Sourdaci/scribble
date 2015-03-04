import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);  
        myCanvas.erase();
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Dibuja un triangulo en pantalla
     * 
     * @param posX Posicion horizontal del pincel
     * @param posY Posicion vertical del pincel
     */
    public void drawTriangle(int posX, int posY){
        Pen pen = new Pen(posX, posY, myCanvas);
        pen.setColor(Color.GREEN);

        triangle(pen);
    }
    
    /**
     * Dibuja un pentagono en pantalla
     * 
     * @param posX Posicion horizontal del pincel
     * @param posY Posicion vertical del pincel
     */
    public void drawPentagon(int posX, int posY){
        Pen pen = new Pen(posX, posY, myCanvas);
        pen.setColor(Color.GREEN);

        pentagon(pen);
    }
    
    /**
     * Dibuja un pentagono en pantalla
     * 
     * @param posX Posicion horizontal del pincel
     * @param posY Posicion vertical del pincel
     * @param lados Numero de lados del poligono
     */
    public void drawPolygon(int posX, int posY, int lados){
        Pen pen = new Pen(posX, posY, myCanvas);
        pen.setColor(Color.ORANGE);

        polygon(pen, lados);
    }
    
    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }
    
    /**
     * Dibuja un triangulo en pantalla en la posicion del Pen
     */
    private void triangle(Pen pen){
        for (int i=0; i<3; i++) {
            pen.move(100);
            pen.turn(120);
        }
    }
    
    /**
     * Dibuja un pentagono en pantalla en la posicion del Pen
     */
    private void pentagon(Pen pen){
        for (int i=0; i<5; i++) {
            pen.move(100);
            pen.turn(72);
        }
    }

    /**
     * Dibuja un poligono en pantalla en la posicion del Pen
     */
    private void polygon(Pen pen, int lados){
        for (int i=0; i<lados; i++) {
            pen.move(100);
            pen.turn(360/lados);
        }
    }
    
    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
