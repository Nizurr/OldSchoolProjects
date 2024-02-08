package g54435.atl.asciipaint.model;

import g54435.atl.asciipaint.model.*;

/**
 * AsciiPaint is responsible of actions effectued on Drawing
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * Default constructor of AsciiPaint
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Initialize a new Asciipaint with the size in param
     * @param w width of the draw
     * @param h height of the draw
     */
    public AsciiPaint(int w, int h) {
        this.drawing = new Drawing(w, h);
    }

    /**
     * Add a new circle
     * @param x posX
     * @param y posY
     * @param radius of the circle
     * @param color of the circle (in char)
     */
    public void newCircle(int x, int y, double radius, char color) {
        if (x < 0 || y < 0 || radius <= 0) throw new IllegalArgumentException("valeurs invalides");
        this.drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Add a new rectangle
     * @param x posX
     * @param y posY
     * @param width of the rectangle
     * @param height of the rectangle
     * @param color of the rectangle (in char)
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        if (x < 0 || y < 0 || width <= 0 || height <= 0) throw new IllegalArgumentException("valeurs invalides");
        this.drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    /**
     * Add a new Square
     * @param x posX
     * @param y posY
     * @param side of the square
     * @param color of the square (in char)
     */
    public void newSquare(int x, int y, double side, char color) {
        if (x < 0 || y < 0 || side <= 0) throw new IllegalArgumentException("valeurs invalides");
        this.drawing.addShape(new Square(new Point(x, y), side, side, color));
    }


    /**
     * toString equivalence of this Classe
     * @return a string
     */
    public String asAscii() {
        String toRet = "";
        for (int x = 0; x < drawing.getHeight(); x++) {
            for (int y = 0; y < drawing.getWidth(); y++) {
                Point p = new Point(x, y);
                Shape sh = drawing.getShapeAt(p);
                if (sh == null) {
                    toRet += " ";
                }
                if (sh != null) {
                    toRet += sh.getColor();
                }
                if (y == drawing.getWidth() - 1) {
                    toRet += "\n";
                }
            }
        }
        return toRet;
    }
}





