package robotism;

import fr.tp.inf112.projects.canvas.model.RectangleShape;

/**
 * Represents a basic rectangle shape with a width and height.
 */
public class BasicRectangleShape implements RectangleShape {
	private static final long serialVersionUID = 18666;

    /**
     * The width of the rectangle.
     */
    private int width; 

    /**
     * The height of the rectangle.
     */
    private int height; 

    /**
     * Constructs a new BasicRectangleShape instance with the given width and height.
     * 
     * @param width  the width of the rectangle
     * @param height the height of the rectangle
     * @throws IllegalArgumentException if the width or height is less than or equal to zero
     */
    public BasicRectangleShape(int width, int height) {
        // Validate the width and height
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than zero.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the rectangle.
     * 
     * @return the width of the rectangle
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the rectangle.
     * 
     * @return the height of the rectangle
     */
    @Override
    public int getHeight() {
        return height;
    }
}