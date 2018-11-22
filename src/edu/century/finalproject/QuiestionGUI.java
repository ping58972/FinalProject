package edu.century.finalproject;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	BTNode node;
	JLabel lblNewLabel;
	JButton btnNewButton, btnNo;
	/**
	 * Create the frame.
	 * @param <T>
	 */
	public QuiestionGUI(BTNode data) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("YES");
		
				
		btnNo = new JButton("NO");
		btnNo.addActionListener(this);
		btnNewButton.addActionListener(this);
		
		if (data.getLeft() !=null || data.getRight() != null) {
			lblNewLabel = new JLabel(data.getData().toString());
			
		}else {
			
			btnNo.setEnabled(false);
			btnNewButton = new JButton("Open_PDF");
			btnNewButton.addActionListener(this);
			//btnNewButton.setEnabled(false);
			DriverGUI.pdf.close(data.getData().toString());
			lblNewLabel = new JLabel("No more Quiestion!");
			//DriverGUI.pdf.openPDF();
		}
		
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		panel.add(btnNewButton);
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
			DriverGUI.pdf.add(node.getData().toString(), "Yes");
			new QuiestionGUI(node.getLeft());
		}
		if(command.equals("NO")) {
			DriverGUI.pdf.add(node.getData().toString(), "No");
			new QuiestionGUI(node.getRight());
		}
		if(command.equals("Open_PDF")) {
			
			DriverGUI.pdf.openPDF();
		}
	}

}
