package robotism;

import java.util.Set;

import fr.tp.inf112.projects.canvas.model.Color;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;
import fr.tp.inf112.projects.canvas.model.Vertex;

public class MarocPart  extends Component{
	private static final long serialVersionUID = 9999;
	private Set<Vertex> points;


	MarocPart(String name, double positionX, double positionY, double length, double width,Set<Vertex> points,int R,int G,int B) {
		super(name, positionX, positionY, length, width);
		this.points=points ; 

	}

	@Override
	 public Shape getShape() {
		 return new BasicPolygoneShape(points);}
	
	@Override
	public int getxCoordinate() {
		return (int) this.positionX ;
	}

	@Override
	public int getyCoordinate() {
		return (int) this.positionY;
	}

	@Override
	public Style getStyle() {
		BasicColor couleurFlag = new BasicColor(0,0,0);
		BasicColor couleurContorFlag = new BasicColor(70,230,0);
		BasicStroke strockRobot = new BasicStroke(couleurContorFlag,4f,null) ;
		return new BasicStyle(couleurFlag,strockRobot);
	}
	
	public Color getColor() {
		return new BasicColor(255,255,255);
	}
}
