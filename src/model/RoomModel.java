package model;

public class RoomModel {

	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	public RoomModel(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}

	public Boolean containsCoordinates(int x, int y) {
		if (xPos < x && xPos + width > x && yPos < y && yPos + height > y) {
			return true;
		}
		return false;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getX() {
		return xPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}
	
	
	public int getY() {
		return yPos;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
