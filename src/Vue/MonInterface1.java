package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MonInterface1 {

	private JFrame frame;
	private JTextField BtnNomJoeur;
	private JTextField nbrePoint;
	private JTextField nbreJeton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonInterface1 window = new MonInterface1();
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
	public MonInterface1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 0));
		frame.setBounds(100, 100, 703, 587);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJouer = new JButton("JOUER");
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJouer.setBounds(118, 400, 149, 81);
		frame.getContentPane().add(btnJouer);
		
		JButton btnPasser = new JButton("PASSER");
		btnPasser.setBounds(418, 400, 149, 81);
		frame.getContentPane().add(btnPasser);
		
		BtnNomJoeur = new JTextField();
		BtnNomJoeur.setBounds(285, 11, 96, 20);
		frame.getContentPane().add(BtnNomJoeur);
		BtnNomJoeur.setColumns(10);
		
		nbrePoint = new JTextField();
		nbrePoint.setBounds(71, 56, 96, 20);
		frame.getContentPane().add(nbrePoint);
		nbrePoint.setColumns(10);
		
		nbreJeton = new JTextField();
		nbreJeton.setColumns(10);
		nbreJeton.setBounds(508, 56, 96, 20);
		frame.getContentPane().add(nbreJeton);
	}

}
