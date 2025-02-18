package robotism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Represents a robot, extending the Component class.
 */
public class Robot extends Component {
	private static final long serialVersionUID = 555555555;
	
	private static transient FactoryPathFinder pathFinder;
	
	/**
	 * The factory associated with this robot.
	 */
	private Factory myFactory ; 
	
	
	/**
	 * The speed of the robot.
	 */
	private int  speed        ; 
	
	/**
	 * The battery level of the robot.
	 */
	private double     batterie     ;
	
	
	/**
	 * Whether the robot is working or not.
	 */
	private boolean working      ; 
	
	/**
	 * Whether the robot has items in stock or not.
	 */
	private boolean stocksItem   ;
	
	
	/**
	 * The list of destinations for the robot.
	 */
	private ArrayList<Component> destinations;
	

	
	
	/**
	 * Creates a new Robot instance with the given parameters.
	 * 
	 * @param name the name of the robot
	 * @param positionX the x-coordinate of the robot
	 * @param positionY the y-coordinate of the robot
	 * @param length the length of the robot
	 * @param width the width of the robot
	 * @param speed the speed of the robot
	 * @param batterie the battery level of the robot
	 * @param working whether the robot is working or not
	 * @param stocksItem whether the robot has items in stock or not
	 * @param destinations the list of destinations for the robot
	 */
	Robot(String name, double positionX, double positionY, double length, double width,int speed, double batterie, boolean working, boolean stocksItem,ArrayList<Component> destinations,FactoryPathFinder pathFinder) {
		super(name,positionX,positionY,length,width);
		this.speed = speed;
		this.batterie = batterie;
		this.working = working;
		this.stocksItem = stocksItem;
		this.destinations = destinations;
		this.pathFinder= pathFinder;
	

	}
	
	
	/**
	 * Prints the robot's information to the console.
	 */
	public void PrintToConsol() {
		System.out.println(this);
	}

	
	@Override
	public String toString() {
		return "Robot [Speed=" + speed + ", Batterie=" + batterie + ", Working=" + working + ", StocksItem="
				+ stocksItem + ", GetPosition()=" + Arrays.toString(getPosition()) + ", GetName()=" + getName()
				+ ", GetLength()=" + getLength() + ", GetWidth()=" + getWidthOfComponent() + "]";
		
		
	}
	
	
	/**
	 * Returns the speed of the robot.
	 */
	public double getSpeed() {
		return this.speed;
	}
	
	
	/**
	 * Returns the battery level of the robot.
	 */
	public double getBetterieLevel() {
		return this.batterie;
	}
	
	
	/**
	 * Returns whether the robot is working or not.
	 */
	public boolean isRobotWorking() {
		return this.working;
	}
	

	/**
	 * Returns whether the robot has items in stock or not.
	 */
	public boolean isRobotStock() {
		return this.stocksItem;
	}
	
	@Override
	/**
	 * Returns the shape of the robot as a BasicOval.
	 */
	public Shape getShape() {
		return new BasicOval((int)this.width, (int)this.width);
	}


	@Override
	/**
	 * Returns the x-coordinate of the robot.
	 */
	public int getxCoordinate() {
		return (int)this.positionX;
	}


	@Override
	/**
	 * Returns the y-coordinate of the robot.
	 */
	public int getyCoordinate() {
		return (int)this.positionY;
	}


	@Override
	/**
	 * Returns the style of the robot as a BasicStyle.
	 */
	public Style getStyle() {
		BasicColor couleurRobot = new BasicColor(35,48,248);
		BasicColor couleurContorRobot = new BasicColor(0,0,0);
		//float B[]= {2.5f};
		BasicStroke strockRobot = new BasicStroke(couleurContorRobot,2f,null) ;
		
		return new BasicStyle(couleurRobot,strockRobot);
	}

	@Override
	/**
	 * The behavior of the robot, moving to its destinations.
	 */
	public void behave() {
		if(this.pathFinder==null) {
			TrajectoryFind dij= new TrajectoryFind();
			dij.maillageGeneration();
			dij.edgesGeneration();
			this.pathFinder = dij;
		}
		for(Component destination : destinations) {
			this.move(destination);
		}
		this.move(destinations.get(0));
	};
	
	/**
	 * Moves the robot to a specific destination.
	 * 
	 * @param destination the destination to move to
	 */
	private void move(Component destination) {
		List<Position> positionsToGo= this.pathFinder.findPath(this, destination);
		if (positionsToGo != null) {
		Position ocuupationPosition =((TrajectoryFind) this.pathFinder).approximation(destination);
		int i =0;
		ArrayList<Robot> brothers = new ArrayList<Robot>();
		ArrayList<Door>  doors =  new ArrayList<Door>();
		ChargingPoint chargeStation=null;
		for (Figure component : this.myFactory.getComponent()) {
			if (component instanceof ChargingPoint) {
				chargeStation = (ChargingPoint) component;
				break;
			}
		}
		for (Figure robots : this.myFactory.getComponent()) {
			if (robots instanceof Robot) {
				if (robots != this) {
					brothers.add((Robot) robots);
				}
			}
		}
		for (Figure door : this.myFactory.getComponent()) {
			if (door instanceof Door) {
				if (door != this) {
					doors.add((Door) door);
				}
			}
		}
		
		
		for (Robot robots : brothers) {
				if(robots.getxCoordinate()<(ocuupationPosition.getPositionX()+3) && robots.getxCoordinate()>(ocuupationPosition.getPositionX()-3) && robots.getyCoordinate()<(ocuupationPosition.getPositionY()+3) && robots.getyCoordinate()>(ocuupationPosition.getPositionY()-3)) {
					// i is used to know if there is a robot in the area that i want to visite if i=0 its fine
					i=1;
				}
			
			
		}
		if(i==0) {
	    double[] incrementation = {0, 0.0002, 0.0004, 0.001}; // Valeurs d'incrémentation
	    double tolerance = incrementation[this.speed]; // Tolerance dépendant de la vitesse
	    for(Position position : positionsToGo ) {	
	    while (true) {
	        // Vérifie si les coordonnées actuelles sont proches des coordonnées de la destination
	        if (Math.abs(this.positionX - position.getPositionX()) <= tolerance &&
	            Math.abs(this.positionY - position.getPositionY()) <= tolerance) {
	            break; // Sort de la boucle si l'objet est suffisamment proche de la destination
	        }
	        
	        // Met à jour les coordonnées X si nécessaire
	        if (this.positionX != position.getPositionX()) {
	            if (this.positionX < position.getPositionX()) {
	                this.positionX += incrementation[this.speed];
	                this.batterie-=  incrementation[this.speed];// batterie getting low
	            } else {
	                this.positionX -= incrementation[this.speed];
	                this.batterie-=  incrementation[this.speed];// batterie getting low
	            }
	        }
	        
	        // Met à jour les coordonnées Y si nécessaire
	        if (this.positionY != position.getPositionY()) {
	            if (this.positionY < position.getPositionY()) {
	                this.positionY += incrementation[this.speed];
	                this.batterie-=  incrementation[this.speed];// batterie getting low
	            } else {
	                this.positionY -= incrementation[this.speed];
	                this.batterie-=  incrementation[this.speed];// batterie getting low
	            }
	        }
	        (this.myFactory).notifyObservers();
	        if(!(this.myFactory).isSimulationStarted()) {
	        	break;
	        
	    }
	        for (Door door : doors) {
	        	if(door.isRobotInMyArea(this) && door.isClose()) {
	        		door.open();
	        	}
	        }
	        
	        
	        }
	    if (this.batterie<2500) {
	    	this.batterie=15000;
	    	Component vraidistination= destination;
	    	this.move(chargeStation);
	    	try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	this.move(destination);
	    	break;
	    }
	    }
	    for (Door door : doors) {
	    	door.close();
	    }
	    
	    
		}
		}
		else {
			System.out.println("No avaulable trajectory");
		}
	}
	/**
	 * Sets the myFactory instance variable.
	 * 
	 * @param factory the factory to set
	 */
	public void setMyFactory(Factory factory) {
	    this.myFactory = factory;
	}

	/**
	 * Gets the myFactory instance variable.
	 * 
	 * @return the myFactory instance variable
	 */
	public Factory getMyFactory() {
	    return myFactory;
	}

	/**
	 * Gets the destinations instance variable.
	 * 
	 * @return the destinations instance variable
	 */
	public ArrayList<Component> getDestinations() {
	    return destinations;
	}

	/**
	 * Sets the speed instance variable.
	 * 
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
	    this.speed = speed;
	}

	/**
	 * Sets the batterie instance variable. Note: "batterie" is likely a typo and should be "battery".
	 * 
	 * @param batterie the batterie to set
	 */
	public void setBatterie(int batterie) {
	    this.batterie = batterie;
	}

	/**
	 * Sets the working instance variable.
	 * 
	 * @param working the working status to set
	 */
	public void setWorking(boolean working) {
	    this.working = working;
	}

	/**
	 * Sets the stocksItem instance variable.
	 * 
	 * @param stocksItem the stocksItem status to set
	 */
	public void setStocksItem(boolean stocksItem) {
	    this.stocksItem = stocksItem;
	}

	/**
	 * Sets the destinations instance variable.
	 * 
	 * @param destinations the destinations to set
	 */
	public void setDestinations(ArrayList<Component> destinations) {
	    this.destinations = destinations;
	}
	
	public void setFinder(FactoryPathFinder finder) {
			this.pathFinder = finder;
	}


}
