package mapEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.RoomModel;

public class MapWindow extends JPanel implements MouseMotionListener, MouseListener {

	private ArrayList<Room> rooms;
	private Room selectedRoom;
	private SidePanel sidePanel;
	private MapPanel mapPanel;

	private static final long serialVersionUID = -4761389846458857635L;

	public MapWindow() {

		rooms = new ArrayList<Room>();
		mapPanel = new MapPanel(rooms);
		sidePanel = new SidePanel(this);
		mapPanel.addMouseListener(this);
		mapPanel.addMouseMotionListener(this);
		
		this.setLayout(new BorderLayout());
		this.add(mapPanel, BorderLayout.CENTER);
		this.add(sidePanel, BorderLayout.EAST);
	}

	public void addRoom(Room room) {
		rooms.add(room);
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1000, 800);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		moveRoom(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		selectedRoom = getSelectedRoom(e.getX(), e.getY());
		if(selectedRoom != null){
			DeselectAllRooms();
			selectedRoom.setIsSelected(true);
		}
		repaint();
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
	
	private void DeselectAllRooms() {
		for(Room room : rooms) {
			room.setIsSelected(false);
		}
	}

	private Room getSelectedRoom(int x, int y) {
		Room selectedRoom = null;
		for (int index = 0; index < rooms.size(); index++) {
			if (rooms.get(index).getModel().containsCoordinates(x, y)) {
				selectedRoom = rooms.get(index);
			}
		}

		return selectedRoom;
	}

	private void moveRoom(int x, int y) {

		RoomModel currentRoom = selectedRoom.getModel();
		// offset is so we don't get little bits of the room left behind when
		// dragging it
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

}
