package GUI;
/**public class MainGUI from the package GUI
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  VeteranEmail.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 12/06/2018
 * */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
public class MainGUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField firstName_Field;
	private JTextField lastName_Field;
	private JTextField email_Field;
	private Button button;
	static String firstName;
	static String lastName;
	static String email;	
	int xx,xy;	
	static String[] arg;
	JLabel label_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					MainGUI frame = new MainGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		arg = args;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		firstName = firstName_Field.getText();
		lastName = lastName_Field.getText();
		email = email_Field.getText();
		if(!firstName.equals("") && !lastName.equals("") && !email.equals("")) {
			
		VeteranBenefitsApplication.launch(arg, this);
		}
		if(firstName.equals("") || lastName.equals("") || email.equals("")) {
		label_1.setText("Please Enter Your Collect Information!");
		}
		
	}
}
