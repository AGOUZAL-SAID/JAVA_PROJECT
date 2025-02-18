package robotism;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a production unit, extending the Component class.
 */
public class ProductionUnite extends Component {
	private static final long serialVersionUID = 1559522;
	
	/**
	 * Whether the production unit is working or not.
	 */
	private boolean working ;

	/**
	 * Creates a new ProductionUnite instance with the given parameters.
	 * 
	 * @param name the name of the production unit
	 * @param positionX the x-coordinate of the production unit
	 * @param positionY the y-coordinate of the production unit
	 * @param length the length of the production unit
	 * @param width the width of the production unit
	 * @param working whether the production unit is working or not
	 */
	ProductionUnite(String name, double positionX, double positionY, double length, double width,boolean working ) {
		super(name, positionX, positionY, length, width);
		this.working = working ; 
	} 
	
	
	/**
	 * Returns whether the production unit is working or not.
	 */
	public boolean isWorking() {
		return this.working;
	}

	/**
	 * Sets the production unit to working state.
	 */
	public void setToWorking() {
		this.working = true;
	}
	
	/**
	 * Sets the production unit to not working state.
	 */
	public void setToNotWorking() {
		this.working = false;
	}
	
	@Override
	public String toString() {
		return "ProductionUnite [working=" + working + ", Name=" + name + ", PositionX=" + positionX + ", PositionY="
				+ positionY + ", Length=" + length + ", Width=" + width + "]";
	}
	


	@Override
	/**
	 * Returns the shape of the production unit as a BasicRectangleShape.
	 */
	public Shape getShape() {
		return new BasicRectangleShape((int)this.width, (int)this.length);
	}


	@Override
	/**
	 * Returns the x-coordinate of the production unit.
	 */
	public int getxCoordinate() {
		return (int)this.positionX ;
	}


	@Override
	/**
	 * Returns the y-coordinate of the production unit.
	 */
	public int getyCoordinate() {
		return (int)this.positionY ;
	}


	@Override
	/**
	 * Returns the style of the production unit as a BasicStyle.
	 */
	public Style getStyle() {
		BasicColor couleurArea = new BasicColor(185,174,150);
		BasicColor couleurContorArea = new BasicColor(0,0,0);
		BasicStroke strockRobot = new BasicStroke(couleurContorArea,2f,null) ;
		
		return new BasicStyle(couleurArea,strockRobot);
	}
	
	
	
	
}