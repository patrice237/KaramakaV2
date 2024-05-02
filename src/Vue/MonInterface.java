package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class MonInterface {

	private JFrame frame;
	private JTextField nomJ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface window = new MonInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MonInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 0));
		frame.setBounds(100, 100, 730, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bntPouvoir = new JButton("POUVOIR");
		bntPouvoir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntPouvoir.setBounds(47, 384, 149, 162);
		frame.getContentPane().add(bntPouvoir);
		
		JButton bntVieFuture = new JButton("VIE FUTURE");
		bntVieFuture.setBounds(295, 384, 149, 162);
		frame.getContentPane().add(bntVieFuture);
		
		nomJ = new JTextField();
		nomJ.setBounds(295, 11, 120, 29);
		frame.getContentPane().add(nomJ);
		nomJ.setColumns(10);
		
		JButton btnPoint = new JButton("POINT");
		btnPoint.setBounds(538, 384, 149, 162);
		frame.getContentPane().add(btnPoint);
	}
}
