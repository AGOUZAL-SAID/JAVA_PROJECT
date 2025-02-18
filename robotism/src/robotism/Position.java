package robotism;

import java.io.Serializable;

public class Position{
	private int positionX;
	private int positionY;
	private String label;

	public Position(String label ,int positionX,int positionY) {
		this.positionX=positionX;
		this.positionY=positionY;
		this.label=label;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}



	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Position [positionX=" + positionX + ", positionY=" + positionY + ", label=" + label + "]";
	}

}
