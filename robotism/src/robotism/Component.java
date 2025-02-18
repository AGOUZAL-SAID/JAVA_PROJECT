package robotism;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Shape;

/**
 * Represents a component with a name, position, length, and width.
 */
public abstract class Component implements Figure,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1;

	/**
     * The name of the component.
     */
    protected String name;

    /**
     * The x-coordinate of the component's position.
     */
    protected double positionX;

    /**
     * The y-coordinate of the component's position.
     */
    protected double positionY;

    /**
     * The length of the component.
     */
    protected double length;

    /**
     * The width of the component.
     */
    protected double width;

    /**
     * Constructs a new Component instance with the given name, position, length, and width.
     * 
     * @param name        the name of the component
     * @param positionX   the x-coordinate of the component's position
     * @param positionY   the y-coordinate of the component's position
     * @param length      the length of the component
     * @param width       the width of the component
     * @throws NullPointerException if the name is null
     */
    protected Component(String name, double positionX, double positionY, double length, double width) {
        if (name == null) {
            throw new NullPointerException("Name cannot be null.");
        }
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.length = length;
        this.width = width;
    }

    /**
     * Returns the position of the component as an array of two doubles.
     * 
     * @return the position of the component
     */
    final public double[] getPosition() {
        double[] positions = { this.positionX, this.positionY };
        return positions;
    }

    /**
     * Returns the name of the component.
     * 
     * @return the name of the component
     */
    final public String getName() {
        return this.name;
    }

    /**
     * Returns the length of the component.
     * 
     * @return the length of the component
     */
    final public double getLength() {
        return this.length;
    }

    /**
     * Returns the width of the component.
     * 
     * @return the width of the component
     */
    final public double getWidthOfComponent() {
        return this.width;
    }

    /**
     * Returns the x-coordinate of the component's position.
     * 
     * @return the x-coordinate of the component's position
     */
    final public double getCoordinateX() {
        return this.positionX;
    }

    /**
     * Returns the y-coordinate of the component's position.
     * 
     * @return the y-coordinate of the component's position
     */
    final public double getCoordinateY() {
        return this.positionY;
    }

    /**
     * Returns the shape of the component as a BasicOval.
     * 
     * @return the shape of the component
     */
    @Override
    public Shape getShape() {
        return new BasicOval((int) width, (int) length);
    }

    /**
     * A placeholder method for component behavior.
     */
    public void behave() {
        //  implemented in wanted components 
    }
    
    /**
     * Sets the x-coordinate of the object.
     * 
     * @param newPosition the new x-coordinate
     */
    final public void setCoordinateX(double newPosition) {
        this.positionX = newPosition;
    }

    /**
     * Sets the y-coordinate of the object.
     * 
     * @param newPosition the new y-coordinate
     */
    final public void setCoordinateY(double newPosition) {
        this.positionY = newPosition; // Corrected variable name
    }

    /**
     * Sets the length of the object.
     * 
     * @param newLenght the new length (note: typo in method name, should be "Length")
     */
    final public void setLenght(double newLenght) {
        this.length = newLenght; // Corrected variable name
    }

    /**
     * Sets the width of the object.
     * 
     * @param newWidth the new width
     */
    final public void setWidth(double newWidth) {
        this.width = newWidth; // Corrected variable name
    }
}