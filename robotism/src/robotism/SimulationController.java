package robotism;

import java.io.IOException;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observable;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;

public class SimulationController implements CanvasViewerController {
	private CanvasPersistenceManager persistence ; 
	private Canvas factory;

	public SimulationController( Factory factory,CanvasPersistenceManager persistence) {
		this.persistence = persistence;
		this.factory=factory;

	}

	@Override
	public boolean addObserver(Observer observer) {
		
		return ((Factory) factory).addObserver(observer);
	}

	@Override
	public boolean removeObserver(Observer observer) {

		return ((Factory) factory).removeObserver(observer);
	}
/*
	@Override
	public Canvas read(String canvasId) throws IOException {
		// TODO Auto-generated method stub
		return this.factory;
	}
*/
/*	@Override
	public void persist(Canvas canvasModel) throws IOException {
		// TODO Auto-generated method stub

	}*/
/*
	@Override
	public boolean delete(Canvas canvasModel) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}
*/
	@Override
	public Canvas getCanvas() {

		return this.factory;
	}

	@Override
	public void startAnimation() {
		((Factory) factory).startSimulation();
		while (((Factory) factory).isSimulationStarted()) {
			((Factory) factory).behave();
			try {
				Thread.sleep( 200 );
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			}
	}

	@Override
	public void stopAnimation() {
		((Factory) factory).stopSimulation();

	}

	@Override
	public boolean isAnimationRunning() {
		// TODO Auto-generated method stub
		return ((Factory) factory).isSimulationStarted();
	}

	@Override
	public void setCanvas(Canvas canvasModel) {
		this.factory = canvasModel;
	}

	@Override
	public CanvasPersistenceManager getPersistenceManager() {
		// TODO Auto-generated method stub
		return this.persistence;
	}

}
