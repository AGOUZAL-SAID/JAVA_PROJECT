package robotism;

import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a product, extending the Component class.
 */
public class Product extends Component {
	private static final long serialVersionUID = 18965225;
	
	/**
	 * The destination of the product.
	 */
	private String destination ; 
	
	/**
	 * Whether the product is carried or not.
	 */
	private boolean carried;

	/**
	 * Creates a new Product instance with the given parameters.
	 * 
	 * @param name the name of the product
	 * @param positionX the x-coordinate of the product
	 * @param positionY the y-coordinate of the product
	 * @param length the length of the product
	 * @param width the width of the product
	 * @param destination the destination of the product
	 * @param carried whether the product is carried or not
	 */
	private Product(String name, double positionX, double positionY, double length, double width,String destination,boolean carried) {
		super(name, positionX, positionY, length, width);
		this.destination = destination;
		this.carried = carried;
	}

	/**
	 * Returns whether the product is carried or not.
	 */
	public boolean isCarried() {
		return this.carried;
	}
	
	/**
	 * Returns the destination of the product.
	 */
	public String showDestination() {
		return this.destination;
	}
	
	/**
	 * Sets the carried status of the product.
	 * 
	 * @param newEtat the new carried status
	 */
	public void setSituation(boolean newEtat) {
		this.carried = newEtat ;
	}

	/**
	 * Sets the destination of the product.
	 * 
	 * @param destinationToGo the new destination
	 */
	public void setDestination(String destinationToGo) {
		this.destination = destinationToGo ;
	}
	
	/**
	 * Prints the product's information to the console.
	 */
	public void printToConsol() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Product [destination=" + destination + ", carried=" + carried + ", GetPosition()="
				+ Arrays.toString(getPosition()) + ", GetName()=" + getName() + ", GetLength()=" + getLength()
				+ ", GetWidth()=" + getWidthOfComponent() + "]";
	}
	

	@Override
	/**
	 * Returns the shape of the product as a BasicOval.
	 */
	public Shape getShape() {
		return new BasicOval((int)this.width, (int)this.width);
	}


	@Override
	/**
	 * Returns the x-coordinate of the product.
	 */
	public int getxCoordinate() {
		return (int)this.positionX ;
	}


	@Override
	/**
	 * Returns the y-coordinate of the product.
	 */
	public int getyCoordinate() {
		return (int)this.positionY ;
	}


	@Override
	/**
	 * Returns the style of the product as a BasicStyle.
	 */
	public Style getStyle() {
		BasicColor couleurArea = new BasicColor(0,0,0);
		BasicColor couleurContorArea = new BasicColor(0,0,0);
		BasicStroke strockRobot = new BasicStroke(couleurContorArea,8.5f,null) ;
		
		return new BasicStyle(couleurArea,strockRobot);
	}
	

}