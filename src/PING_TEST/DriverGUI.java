package PING_TEST;

/**public class DriverGUI from the package PING_TEST
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  BTNode.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 10/20/2018
 * */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;


public class DriverGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private static JFileChooser fileChooser = new JFileChooser();
	private JLabel lblNewLabel;
	private JButton btnStart;
	
	public DriverGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Browse");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
		panel.add(btnStart);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		lblNewLabel = new JLabel("Wellcome to Veteran Quiestion!");
		panel_1.add(lblNewLabel);
		btnStart.setEnabled(false);
		setVisible(true);
	}
/*public static void main(String[] args) {
				
	DriverGUI driver = new DriverGUI();
	}*/

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//btnNewButton.setEnabled(true);
	String command = e.getActionCommand();
	if(command.equals("Browse")) {
	 				
	if(fileChooser.showOpenDialog(null)==fileChooser.APPROVE_OPTION) {
		textField.setText(fileChooser.getSelectedFile().getName());
		//simpleParser.init(fileChooser.getSelectedFile());
		//lblNewLabel.setText("");
		lblNewLabel.setText("Please...Click the Start button!");
		//btnNewButton.setEnabled(false);
		btnStart.setEnabled(true);
	}else {
		//lblNewLabel.setText("");
		lblNewLabel.setText("Please...Choosing a correct path and file!");
		btnStart.setEnabled(false);
	}
	}
	if(command.equals("Start")) {
		lblNewLabel.setText("Please...Click the Browse button!");
		readCSV();
	}
	
	
}

public void readCSV() {
	ArrayList<String[]> arr2D = new ArrayList<>();
	BTNode veteran;
	try {
		
		Scanner read = new Scanner(fileChooser.getSelectedFile());
		final int size = 4;
		while(read.hasNextLine()) {
		String[] line = new String[size];
		String lineCSV = read.nextLine();
		String [] csvL =lineCSV.split(",");
		for (int i=0; i < csvL.length; i++) {
			line[i] = csvL[i];
		}
	
		arr2D.add(line);	
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	veteran = new BTNode(arr2D.get(0)[0], arr2D.get(0)[1]);
	//System.out.println(arr2D.get(0)[0]);
	for(String[] rows : arr2D) {
		if(rows[2]!=null && rows[3] != null) {
		String leftData = "";
		String rightData = "";
		for(String[] rowf : arr2D) {
			if(rows[2].equals(rowf[0])){
				leftData = rowf[1];
			}
			if(rows[3].equals(rowf[0])){
				rightData = rowf[1];
			}
		}
		
		veteran.insert(rows[0], rows[2], leftData, rows[3], rightData);
		}
	}
	//veteran.printAll();
			//veteran.printYN();
			QuiestionGUI frame = new QuiestionGUI(veteran);
			if(veteran.getData()==null) {
				 setVisible(true);
			}
}

	
}
