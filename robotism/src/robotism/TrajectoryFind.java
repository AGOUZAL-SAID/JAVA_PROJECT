package robotism;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.graph.WeightedPseudograph;

import fr.tp.inf112.projects.canvas.model.Figure;
import fr.tp.inf112.projects.graph.DijkstraAlgorithm;
import fr.tp.inf112.projects.graph.Vertex;
import fr.tp.inf112.projects.graph.impl.BasicVertex;
import fr.tp.inf112.projects.graph.impl.GridEdge;
import fr.tp.inf112.projects.graph.impl.GridGraph;
import fr.tp.inf112.projects.graph.impl.GridVertex;

public class TrajectoryFind implements FactoryPathFinder {
	
	private static int[][] wall1= {{0,(int) (95*6.4)},{(int) (35*3.08),(int) (65*3.8)}};
	private static int[][] wall2= {{(int) (110*6.4),1920},{(int) (35*3.08),(int) (65*3.8)}};
	private static int[][] wall3= {{(int) (140*6.4),(int) (160*6.4)},{(int) (50*3.08),(int) (130*3.8)}};
	private static int[][] wall4= {{(int) (140*6.4),(int) (170*6.4)},{(int) (170*3.08),(int) (270*3.8)}};
	private static int[][] wall5= {{(int) (200*6.4),1920},{(int) (228*3.08),(int) (250*3.8)}};
	private static int[][] wall6= {{0,(int) (95*6.4)},{(int) (185*3.08),(int) (200*3.8)}};
	private static int[][] wall7= {{(int) (130*6.4),(int) (160*6.4)},{(int) (180*3.08),(int) (220*3.8)}};
	private static int[][] wall8= {{(int) (120*6.4),(int) (180*6.4)},{(int) (320*3.08),(int) (350*3.8)}};
	private static int taillepixel = 1;
	private WeightedPseudograph<Position, DefaultWeightedEdge> graph ;
	private ArrayList<ArrayList<Position>> pixels;
	private ArrayList<Position> addedPositions;
	/*
	 * generation of noeuds
	 * */
	public void maillageGeneration(){
		WeightedPseudograph<Position, DefaultWeightedEdge> maillage = new WeightedPseudograph<>(DefaultWeightedEdge.class);
		ArrayList<ArrayList<Position>> matriceMaillage = new ArrayList<ArrayList<Position>>()  ;
		ArrayList<Position> positions = new ArrayList<Position>();
		int k = 0;
		for (int y = 1; y < 1080; y +=(int)(3.08*taillepixel)) {
			ArrayList<Position> ligne = new ArrayList<Position>() ;	
            for (int x = 1; x < 1920; x +=(int) (6.4*taillepixel)) {
            	int i =0;
            	//maillage.add(new Position((int)x,(int) y));
            	if (x>this.wall1[0][0]&& x<this.wall1[0][1] && y>this.wall1[1][0] && y<this.wall1[1][1]){
            		i=1;
            	}
            	if (x>this.wall2[0][0]&& x<this.wall2[0][1] && y>this.wall2[1][0] && y<this.wall2[1][1]){
            		i=1;
            	}
            	if (x>this.wall3[0][0]&& x<this.wall3[0][1] && y>this.wall3[1][0] && y<this.wall3[1][1]){
            		i=1;
            	}
            	if (x>this.wall7[0][0]&& x<this.wall7[0][1] && y>this.wall7[1][0] && y<this.wall7[1][1]){
            		i=1;
            	}
            	if (x>this.wall8[0][0]&& x<this.wall8[0][1] && y>this.wall8[1][0] && y<this.wall8[1][1]){
            		i=1;
            	}
            	if (x>this.wall4[0][0]&& x<this.wall4[0][1] && y>this.wall4[1][0] && y<this.wall4[1][1]){
            		i=1;
            	}
            	if (x>this.wall5[0][0]&& x<this.wall5[0][1] && y>this.wall5[1][0] && y<this.wall5[1][1]){
            		i=1;
            	}
            	if (x>this.wall6[0][0]&& x<this.wall6[0][1] && y>this.wall6[1][0] && y<this.wall6[1][1]){
            		i=1;
            	}
            	if (i==0) {
            		Position a = new Position("a"+k,(int)x,(int)y);
            		ligne.add(a);
            		k+=1;
            		maillage.addVertex(a);
            		positions.add(a);
            	
            	}
            	else {
            		ligne.add(null);
            		k+=1;
            	}          		
            
            }
            matriceMaillage.add(ligne);
        }
		
		this.graph = maillage;
		this.pixels=matriceMaillage;
		this.addedPositions = positions;
	}
/*
 * generation of arrets 
 * */
	public void edgesGeneration() {
		int l = this.pixels.size();
		int c = this.pixels.get(0).size();
		for (int i=0; i< l;i++ ) {
			for (int j=0 ; j<c;j++) {
				if (this.pixels.get(i).get(j)!= null ) {
					if(j+1<c) {
						if(this.pixels.get(i).get(j+1)!= null) {
							//add arret verticale
							graph.setEdgeWeight(graph.addEdge(this.pixels.get(i).get(j), this.pixels.get(i).get(j+1)), (int) (6.4*taillepixel));
						}
					}
					if(i+1<l) {
						if(this.pixels.get(i+1).get(j)!= null) {
							//add arret verticale 
							graph.setEdgeWeight(graph.addEdge(this.pixels.get(i).get(j), this.pixels.get(1+i).get(j)), (int)(3.08*taillepixel));

						}
						
					
						
					}
				    if(i+1<l && j+1<c )	{
				    	if(this.pixels.get(i+1).get(j+1)!= null) {
				    		int t = (int)Math.pow(this.pixels.get(i).get(j).getPositionX()-this.pixels.get(i+1).get(j+1).getPositionX(), 2);
							int u = (int)Math.pow(this.pixels.get(i).get(j).getPositionY()-this.pixels.get(i+1).get(j+1).getPositionY(), 2);
							int distance = (int) Math.pow(t+u, 0.5);
							//add arret diagonale down
				    		graph.setEdgeWeight(graph.addEdge(this.pixels.get(i).get(j), this.pixels.get(1+i).get(j+1)), distance);	
				    	}
				    	
				    }
				    if(i-1>0 && j+1<c )	{
				    	if(this.pixels.get(i-1).get(j+1)!= null) {
				    		int t = (int)Math.pow(this.pixels.get(i).get(j).getPositionX()-this.pixels.get(i-1).get(j+1).getPositionX(), 2);
							int u = (int)Math.pow(this.pixels.get(i).get(j).getPositionY()-this.pixels.get(i-1).get(j+1).getPositionY(), 2);
							int distance = (int) Math.pow(t+u, 0.5);
							//add arret diagonale Up
				    		graph.setEdgeWeight(graph.addEdge(this.pixels.get(i).get(j), this.pixels.get(-1+i).get(j+1)), distance);	
				    	}
				    	
				    }
				}
				
				
			}
		}
	}
	public TrajectoryFind() {
	}

	@Override
	public List<Position> findPath(Robot robot, Component destinations) {
		Position a = approximation(robot);
		Position b = approximation(destinations);
		DijkstraShortestPath<Position, DefaultWeightedEdge> dijkstraAlg = new DijkstraShortestPath<>(graph);
		List<Position> shortestPath = dijkstraAlg.getPath(a, b).getVertexList();
		
		return shortestPath;
			
		
	}
	/*
	 * found theclosest noeud to component
	 * */
	
	public Position approximation(Component position) {
		
		int a = 200000000;
		Position ver = null;
		for (Position makan : this.addedPositions) {
			int t = (int)Math.pow(makan.getPositionX()-position.getCoordinateX(), 2);
			int u = (int)Math.pow(makan.getPositionY()-position.getCoordinateY(), 2);
			int distance = (int) Math.pow(t+u, 0.5);
			if (distance <= a ) {
				a = distance;
				ver =  makan;
				
			}
		}
		return ver;	
		}
}
