package robotism;

import fr.tp.inf112.projects.canvas.model.OvalShape;

/**
 * Represents a basic oval shape with a width and height.
 */
public class BasicOval implements OvalShape {
	private static final long serialVersionUID = 2365;

    /**
     * The width of the oval shape.
     */
    private int width;

    /**
     * The height of the oval shape.
     */
    private int height;

    /**
     * Constructs a new BasicOval instance with the given width and height.
     * 
     * @param width  the width of the oval shape
     * @param height the height of the oval shape
     * @throws IllegalArgumentException if width or height is less than or equal to zero
     */
    public BasicOval(int width, int height) {
        super();
        // Validate the width and height values
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero.");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the oval shape.
     * 
     * @return the width of the oval shape
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of the oval shape.
     * 
     * @return the height of the oval shape
     */
    @Override
    public int getHeight() {
        return height;
    }
}