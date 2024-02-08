package g54435.atl.asciipaint.model;

public class Circle extends ColoredShape {
    private Point center;
    private double radius;

    /**
     * Constructor of Circle
     * @param center position of the center on the drawing
     * @param radius radius of the circle
     * @param color color in char
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }


    /**
     * Check if a point is inside of a shape
     * @param p point in the shape to check
     * @return a boolean (true = isInsinde)
     */
    @Override
    public boolean isInside(Point p) {
        return  ((p.getX() - center.getX()) * (p.getX() - center.getX()) +
                (p.getY() - center.getY()) * (p.getY() - center.getY()) < radius * radius);

    }

}
