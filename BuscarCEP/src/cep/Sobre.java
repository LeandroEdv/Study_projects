package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setModal(true);
		setResizable(false);
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/home.png")));
		setBounds(150, 150, 450, 300);
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
		
		JLabel lblWebServece = new JLabel("republicavirtual.com.br");
		lblWebServece.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://www.republicavirtual.com.br/");
			}
		});
		lblWebServece.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblWebServece.setForeground(new Color(30, 144, 255));
		lblWebServece.setBounds(157, 152, 169, 17);
		getContentPane().add(lblWebServece);
		
		JButton btnYoutube = new JButton("");
		btnYoutube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://www.youtube.com/watch?v=sKO2C58yf28");
			}
		});
		btnYoutube.setBackground(SystemColor.control);
		btnYoutube.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnYoutube.setBorder(null);
		btnYoutube.setBorderPainted(false);
		btnYoutube.setIcon(new ImageIcon(Sobre.class.getResource("/img/youtube.png")));
		btnYoutube.setBounds(272, 210, 48, 48);
		getContentPane().add(btnYoutube);
		
		JButton btnGithub = new JButton("");
		btnGithub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/LeandroEdv");
			}
		});
		btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
		btnGithub.setBorderPainted(false);
		btnGithub.setBorder(null);
		btnGithub.setBackground(SystemColor.control);
		btnGithub.setBounds(177, 210, 48, 48);
		getContentPane().add(btnGithub);

	}
	private void link (String site) {
		Desktop desktop = Desktop.getDesktop();
		
		try {
			URI uri = new URI(site);
			desktop.browse(uri);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
