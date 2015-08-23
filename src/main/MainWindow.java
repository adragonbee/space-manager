package main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import mapEditor.Map;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7509764308609412560L;

	public MainWindow(String name) {
		super(name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		Map map = new Map();
		add(map, BorderLayout.CENTER);
		pack();
	}

}
