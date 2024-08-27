package cep;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscador de CEP - ver 1.0");
		lblNewLabel.setBounds(59, 54, 280, 17);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("@Author: Leandro Santana");
		lblNewLabel_2.setBounds(59, 113, 240, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("@ Original Author: Professor José De Assis");
		lblNewLabel_1.setBounds(59, 88, 365, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("WEB Service:");
		lblNewLabel_3.setBounds(59, 152, 113, 17);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("republicavirtual.com.br");
		lblNewLabel_4.setForeground(new Color(30, 144, 255));
		lblNewLabel_4.setBounds(157, 152, 169, 17);
		getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Sobre.class.getResource("/img/youtube.png")));
		btnNewButton.setBounds(272, 210, 48, 48);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setBounds(177, 210, 48, 48);
		getContentPane().add(btnNewButton_1);

	}
}
