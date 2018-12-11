package PING_TEST;
/**public class QuiestionGUI from the package PING_TEST
 * 
 *  Century College, CSCI 2082 Fall 2018.
 *  QuiestionGUI.java, Programming Final Project.
 *  
 *  @author (Ping) Nalongsone Danddank
 *  @version 1.0
 *  @since 10/20/2018
 * */
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class QuiestionGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	BTNode node;
	JLabel lblNewLabel;
	
	/*public QuiestionGUI(BTNode data)
	 * @Descriptions 
	 * 		to construct QuiestionGUI class. 
	 * @Parameter: 
	 * @Precondition :
	 * @Postcondition
	 * @Return
	 * @Thorws
	 * */
	public QuiestionGUI(BTNode data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		if (data !=null) {
			lblNewLabel = new JLabel(data.getData().toString());		
		}else
			lblNewLabel = new JLabel("No more Quiestion!");	
		contentPane.add(lblNewLabel, BorderLayout.CENTER);	
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);		
		JButton btnNewButton = new JButton("YES");
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);		
		JButton btnNo = new JButton("NO");
		btnNo.addActionListener(this);
		panel.add(btnNo);
		this.node = data;
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		setVisible(false);
		
		if(command.equals("YES")) {
			
			new QuiestionGUI(node.getLeft());
		}
		if(command.equals("NO")) {
			
			new QuiestionGUI(node.getRight());
		}
		
	}

}
