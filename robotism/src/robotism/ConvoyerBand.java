package robotism;

import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a ConvoyerBand component with speed, enable, and sensDirection properties.
 */
public class ConvoyerBand extends Component {
	private static final long serialVersionUID = 16698852;

    /**
     * The speed of the ConvoyerBand.
     */
    private double speed;

    /**
     * Whether the ConvoyerBand is enabled.
     */
    private boolean enable;

    /**
     * The direction of the ConvoyerBand.
     */
    private int sensDirection;

    /**
     * Constructs a new ConvoyerBand instance with the given name, position, length, width, speed, enable, and sensDirection.
     * 
     * @param name            the name of the ConvoyerBand
     * @param positionX       the x-coordinate of the ConvoyerBand's position
     * @param positionY       the y-coordinate of the ConvoyerBand's position
     * @param length          the length of the ConvoyerBand
     * @param width           the width of the ConvoyerBand
     * @param speed           the speed of the ConvoyerBand
     * @param enable          whether the ConvoyerBand is enabled
     * @param sensDirection   the direction of the ConvoyerBand
     * @throws NullPointerException if the name is null
     */
    protected ConvoyerBand(String name, double positionX, double positionY, double length, double width, double speed, boolean enable, int sensDirection) {
        super(name, positionX, positionY, length, width);

        this.speed = speed;
        this.enable = enable;
        this.sensDirection = sensDirection;
    }

    /**
     * Returns the speed of the ConvoyerBand.
     * 
     * @return the speed of the ConvoyerBand
     */
    public double getSpeed() {
        return this.speed;
    }

    /**
     * Returns whether the ConvoyerBand is enabled.
     * 
     * @return whether the ConvoyerBand is enabled
     */
    public boolean isEnable() {
        return this.enable;
    }

    /**
     * Returns the direction of the ConvoyerBand.
     * 
     * @return the direction of the ConvoyerBand
     */
    public int getSensDirection() {
        return this.sensDirection;
    }

    /**
     * Prints the ConvoyerBand's details to the console.
     */
    public void printToConsol() {
        System.out.println(this);
    }

    /**
     * Returns a string representation of the ConvoyerBand.
     * 
     * @return a string representation of the ConvoyerBand
     */
    @Override
    public String toString() {
        return "ConvoyerBand [speed=" + speed + ", enable=" + enable + ", sensDirection=" + sensDirection
                + ", GetPosition()=" + Arrays.toString(getPosition()) + ", GetName()=" + getName() + ", GetLength()="
                + getLength() + ", GetWidth()=" + getWidthOfComponent() + "]";
    }

    /**
     * Returns the shape of the ConvoyerBand as a BasicRectangleShape.
     * 
     * @return the shape of the ConvoyerBand
     */
    @Override
    public Shape getShape() {
        return new BasicRectangleShape((int) this.width, (int) this.length);
    }

    /**
     * Returns the x-coordinate of the ConvoyerBand's position.
     * 
     * @return the x-coordinate of the ConvoyerBand's position
     */
    @Override
    public int getxCoordinate() {
        return (int) this.positionX;
    }

    /**
     * Returns the y-coordinate of the ConvoyerBand's position.
     * 
     * @return the y-coordinate of the ConvoyerBand's position
     */
    @Override
    public int getyCoordinate() {
        return (int) this.positionY;
    }

    /**
     * Returns the style of the ConvoyerBand.
     * 
     * @return the style of the ConvoyerBand
     */
    @Override
    public Style getStyle() {
        BasicColor couleurArea = new BasicColor(185, 174, 150);
        BasicColor couleurContorArea = new BasicColor(0, 0, 0);
        BasicStroke strockRobot = new BasicStroke(couleurContorArea, 2f, null);
        return new BasicStyle(couleurArea, strockRobot);
    }
}