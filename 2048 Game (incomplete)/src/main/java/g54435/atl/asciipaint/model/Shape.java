package g54435.atl.asciipaint.model;

/**
 * Interface of the Shape
 */
public interface Shape {

    /**
     * @param p Point to check if the shape is inSide
     * @return a boolean (true = isInsinde)
     */
    boolean isInside(Point p);

    char getColor();
}
