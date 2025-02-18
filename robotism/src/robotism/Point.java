package robotism;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.Vertex;

/**
 * Represents a point in a 2D space, implementing the Vertex interface.
 */
public class Point implements Vertex,Serializable {
	private static final long serialVersionUID = 2003635;
	
	/**
	 * The x-coordinate of the point.
	 */
	private int coordinatX ; 
	
	/**
	 * The y-coordinate of the point.
	 */
	private int coordinatY ; 

	
	
	
	/**
	 * Creates a new Point instance with the given coordinates.
	 * 
	 * @param coordinatX the x-coordinate
	 * @param coordinatY the y-coordinate
	 */
	Point(double coordinatX, double coordinatY) {
		this.coordinatX = (int) coordinatX;
		this.coordinatY = (int) coordinatY;
	}

	/**
	 * Returns the x-coordinate of the point.
	 */
	@Override
	public int getxCoordinate() {
		return coordinatX;
	}

	/**
	 * Returns the y-coordinate of the point.
	 */
	@Override
	public int getyCoordinate() {
		return coordinatY;
	}

}