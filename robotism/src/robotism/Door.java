package robotism;

import java.util.Arrays;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a Door component with a state property.
 */
public class Door extends Component {
	private static final long serialVersionUID = 100035;
	
	private Factory myFactory ; 
	
	private double originalX;
	private double originaleY;


    /**
     * The state of the Door (open or closed).
     */
    private boolean state;

    /**
     * Constructs a new Door instance with the given name, position, length, width, and state.
     * 
     * @param name            the name of the Door
     * @param positionX       the x-coordinate of the Door's position
     * @param positionY       the y-coordinate of the Door's position
     * @param length          the length of the Door
     * @param width           the width of the Door
     * @param state           the state of the Door (open or closed)
     * @throws NullPointerException if the name is null
     * @throws IllegalArgumentException if the length or width is negative
     */
    protected Door(String name, double positionX, double positionY, double length, double width, boolean state) {
        super(name, positionX, positionY, length, width);
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative.");
        }
        this.state = state;
    }

    /**
     * Prints the Door's details to the console.
     */
    public void printToConsol() {
        System.out.println(this);
    }

    /**
     * Returns a string representation of the Door.
     * 
     * @return a string representation of the Door
     */
    @Override
    public String toString() {
        return "Door [state=" + state + ", GetPosition()=" + Arrays.toString(getPosition()) + ", GetName()=" + getName()
                + ", GetLength()=" + getLength() + ", GetWidth()=" + getWidthOfComponent() + "]";
    }

    /**
     * Returns the state of the Door (open or closed).
     * 
     * @return the state of the Door
     */
    public boolean getStateOfDoor() {
        return this.state;
    }

    /**
     * Returns the shape of the Door as a BasicRectangleShape.
     * 
     * @return the shape of the Door
     */
    @Override
    public Shape getShape() {
        return new BasicRectangleShape((int) this.width, (int) this.length);
    }

    /**
     * Returns the x-coordinate of the Door's position.
     * 
     * @return the x-coordinate of the Door's position
     */
    @Override
    public int getxCoordinate() {
        return (int) this.positionX;
    }

    /**
     * Returns the y-coordinate of the Door's position.
     * 
     * @return the y-coordinate of the Door's position
     */
    @Override
    public int getyCoordinate() {
        return (int) this.positionY;
    }

    /**
     * Returns the style of the Door.
     * 
     * @return the style of the Door
     */
    @Override
    public Style getStyle() {
        BasicColor couleurArea = new BasicColor(250, 29, 26);
        BasicColor couleurContorArea = new BasicColor(0, 0, 0);
        BasicStroke strockRobot = new BasicStroke(couleurContorArea, 2f, null);
        return new BasicStyle(couleurArea, strockRobot);
    }
    
    public boolean isRobotInMyArea(Robot robot) {
    	boolean t=false;
    	int x = robot.getxCoordinate();
    	int y = robot.getyCoordinate();
    	//horizontal door
    	if (this.width > this.length) {
    		return (x>this.getCoordinateX()&& x<(this.getCoordinateX()+this.width) && y>(this.getCoordinateY()-15*3.8) && y<(this.getCoordinateY()+15*3.8));
    	}
    	//verticale door
    	else {
    		return (y>this.getCoordinateY()&& y<(this.getCoordinateY()+this.length) && x<(this.getCoordinateX()+15*6.4) && x>(this.getCoordinateX()-15*6.4));
    	}
    	
    	
    }
    
    
    /**
	 * Sets the myFactory instance variable.
	 * 
	 * @param factory the factory to set
	 */
	public void setMyFactory(Factory factory) {
	    this.myFactory = factory;
	    this.originaleY=this.positionY;
	    this.originalX = this.positionX;
	}

	/**
	 * Gets the myFactory instance variable.
	 * 
	 * @return the myFactory instance variable
	 */
	public Factory getMyFactory() {
	    return myFactory;
	}

	public void open() {
		//horizontal door openinig
		if(this.width>this.length) {
			int x = this.getxCoordinate();
			while(true) {
				if (Math.abs(this.positionX - (x+this.width)) <= 5 ||
			            Math.abs(this.positionX - (x-this.width)) <= 5) {
			            break; // Sort de la boucle si l'objet est suffisamment proche de la destination
			        }
				
		     if (this.positionX < 960) {//960 middle of the canvas because there is doors in the right and the left of the midle
		                this.positionX -= 0.0001;} 
		     else {
		                this.positionX +=0.0001;
		            }
		        (this.myFactory).notifyObservers();
			}
		}
		//verticale door opening 
		else {
			int y = this.getyCoordinate();
			while(true) {
				if (Math.abs(this.positionY - (y-this.length)) <= 5) {
			            break; // Sort de la boucle si l'objet est suffisamment proche de la destination
			        }
			this.positionY-=0.0001;
		    (this.myFactory).notifyObservers();
			}
			
		}
	}
	public void close() {
		//i just teleport to not waste you time in simulation
		this.positionX=this.originalX;
		this.positionY=this.originaleY;
		this.myFactory.notifyObservers();
	}
	
	public boolean isClose() {
		return (this.positionX==this.originalX && this.originaleY==this.positionY);
	}
}