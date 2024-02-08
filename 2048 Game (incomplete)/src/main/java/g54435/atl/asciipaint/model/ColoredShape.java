package g54435.atl.asciipaint.model;

/**
 * ColoredShape Class add a color to a shape
 */
public abstract class ColoredShape implements Shape {

    /**
     * Color
     */
    private char Color;

    /**
     * Constrcutor of the color
     * @param color
     */
    public ColoredShape(char color) {
        Color = color;
    }

    /**
     * Getter of the color
     * @return char of the color
     */
    @Override
    public char getColor() {
        return this.Color;
    }

    /**
     * set the color to the shape
     * @param color
     */
    public void setColor(char color) {
        Color = color;
    }
}

