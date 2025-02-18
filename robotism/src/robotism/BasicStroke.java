package robotism;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;

/**
 * Represents a basic stroke with a color, thickness, and dash pattern.
 */
public class BasicStroke implements Stroke {
	private static final long serialVersionUID = 1333322;

    /**
     * The color of the stroke.
     */
    private Color couleur; 

    /**
     * The thickness of the stroke.
     */
    private float thickness; 

    /**
     * The dash pattern of the stroke.
     */
    private float[] dashPattern; 

    /**
     * Constructs a new BasicStroke instance with the given color, thickness, and dash pattern.
     * 
     * @param couleur     the color of the stroke
     * @param thickness   the thickness of the stroke
     * @param dashPattern the dash pattern of the stroke
     * @throws IllegalArgumentException if the color is null or the thickness is less than or equal to zero
     */
    public BasicStroke(Color couleur, float thickness, float[] dashPattern) {
        // Validate the color
        if (couleur == null) {
            throw new IllegalArgumentException("Color cannot be null.");
        }
        // Validate the thickness
        if (thickness <= 0) {
            throw new IllegalArgumentException("Thickness must be greater than zero.");
        }
        this.couleur = couleur;
        this.thickness = thickness;
        this.dashPattern = dashPattern;
    }

    /**
     * Returns the color of the stroke.
     * 
     * @return the color of the stroke
     */
    @Override
    public Color getColor() {
        return this.couleur;
    }

    /**
     * Returns the thickness of the stroke.
     * 
     * @return the thickness of the stroke
     */
    @Override
    public float getThickness() {
        return this.thickness;
    }

    /**
     * Returns the dash pattern of the stroke.
     * 
     * @return the dash pattern of the stroke
     */
    @Override
    public float[] getDashPattern() {
        return this.dashPattern;
    }
}