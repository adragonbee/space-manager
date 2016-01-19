package model;

public class DoorModel {

	private int xPos;
	private int yPos;
	private int width;
	
	public DoorModel(int x, int y, int width) {
		this.xPos = x;
		this.yPos = y;
		this.width = width;
	}
	
	public int getxPos() {
		return xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

}
