package robotism;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Stroke;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a basic style with a background color and a stroke.
 */
public class BasicStyle implements Style {
	private static final long serialVersionUID = 197;

    /**
     * The background color of the style.
     */
    private Color couleur; 

    /**
     * The stroke of the style.
     */
    private Stroke contour; 

    /**
     * Constructs a new BasicStyle instance with the given background color and stroke.
     * 
     * @param couleur the background color of the style
     * @param contour the stroke of the style
     * @throws IllegalArgumentException if the background color or stroke is null
     */
    public BasicStyle(Color couleur, Stroke contour) {
        // Validate the background color
        if (couleur == null) {
            throw new IllegalArgumentException("Background color cannot be null.");
        }
        // Validate the stroke
        if (contour == null) {
            throw new IllegalArgumentException("Stroke cannot be null.");
        }
        this.couleur = couleur;
        this.contour = contour;
    }

    /**
     * Returns the background color of the style.
     * 
     * @return the background color of the style
     */
    @Override
    public Color getBackgroundColor() {
        return this.couleur;
    }

    /**
     * Returns the stroke of the style.
     * 
     * @return the stroke of the style
     */
    @Override
    public Stroke getStroke() {
        return this.contour;
    }
}