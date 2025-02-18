package robotism;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a Room in the robotism context.
 */
public class Room extends Component {
	private static final long serialVersionUID = 6666669;

    /**
     * Constructs a new Room instance.
     * 
     * @param name        the name of the room
     * @param positionX  the x-coordinate of the room's position
     * @param positionY  the y-coordinate of the room's position
     * @param length     the length of the room
     * @param width      the width of the room
     */
    protected Room(String name, double positionX, double positionY, double length, double width) {
        super(name, positionX, positionY, length, width);
    }

    /**
     * Returns the shape of the room, which is a basic rectangle.
     * 
     * @return a BasicRectangleShape instance
     */
    @Override
    public Shape getShape() {
        return new BasicRectangleShape((int) this.width, (int) this.length);
    }

    /**
     * Returns the x-coordinate of the room's position as an integer.
     * 
     * @return the x-coordinate as an integer
     */
    @Override
    public int getxCoordinate() {
        return (int) this.positionX;
    }

    /**
     * Returns the y-coordinate of the room's position as an integer.
     * 
     * @return the y-coordinate as an integer
     */
    @Override
    public int getyCoordinate() {
        return (int) this.positionY;
    }

    /**
     * Returns the style of the room, which includes a fill color and a stroke.
     * 
     * @return a BasicStyle instance
     */
    @Override
    public Style getStyle() {
        // Define the fill color and stroke color
        BasicColor couleurArea = new BasicColor(241, 192, 85);
        BasicColor couleurContorArea = new BasicColor(0, 0, 0);
        
        // Create a stroke with the stroke color and a width of 2f
        BasicStroke strockRobot = new BasicStroke(couleurContorArea, 2f, null);
        
        // Return a BasicStyle instance with the fill color and stroke
        return new BasicStyle(couleurArea, strockRobot);
    }
}