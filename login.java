package atm;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField cardnumbertb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	dbconnection con;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField pass;
	public login() {
		getContentPane().setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.GRAY);
		contentPane_1.setBounds(0, 0, 551, 416);
		getContentPane().add(contentPane_1);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Verdana", Font.BOLD, 18));
		lblLogin.setBounds(116, 22, 306, 53);
		contentPane_1.add(lblLogin);
		
		JLabel lblNewLabel_1 = new JLabel("CARD NUMBER");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 71, 146, 40);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PIN");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(71, 183, 146, 40);
		contentPane_1.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.setBounds(203, 307, 134, 40);
		contentPane_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(69, 111, 408, 53);
		contentPane_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(71, 223, 408, 56);
		contentPane_1.add(passwordField);
		con=new dbconnection();
		if(con==null)
		{
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"connection error","error",JOptionPane.ERROR_MESSAGE);
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(105, 228, 87, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_11 = new JLabel("card number");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(105, 104, 98, 23);
		contentPane.add(lblNewLabel_11);
		
		JButton logintb = new JButton("login");
		logintb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String card_number=cardnumbertb.getText();
				String PIN=pass.getText();
				Connection connection=null;
				PreparedStatement state=null;
				PreparedStatement state1=null;
				ResultSet result=null;
				ResultSet result1=null;
				Statement ment=null;
				Statement ment1=null;
				if(card_number.isEmpty()||PIN.isEmpty())
				{
					JFrame f=new JFrame();
					JOptionPane.showMessageDialog(f,"card number/PIN is empty","error",JOptionPane.ERROR_MESSAGE);
				}else {
					String query="select * from nishant_atm_database.card natural join nishant_atm_database.linked_to_relation where card_no='"+cardnumbertb.getText()+"'and card_pin='"+pass.getText()+"'";
					try {
						connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
						ment=connection.createStatement();
						result=ment.executeQuery(query);
						if(result.next()) {
							new dashboard(result.getInt(6)).setVisible(true);
							login.this.dispose();
						}
						else {
							JFrame y=new JFrame();
							JOptionPane.showMessageDialog(y,"card/pin is incorrect","error",JOptionPane.ERROR_MESSAGE);
							connection.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.print(e);
					}
					
					
				}
				
			}
		});
		logintb.setBackground(new Color(0, 255, 255));
		logintb.setForeground(new Color(0, 0, 0));
		logintb.setBounds(252, 345, 87, 23);
		contentPane.add(logintb);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(210, 46, 157, 40);
		contentPane.add(lblNewLabel_2);
		
		cardnumbertb = new JTextField();
		cardnumbertb.setBounds(105, 138, 380, 47);
		contentPane.add(cardnumbertb);
		cardnumbertb.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(105, 262, 380, 47);
		contentPane.add(pass);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		lblNewLabel_3.setForeground(new Color(0, 255, 255));
		lblNewLabel_3.setBounds(10, 11, 565, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TM");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(-19, 16, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
}
