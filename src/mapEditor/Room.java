package mapEditor;

import java.awt.Color;
import java.awt.Graphics;

import model.RoomModel;

public class Room {

	private RoomModel roomModel;
	private Color colour;
	private boolean isSelected;

	public Room(int xPos, int yPos, int width, int height) {
		roomModel = new RoomModel(xPos, yPos, width, height);
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public Color getColour() {
		return colour;
	}

	public boolean getIsSelected() {
		return isSelected;
	}
	
	public RoomModel getModel() {
		return roomModel;
	}

	public void paintSquare(Graphics g) {
		g.setColor(colour);
		g.fillRect(roomModel.getX(), roomModel.getY(), roomModel.getWidth(), roomModel.getHeight());
		if (isSelected) {
			g.setColor(Color.BLUE);
		}
		else {
			g.setColor(Color.BLACK);
		}
		g.drawRect(roomModel.getX(), roomModel.getY(), roomModel.getWidth(), roomModel.getHeight());
	}

}
