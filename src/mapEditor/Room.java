package mapEditor;

import java.awt.Color;
import java.awt.Graphics;

public class Room {

	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color colour;

	public Room(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	public Boolean containsCoordinates(int x, int y) {
		if(xPos < x && xPos + width > x && yPos < y && yPos + height > y) {
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
	
	public void setColour(Color colour) {
		this.colour = colour;
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

	public Color getColour() {
    	return colour;
    }

	public void paintSquare(Graphics g) {
		g.setColor(colour);
		g.fillRect(xPos, yPos, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(xPos, yPos, width, height);
	}

}
