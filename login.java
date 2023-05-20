package Rumitek_Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Rumitek_login extends Rumitek_Home {

	private JFrame frame;
	private JPasswordField password;
	JCheckBox showpass = new JCheckBox("Show Password");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rumitek_login window = new Rumitek_login();
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
	public Rumitek_login()throws SQLException, InterruptedException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setType(Type.UTILITY);
		frame.setBounds(490, 200, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(new Color(213, 0, 0));
		lblLogIn.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 40));
		lblLogIn.setBackground(Color.WHITE);
		lblLogIn.setBounds(0, 0, 434, 73);
		frame.getContentPane().add(lblLogIn);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Enter Password");
		lblNewLabel_2_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2_1_1_2.setBounds(81, 112, 140, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_2);
		
		password = new JPasswordField();
		password.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				password.setBorder(new LineBorder(new Color(213, 0, 0),2));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				password.setBorder(new LineBorder(Color.black));

			}
		});
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					

					String temp="";
					
					try {
						par=con.prepareStatement("select * from Password");
						
						rs=par.executeQuery();
						
						while(rs.next())
							temp=rs.getString(1);
						
						if(temp.equals(password.getText())) {
							
							try {
								
								Rumitek_Home window = new Rumitek_Home();
								window.frmRumitek.setVisible(true);
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}

							
						}else {
							
							JOptionPane.showMessageDialog(null, "Password Was Wrong !!!");
							password.setText("");
						}
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
				}
			}
		});
		password.setEchoChar('●');
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		password.setBounds(81, 139, 272, 48);
		frame.getContentPane().add(password);
		
		final JButton btnSearch_2_1_1_1 = new JButton("Log in");
		
		btnSearch_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnSearch_2_1_1_1.setForeground(new Color(203, 29, 33));
				btnSearch_2_1_1_1.setBackground(Color.white);
				btnSearch_2_1_1_1.setBorder(new LineBorder(new Color(203, 29, 33),3));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				btnSearch_2_1_1_1.setForeground(Color.WHITE);
				btnSearch_2_1_1_1.setBackground(new Color(203, 29, 33));
				btnSearch_2_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255),1));	
			}
		});
		btnSearch_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String temp="";
				
			try {
				par=con.prepareStatement("select * from Password");
				
				rs=par.executeQuery();
				
				while(rs.next())
					temp=rs.getString(1);
				
				if(temp.equals(password.getText())) {
					
					try {
						
						Rumitek_Home window = new Rumitek_Home();
						window.frmRumitek.setVisible(true);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}

					
				}else {
					
					JOptionPane.showMessageDialog(null, "Password Was Wrong !!!");
					password.setText("");
				}
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				
				
			}
		});
		btnSearch_2_1_1_1.setForeground(Color.WHITE);
		btnSearch_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSearch_2_1_1_1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnSearch_2_1_1_1.setBackground(new Color(208, 9, 14));
		btnSearch_2_1_1_1.setBounds(161, 222, 106, 36);
		frame.getContentPane().add(btnSearch_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Forgot Password ??");
		lblNewLabel_2_1_1_2_1.setForeground(Color.GRAY);
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1_1_2_1.setBounds(147, 269, 133, 28);
		frame.getContentPane().add(lblNewLabel_2_1_1_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("_______");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setBounds(0, 37, 434, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		showpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(showpass.isSelected()) {
				
				password.setEchoChar((char)0);
				password.setFont(new Font("Times New Roman", Font.BOLD, 25));

			}else {
				
				password.setEchoChar('●');
				password.setFont(new Font("Times New Roman", Font.BOLD, 20));
				

			}
				
				
			}
		});
		showpass.setFont(new Font("Tahoma", Font.BOLD, 12));
		showpass.setBackground(Color.WHITE);
		showpass.setBounds(81, 187, 133, 28);
		frame.getContentPane().add(showpass);
	}
}
