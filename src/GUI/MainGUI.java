package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class MainGUI extends JFrame implements ActionListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**public class MainGUI from the package GUI
	 *
	 *  Century College, CSCI 2082 Fall 2018.
	 *  VeteranEmail.java, Programming Final Project.
	 *
	 *  @author (Ping) Nalongsone Danddank, Sean and Will
	 *  @version 1.0
	 *  @since 12/06/2018
	 * */
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
	public MainGUI() {
		setUndecorated(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 729, 476);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 xx = e.getX();
			     xy = e.getY();
			}
		});

		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {

				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            MainGUI.this.setLocation(x - xx, y - xy);
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("VETERAN SERVIVES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(96, 305, 173, 27);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {

				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            MainGUI.this.setLocation(x - xx, y - xy);
			}
		});
		label.setBounds(-38, 0, 420, 275);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon("veterans500.jpg"));
		panel.add(label);

		JLabel lblWeGotYou = new JLabel("....Wellcome to Century College....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(71, 343, 225, 27);
		panel.add(lblWeGotYou);

		button = new Button("Start");
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(395, 363, 283, 36);


		firstName_Field = new JTextField();
		firstName_Field.setBounds(395, 83, 283, 36);
		contentPane.add(firstName_Field);
		firstName_Field.setColumns(10);

		JLabel lblUsername = new JLabel("FIRST NAME");
		lblUsername.setBounds(395, 58, 114, 14);
		contentPane.add(lblUsername);

		JLabel lblEmail = new JLabel("LAST NAME");
		lblEmail.setBounds(395, 132, 150, 14);
		contentPane.add(lblEmail);

		lastName_Field = new JTextField();
		lastName_Field.setColumns(10);
		lastName_Field.setBounds(395, 157, 283, 36);
		contentPane.add(lastName_Field);

		JLabel lblPassword = new JLabel("EMAIL");
		lblPassword.setBounds(395, 204, 96, 14);
		contentPane.add(lblPassword);


		email_Field = new JTextField("example@email.com");
		email_Field.setColumns(10);
		email_Field.setBounds(395, 229, 283, 36);
		contentPane.add(email_Field);


		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);

		label_1 = new JLabel("Click Start Button When You Ready!");
		label_1.setBounds(427, 299, 225, 14);
		contentPane.add(label_1);
		button.addActionListener(this);
		contentPane.add(button);
		setContentPane(contentPane);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		firstName = firstName_Field.getText();
		lastName = lastName_Field.getText();
		email = email_Field.getText();
		if(!firstName.equals("") && !lastName.equals("") && !email.equals("")&& !email.equals("example@email.com")) {

		VeteranBenefitsApplication.launch(arg, this);
		}
		if(firstName.equals("") || lastName.equals("") || email.equals("") || email.equals("example@email.com")) {
		label_1.setText("Please Enter Your Collect Information and Email!");
		}

	}
}
