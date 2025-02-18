package robotism;

import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a ChargingPoint component with a name, position, length, width, and occupation status.
 */
public class ChargingPoint extends Component {
	private static final long serialVersionUID = 10000;

    /**
     * The occupation status of the charging point.
     */
    private boolean occupation;

    /**
     * Constructs a new ChargingPoint instance with the given name, position, length, width, and occupation status.
     * 
     * @param name        the name of the charging point
     * @param positionX   the x-coordinate of the charging point
     * @param positionY   the y-coordinate of the charging point
     * @param length      the length of the charging point
     * @param width       the width of the charging point
     * @param occupation the occupation status of the charging point
     */
    protected ChargingPoint(String name, double positionX, double positionY, double length, double width, boolean occupation) {
        super(name, positionX, positionY, length, width);
        this.occupation = occupation;
    }

    /**
     * Prints the charging point's information to the console.
     */
    public void printToConsol() {
        System.out.println(this);
    }

    /**
     * Returns the occupation status of the charging point.
     * 
     * @return the occupation status of the charging point
     */
    public boolean isOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return "ChargingPoint [occupation=" + occupation + ", GetPosition()=" + Arrays.toString(getPosition())
                + ", GetName()=" + getName() + ", GetLength()=" + getLength() + ", GetWidth()=" + getWidthOfComponent() + "]";
    }

    /**
     * Returns the shape of the charging point as a BasicRectangleShape.
     * 
     * @return the shape of the charging point
     */
    @Override
    public Shape getShape() {
        return new BasicRectangleShape((int) this.getWidthOfComponent(), (int) this.getLength());
    }

    /**
     * Returns the x-coordinate of the charging point.
     * 
     * @return the x-coordinate of the charging point
     */
    @Override
    public int getxCoordinate() {
        return (int) this.positionX;
    }

    /**
     * Returns the y-coordinate of the charging point.
     * 
     * @return the y-coordinate of the charging point
     */
    @Override
    public int getyCoordinate() {
        return (int) this.positionY;
    }

    /**
     * Returns the style of the charging point as a BasicStyle with a green fill color and a black stroke.
     * 
     * @return the style of the charging point
     */
    @Override
    public Style getStyle() {
        BasicColor couleurArea = new BasicColor(117, 243, 22);
        BasicColor couleurContorArea = new BasicColor(0, 0, 0);

        BasicStroke strokeRobot = new BasicStroke(couleurContorArea, 2f, null);
        return new BasicStyle(couleurArea, strokeRobot);
    }
}