package mapEditor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Map extends JPanel implements MouseMotionListener, MouseListener {

	private ArrayList<Room> rooms;
	private Room selectedRoom;

	private static final long serialVersionUID = -4761389846458857635L;

	public Map() {
		setBorder(BorderFactory.createLineBorder(Color.black));

		Room redSquare = new Room(50, 50, 50, 50);
		Room blueSquare = new Room(100, 100, 50, 50);

		redSquare.setColour(Color.RED);
		blueSquare.setColour(Color.BLUE);
		
		rooms = new ArrayList<Room>();
		rooms.add(redSquare);
		rooms.add(blueSquare);

		addMouseListener(this);

		addMouseMotionListener(this);
	}

	public void mouseDragged(MouseEvent e) {
		moveRoom(e.getX(), e.getY());
	}

	public void mousePressed(MouseEvent e) {
		selectedRoom = getSelectedRoom(e.getX(), e.getY());
	}
	
	private Room getSelectedRoom(int x, int y) {
		Room selectedRoom = null;
		for(int index=0; index<rooms.size(); index++) {
			if(rooms.get(index).containsCoordinates(x,  y)) {
				selectedRoom = rooms.get(index);
			}
		}
		
		return selectedRoom;
	}

	private void moveRoom(int x, int y) {
		
		Room currentRoom = selectedRoom;
		//offset is so we don't get little bits of the room left behind when dragging it
		int OFFSET = 2;
		
		int currentX = currentRoom.getX();
		int currentY = currentRoom.getY();
		int width = currentRoom.getWidth();
		int height = currentRoom.getHeight();

		if ((currentX != x) || (currentY != y)) {

			// The square is moving, repaint background
			// over the old square location.
			repaint(currentX, currentY, width + OFFSET, height + OFFSET);

			// Update coordinates.
			currentRoom.setX(x);
			currentRoom.setY(y);

			// Repaint the square at the new location.
			repaint(x, y, width, height);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(1000, 800);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for(Room room : rooms) {
			room.paintSquare(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
