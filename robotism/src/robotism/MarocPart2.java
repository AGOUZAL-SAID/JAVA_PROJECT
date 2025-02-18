package robotism;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public class MarocPart2 extends Component {
	private static final long serialVersionUID = 9992;
	private int R ; 
	private int G ; 
	private int B ;

	protected MarocPart2(String name, double positionX, double positionY, double length, double width,int R,int G,int B) {
		super(name, positionX, positionY, length, width);
		this.R = R ; 
		this.G = G ; 
		this.B = B ; 
	}


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
		BasicColor couleurRobot = new BasicColor(R,G,B);
		BasicColor couleurContorRobot = new BasicColor(R,G,B);
		BasicStroke strockRobot = new BasicStroke(couleurContorRobot,0.5f,null) ;
		
		return new BasicStyle(couleurRobot,strockRobot);
	}
	
	@Override
	 public Shape getShape() {
		 return new BasicRectangleShape( (int)width , (int)length );}

	
	
	
	
}
