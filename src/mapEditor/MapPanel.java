package mapEditor;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MapPanel extends JPanel {

	private static final long serialVersionUID = 3259744026011490230L;
	private ArrayList<Room> rooms;
	
	public MapPanel(ArrayList<Room> rooms) {
		setBorder(BorderFactory.createLineBorder(Color.black));
		this.rooms = rooms;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Room room : rooms) {
			room.paintSquare(g);
		}
	}

}
