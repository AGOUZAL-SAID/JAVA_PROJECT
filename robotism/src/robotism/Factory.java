package robotism;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import fr.tp.inf112.projects.canvas.controller.Observable;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * Factory class that extends Component and implements Canvas and Observable.
 */
public class Factory extends Component implements Canvas, Observable {
	private static final long serialVersionUID = 16568855;
	private String id ; 
    private String name;
    private int width;
    private int length;
    private Collection<Figure> components;
    private boolean animation;
    private transient ArrayList<Observer> observers;

    /**
     * Constructor for Factory.
     * 
     * @param name        the name of the factory
     * @param width       the width of the factory
     * @param length      the length of the factory
     * @param components the collection of figures in the factory
     * @param positionX   the x-coordinate of the factory
     * @param positionY   the y-coordinate of the factory
     * @param observers   the list of observers for the factory
     */
    public Factory(String name, int width, int length, Collection<Figure> components, double positionX, double positionY, ArrayList<Observer> observers,String id) {
        super(name, positionX, positionY, length, width);
        this.name = name;
        this.components = components;
        this.observers = observers;
        this.animation = false;
        this.length = length;
        this.width = width;
        this.id = id ; 
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.length;
    }

    @Override
    public Collection<Figure> getFigures() {
        return this.components;
    }

    @Override
    public Style getStyle() {
        // Create a basic style with a yellow background and a black border
        BasicColor couleurArea = new BasicColor(241, 241, 167);
        BasicColor couleurContorArea = new BasicColor(0, 0, 0);
        BasicStroke strockRobot = new BasicStroke(couleurContorArea, 2f, null);
        return new BasicStyle(couleurArea, strockRobot);
    }

    /**
     * Make each robot in the factory behave.
     */
    public void behave() {
        for (Figure mycomponent : components) {
            if (mycomponent instanceof Robot) {
                ((Component) mycomponent).behave();
                
            }
           // if (!isSimulationStarted()) {
           //     break;
          //  }
        }
    }

    @Override
    public boolean addObserver(Observer observer) {
    	if(this.observers==null) { 
    		this.observers = new ArrayList<Observer>();
    		this.observers.add(observer);
    	}
        return observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
    	if(this.observers==null) {return false ;  }
        return observers.remove(observer);
    }

    /**
     * Notify all observers that the model has changed.
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.modelChanged();
        }
    }

    /**
     * Identify each robot in the factory and set its factory reference.
     */
    public void identifyComponent() {
        for (Figure component : components) {
            if (component instanceof Robot) {
                ((Robot) component).setMyFactory(this);
            }
            if (component instanceof Door) {
                ((Door) component).setMyFactory(this);
            }
        }
    }

    /**
     * Stop the simulation.
     */
    public void stopSimulation() {
        this.animation = false;
        notifyObservers();
    }

    /**
     * Start the simulation.
     */
    public void startSimulation() {
        this.animation = true;
        notifyObservers();
    }

    /**
     * Check if the simulation is started.
     * 
     * @return true if the simulation is started, false otherwise
     */
    public boolean isSimulationStarted() {
        return this.animation;
    }

    @Override
    public int getxCoordinate() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getyCoordinate() {
        // TODO Auto-generated method stub
        return 0;
    }

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id ; 
	}
	
	public ArrayList<Observer> getObservers() {
		 if (observers == null) {
		 observers = new ArrayList<>();
		 }
		 return observers;
		 }
	public Collection<Figure> getComponent(){
		return this.components;
	}

}