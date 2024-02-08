package g54435.atl.asciipaint.model;

/**
 * Rectangle is a shape
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor of the rectangle
     * @param upperLeft Point of the upperLeft (position of the rectangle)
     * @param width width of the rectangle
     * @param height height of the rectangle
     * @param color color in
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @param p Point to check if the shape is inSide
     * @return a boolean (true = isInsinde)
     */
    @Override
    public boolean isInside(Point p) {
        boolean widt = p.getX() >= upperLeft.getX() && p.getX() <= upperLeft.getX() + width-1;
        boolean hgt = p.getY() >= upperLeft.getY() && p.getY() <= upperLeft.getY() + height-1;
        return widt && hgt;


    }

}

