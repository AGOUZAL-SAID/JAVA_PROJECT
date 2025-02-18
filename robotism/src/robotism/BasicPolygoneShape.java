package robotism;

import java.util.Set;

import fr.tp.inf112.projects.canvas.model.PolygonShape;
import fr.tp.inf112.projects.canvas.model.Vertex;

/**
 * Represents a basic polygon shape with a set of points.
 */
public class BasicPolygoneShape implements PolygonShape {
	private static final long serialVersionUID = 9632;

    /**
     * The set of points that make up the polygon.
     */
    private Set<Vertex> points;

    /**
     * Constructs a new BasicPolygoneShape instance with the given set of points.
     * 
     * @param points the set of points that make up the polygon
     * @throws IllegalArgumentException if the set of points is null
     */
    public BasicPolygoneShape(Set<Vertex> points) {
        // Validate the set of points
        if (points == null) {
            throw new IllegalArgumentException("Set of vertices cannot be null.");
        }
        this.points = points;
    }

    /**
     * Adds a point to the polygon.
     * 
     * @param point the point to add
     * @return true if the point was added, false otherwise
     */
    public boolean addVertices(Vertex point) {
        return points.add(point);
    }

    /**
     * Removes a point from the polygon.
     * 
     * @param point the point to remove
     * @return true if the point was removed, false otherwise
     */
    public boolean removeVertices(Vertex point) {
        return points.remove(point);
    }

    /**
     * Returns the set of points that make up the polygon.
     * 
     * @return the set of points
     */
    @Override
    public Set<Vertex> getVertices() {
        return this.points;
    }
}