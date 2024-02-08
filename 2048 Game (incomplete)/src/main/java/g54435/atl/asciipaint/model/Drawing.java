package g54435.atl.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Drawing = "Feuille de papier"
 */
public class Drawing {
    private List<Shape> shapes;
    private int width;
    private int height;


    /**
     * Default Constructor
     */
    public Drawing() {
        this.shapes = new ArrayList<Shape>();
        this.height = 700;
        this.width = 700;
    }

    /**
     * Constructor
     * @param width of the drawing
     * @param height of the drawing
     */
    public Drawing(int width, int height) {
        this.shapes = new ArrayList<Shape>();
        this.height = height;
        this.width = width;
    }

    /**
     * Add the shape on this drawing
     * @param shape
     */
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    /**
     * get if a shape is at a point on drawing
     * @param p Point to check
     * @return the shape on the point
     */
    public Shape getShapeAt(Point p) {
        for (Shape sh : this.shapes) {
            if (sh.isInside(p)) {
                return sh;
            }
        }
        return null;
    }

    /**
     * @return int of the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return int of the height
     */
    public int getHeight() {
        return height;
    }
}
