package robotism;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;
import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;

public class CanvasPersistenceManager extends AbstractCanvasPersistenceManager {
    private static final String STORAGE_DIRECTORY = "C:/Users/fatim/eclipse-workspace/"; // Chemin vers le répertoire de stockage

    private final Map<String, Canvas> canvasCache;

    public CanvasPersistenceManager(final CanvasChooser canvasChooser) {
    	super(canvasChooser);
        this.canvasCache = new HashMap<>();
    }

    @Override
    public Canvas read(String canvasId) throws IOException {
        try {
        	FileInputStream fileInputStream = new FileInputStream(canvasId);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Canvas) objectInputStream.readObject();
        }
        catch (ClassNotFoundException | FileNotFoundException e) {
            throw new IOException("Failed to read canvas from storage.", e);
        }
    }

    @Override
    public void persist(Canvas canvasModel) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(STORAGE_DIRECTORY + canvasModel.getName());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(canvasModel);
        
    }

    @Override
    public boolean delete(Canvas canvasModel) throws IOException {
        File file = new File(STORAGE_DIRECTORY );
        return file.delete();
    }


}