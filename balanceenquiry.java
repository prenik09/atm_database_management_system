package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class balanceenquiry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balanceenquiry frame = new balanceenquiry();
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
	public balanceenquiry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 458);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountBalane = new JLabel("ACCOUNT BALANCE (in ₹)");
		lblAccountBalane.setForeground(Color.WHITE);
		lblAccountBalane.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAccountBalane.setBounds(197, 145, 195, 43);
		contentPane.add(lblAccountBalane);
		
		JLabel lblNewLabel_1 = new JLabel("BALANCE ENQUIRY");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(126, 40, 324, 65);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				balanceenquiry.this.dispose();
			}
		});
		btnNewButton.setBounds(250, 297, 80, 43);
		contentPane.add(btnNewButton);
		
		JLabel balancetb = new JLabel("New label");
		balancetb.setForeground(new Color(0, 255, 255));
		balancetb.setFont(new Font("Verdana", Font.BOLD, 18));
		balancetb.setBackground(new Color(255, 255, 255));
		balancetb.setHorizontalAlignment(SwingConstants.CENTER);
		balancetb.setBounds(106, 181, 365, 65);
		contentPane.add(balancetb);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(10, 0, 565, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TM");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(-16, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
int acc1;
Connection connection=null;
PreparedStatement ment=null;
Statement state=null;
ResultSet result=null;
public balanceenquiry(int acc) {
	acc1=acc;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 591, 458);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 128));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblAccountBalane = new JLabel("ACCOUNT BALANCE (in ₹)");
	lblAccountBalane.setForeground(Color.WHITE);
	lblAccountBalane.setFont(new Font("Verdana", Font.PLAIN, 14));
	lblAccountBalane.setBounds(197, 145, 195, 43);
	contentPane.add(lblAccountBalane);
	
	JLabel balancetb = new JLabel("New label");
	balancetb.setForeground(new Color(0, 255, 255));
	balancetb.setFont(new Font("Verdana", Font.BOLD, 18));
	balancetb.setBackground(new Color(255, 255, 255));
	balancetb.setHorizontalAlignment(SwingConstants.CENTER);
	balancetb.setBounds(106, 181, 365, 65);
	contentPane.add(balancetb);
	String query="select * from nishant_atm_database.accounts where account_number='"+acc1+"'";
	Statement state=null;
	ResultSet result=null;
	try {
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
		state= connection.createStatement();
		result=state.executeQuery(query);
		if(result.next())
		{
			balancetb.setText(""+result.getInt(3));
		}
		else
		{
			JOptionPane.showMessageDialog(balanceenquiry.this,"something wrong happen");
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	JLabel lblNewLabel_1 = new JLabel("BALANCE ENQUIRY");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
	lblNewLabel_1.setBounds(126, 40, 324, 65);
	contentPane.add(lblNewLabel_1);
	
	JButton btnNewButton = new JButton("OK");
	btnNewButton.setBackground(new Color(0, 255, 255));
	btnNewButton.setForeground(Color.BLACK);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			balanceenquiry.this.dispose();
		}
	});
	btnNewButton.setBounds(250, 297, 80, 43);
	contentPane.add(btnNewButton);
	
	JLabel lblNewLabel_3 = new JLabel("N");
	lblNewLabel_3.setForeground(Color.CYAN);
	lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
	lblNewLabel_3.setBackground(Color.BLACK);
	lblNewLabel_3.setBounds(10, 0, 565, 40);
	contentPane.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("TM");
	lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_4.setForeground(Color.WHITE);
	lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
	lblNewLabel_4.setBounds(-16, 5, 136, 40);
	contentPane.add(lblNewLabel_4);
}	
}
