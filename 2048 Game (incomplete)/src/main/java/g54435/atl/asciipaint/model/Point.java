package g54435.atl.asciipaint.model;

/**
 * Classe Point
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor of a new point
     * @param x position X of this point
     * @param y position Y of this point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X in double
     */
    public double getX() { return x; }

    /**
     * @return Y in double
     */
    public double getY() { return y; }


    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
