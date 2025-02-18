package robotism;

import fr.tp.inf112.projects.canvas.model.Color;

/**
 * Represents a basic color with red, green, and blue components.
 */
public class BasicColor implements Color {
	private static final long serialVersionUID = 125698;

    /**
     * The degree of red in the color.
     */
    private int redDegree;

    /**
     * The degree of green in the color.
     */
    private int greenDegree;

    /**
     * The degree of blue in the color.
     */
    private int blueDegree;

    /**
     * Constructs a new BasicColor instance with the given red, green, and blue degrees.
     * 
     * @param redDegree   the degree of red (0-255)
     * @param greenDegree the degree of green (0-255)
     * @param blueDegree  the degree of blue (0-255)
     * @throws IllegalArgumentException if any degree is not between 0 and 255
     */
    public BasicColor(int redDegree, int greenDegree, int blueDegree) {
        super();
        // Validate the color component values
        if (redDegree < 0 || redDegree > 255) {
            throw new IllegalArgumentException("Invalid value for red degree. Value must be between 0 and 255.");
        }
        if (greenDegree < 0 || greenDegree > 255) {
            throw new IllegalArgumentException("Invalid value for green degree. Value must be between 0 and 255.");
        }
        if (blueDegree < 0 || blueDegree > 255) {
            throw new IllegalArgumentException("Invalid value for blue degree. Value must be between 0 and 255.");
        }
        this.redDegree = redDegree;
        this.greenDegree = greenDegree;
        this.blueDegree = blueDegree;
    }

    /**
     * Returns the red component of the color.
     * 
     * @return the red component (0-255)
     */
    @Override
    public int getRedComponent() {
        return this.redDegree;
    }

    /**
     * Returns the green component of the color.
     * 
     * @return the green component (0-255)
     */
    @Override
    public int getGreenComponent() {
        return this.greenDegree;
    }

    /**
     * Returns the blue component of the color.
     * 
     * @return the blue component (0-255)
     */
    @Override
    public int getBlueComponent() {
        return this.blueDegree;
    }
}
