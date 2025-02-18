package robotism;

import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents an Area in the robotism system.
 */
public class Area extends Component {

    /**
     * The number of products in the area.
     */
    private int productNb;

    /**
     * Creates a new Area instance.
     * 
     * @param name        the name of the area
     * @param positionX   the x-coordinate of the area
     * @param positionY   the y-coordinate of the area
     * @param length      the length of the area
     * @param width       the width of the area
     * @param productNb   the number of products in the area
     */
    protected Area(String name, double positionX, double positionY, double length, double width, int productNb) {
        super(name, positionX, positionY, length, width);
        this.productNb = productNb;
    }

    /**
     * Prints the area's details to the console.
     */
    public void printToConsole() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Area [productNb=" + productNb + ", Position=" + Arrays.toString(getPosition()) + ", Name=" + getName()
                + ", Length=" + getLength() + ", Width=" + getWidthOfComponent() + "]";
    }

    /**
     * Returns the number of products in the area.
     * 
     * @return the number of products
     */
    public int numberOfProductInArea() {
        return this.productNb;
    }

    @Override
    public Shape getShape() {
        // Create a new BasicRectangleShape with the area's dimensions
        return new BasicRectangleShape((int) getWidthOfComponent(), (int) getLength());
    }

    @Override
    public int getxCoordinate() {
        return (int) this.positionX;
    }

    @Override
    public int getyCoordinate() {
        return (int) this.positionY;
    }

    @Override
    public Style getStyle() {
        try {
            // Create a new BasicStyle with the area's colors and stroke
            BasicColor areaColor = new BasicColor(250, 188, 242);
            BasicColor contourColor = new BasicColor(0, 0, 0);
            BasicStroke stroke = new BasicStroke(contourColor, 2f, null);
            return new BasicStyle(areaColor, stroke);
        } catch (Exception e) {
            // Handle any exceptions that occur during style creation
            System.err.println("Error creating style: " + e.getMessage());
            return null;
        }
    }}