package robotism;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Logger;

import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.canvas.model.Vertex;
import fr.tp.inf112.projects.canvas.view.CanvasViewer;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;

public class SimulatorApplication {
	private static final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());

	public SimulatorApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		LOGGER.info("Starting the robot simulator...");
		LOGGER.config("With parameters " + Arrays.toString(args) + ".");
		
		Room  R1  = new Room("Packaging Room", 0*6.4, 50*3.0857, 150*3.0857f, 150*6.4);
		Room  R2  = new Room("Sorting Room", 150*6.4, 50*3.0857, 200*3.0857f, 150*6.4);
		Room  R3  = new Room("Stock Room", 0*6.4, 200*3.0857, 150*3.0857f, 150*6.4);
		Room  R4  = new Room("Delivery Room", 150*6.4, 250*3.0857, 100*3.0857f, 150*6.4);
		
		
		
		Area  A1  = new Area("Packaging Area", 10*6.4, 125*3.0857, 65*3.0857, 65*6.4, 0);
		Area  A3  = new Area("Stock Area", 10*6.4, 270*3.0857, 70*3.0857, 85*6.4, 0);
		Area  A2  = new Area("Sorting Area", 185*6.4, 80*3.0857, 100*3.0857, 60*6.4, 0);
		Area  A4  = new Area("Delivery Area", 242*6.4, 273*3.0857, 55*3.0857, 55*6.4, 0);
		Area  A5  = new Area("Costumer Area", 257*6.4, 5*3.0857, 45*3.0857, 45*6.4, 0);
		
		
		
		ProductionUnite P1 = new ProductionUnite("Production Unite", 30*6.4, 60*3.0857, 80*3.0857, 20*6.4, false);
		ChargingPoint charg1 = new ChargingPoint("Charging Point 1", 180*6.4, 315*3.0857, 30*3.0857, 35*6.4, false);
		ChargingPoint charg2 = new ChargingPoint("Charging Point 2", 133.5*6.4, 58*3.0857, 70*3.0857, 15*6.4, false);
		
		
		
		ConvoyerBand  Conv1  = new ConvoyerBand("Convoyer 1", 275*6.4, 40*3.0857, 110*3.0857, 20*6.4, 0, false, 0);
		ConvoyerBand  Conv2  = new ConvoyerBand("Convoyer 2", 275*6.4, 155*3.0857, 118*3.0857, 20*6.4, 0, false, 0);
		
		
		
		Door D1 = new Door("1", 149.3*6.4, 130*3.0857, 65*3.0857, 2*6.4, false);
		Door D2 = new Door("", 160*6.4, 248*3.0857, 4*3.0857, 50*6.4, false);
		Door D3 = new Door("", 149.3*6.4, 270*3.0857, 70*3.0857, 2*6.4, false);
		Door D4 = new Door("", 85*6.4, 198*3.0857, 4*3.0857, 55*6.4, false);
		Door D5 = new Door("", 85*6.4, 48*3.0857, 4*3.0857, 40*6.4, false);
		
		/*
		 * these are not flag i juste use it to make the bakcground of door orange when its opening
		 * */
		MarocPart2 par1 = new MarocPart2("",149.3*6.4,130*3.0857,65*3.0857,2*6.4,241,192,85);
		MarocPart2 par2 = new MarocPart2("",160*6.4,248*3.0857,4*3.0857,50*6.4,241,192,85);
		MarocPart2 par3 = new MarocPart2("",149.3*6.4,270*3.0857,70*3.0857,2*6.4,241,192,85);
		MarocPart2 par4 = new MarocPart2("",85*6.4,198*3.0857,4*3.0857,55*6.4,241,192,85);
		MarocPart2 par5 = new MarocPart2("",85*6.4,48*3.0857,4*3.0857,40*6.4,241,192,85);
	
		
		
		ArrayList<Component> destinationRb1 = new ArrayList<Component>();destinationRb1.add(A3);destinationRb1.add(A2);destinationRb1.add(A4);destinationRb1.add(A5);
		ArrayList<Component> destinationRb2 = new ArrayList<Component>();destinationRb2.add(A3);destinationRb2.add(A2);destinationRb2.add(A3);destinationRb2.add(A5);destinationRb2.add(A1);destinationRb2.add(A3);
		ArrayList<Component> destinationRb3 = new ArrayList<Component>();destinationRb3.add(A3);destinationRb3.add(A2);destinationRb3.add(A4);destinationRb1.add(A5);
		
		
		Robot rb1 = new Robot("Rb1", 150*6.4, 20*3.0857, 7.5*3.0857, 7.5*6.4, 1, 15000, false, false,destinationRb1,null) ;
		Robot rb2 = new Robot("Rb2", 160*6.4, 200*3.0857, 7.5*3.0857, 7.5*6.4, 2, 15000, false, false,destinationRb2,null);
		Robot rb3 = new Robot("Rb3", 120*6.4, 250*3.0857, 7.5*3.0857, 7.5*6.4, 3, 15000, false, false,destinationRb3,null);
		
	
		
		Point a1 = new Point ((27+19)*6.4, (25+10)*3.0857);
		Point a2 = new Point ((31+19)*6.4, 10*3.0857);
		Point a3 = new Point ((37+19)*6.4, (25+10)*3.0857);
		Point a4= new Point ((24+19)*6.4, (9+10)*3.0857);
		Point a5 = new Point ((39+19)*6.4, (9+10)*3.0857);
		Point a6 = new Point ((27+19)*6.4, (25+10)*3.0857);
		
		Set<Vertex> points = new LinkedHashSet<Vertex>();
		points.add(a1);
		points.add(a2);
		points.add(a3);
		points.add(a3);
		points.add(a4);
		points.add(a5);
		points.add(a6);
		
		MarocPart pr1 = new MarocPart("",0,0,0,0,points,0,0,0);
		MarocPart2 pr2 = new MarocPart2("",30*6.4,1*3.0857,50*3.0857,42*6.4,206,17,38);
		
		
		Collection<Figure> component = new LinkedList<>();
		
		component.add(R1);
		component.add(R2);
		component.add(R3);
		component.add(R4);
		component.add(A1);
		component.add(A2);
		component.add(A3);
		component.add(A4);
		component.add(A5);
		component.add(P1);
		component.add(charg1);
		component.add(charg2);
		component.add(Conv1);
		component.add(Conv2);
		component.add(par1);
		component.add(par2);
		component.add(par3);
		component.add(par4);
		component.add(par5);
		component.add(D1);
		component.add(D2);
		component.add(D3);
		component.add(D4);
		component.add(D5);
		component.add(rb1);
		component.add(rb2);
		component.add(rb3);
		component.add(pr2);
		component.add(pr1);
		
		TrajectoryFind dij = new TrajectoryFind();
		dij.maillageGeneration();
		dij.edgesGeneration();
		
		rb1.setFinder(dij);
		
		ArrayList<Observer> observers = new ArrayList<>();
		
		
		
		
		Factory usine = new Factory("UsineAGOUZAL", 1920,1080 , component, 0, 0, observers,"69");
		
		usine.identifyComponent(); 
		
	
		FileCanvasChooser chooser = new FileCanvasChooser("C:/Users/fatim/eclipse-workspace","1");
		CanvasPersistenceManager persiste = new CanvasPersistenceManager(chooser);
		SimulationController animationUsine = new SimulationController(usine,persiste);
		CanvasViewer  affichage = new CanvasViewer(animationUsine);
		usine.addObserver(affichage);
	}

}
