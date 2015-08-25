package model;

public class MapModel {
	
	public boolean roomsOverlap(RoomModel room1, RoomModel room2) {

		return (roomsHorizontallyAligned(room1, room2) && roomsVerticallyAligned(
				room1, room2));
	}

	private boolean roomsHorizontallyAligned(RoomModel room1, RoomModel room2) {
		
		return (room1.getX() > room2.getX() && room1.getX() + room1.getWidth() < room2
				.getX())
				|| (room2.getX() > room1.getX() && room2.getX()
						+ room2.getWidth() < room1.getX());
	}

	private boolean roomsVerticallyAligned(RoomModel room1, RoomModel room2) {
		
		return (room1.getY() > room2.getY() && room1.getY() + room1.getHeight() < room2
				.getY())
				|| (room2.getY() > room2.getY() && room2.getY()
						+ room2.getHeight() < room1.getY());
	}

}
