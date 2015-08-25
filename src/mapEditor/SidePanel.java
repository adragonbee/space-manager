package mapEditor;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SidePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -3049526019239966839L;
	private MapWindow map;
	
	public SidePanel(MapWindow map) {
		this.map = map;
		Button canteenButton = new Button("Add Canteen");
		Button hydroponicsButton = new Button("Add Hydroponics");
		addButton(canteenButton);
		addButton(hydroponicsButton);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "Add Canteen"){
			map.addRoom(new Canteen(20, 20));		
		}
		else {
			map.addRoom(new Hydroponics(30, 30));
		}
		
	}
	
	private void addButton(Button button) {
		button.addActionListener(this);
		add(button);
	}

}
