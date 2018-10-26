package edu.century.finalproject;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class VeteranServicesGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String h="Have you served on Active Duty for purposes other than training?";
		String q1="Other flowcharts";
		String q2="Did you receive an honorable " + 
				"discharge?";
		String q3="Did you serve for at least 90" + 
				"days of aggregate Active Duty" + 
				"after Sept. 11, 2001?";
		String q4="AD3 - Did you recieve a " + 
				"discharge that was other than" + 
				"honorable?";
		String q5 ="Do you have a service " + 
				"connected disability of at least" + 
				"20% rating?";
		String q6 ="Were you discharged with a " + 
				"service connected disability" + 
				"after 30 days of service?";
		
		VateranDataStruc<String> veteran = new VateranDataStruc<>(h);
		veteran.add(h, q2, q1);
		veteran.add(q2, q3, q4);
		veteran.add(q3, q5, q6);
		System.out.println("Hello World!!!!");
		//veteran.printOut();
	
		
		
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeteranServicesGUI window = new VeteranServicesGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 */
	public VeteranServicesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
