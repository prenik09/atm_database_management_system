package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fundtransfer extends JFrame {

	private JPanel contentPane;
	private JTextField accnotb;
	private JTextField amounttb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fundtransfer frame = new fundtransfer();
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
	public fundtransfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FUND TRANSFER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 48, 306, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NUMBER");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 90, 146, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AMOUNT(in ₹)");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(71, 205, 146, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(203, 321, 134, 40);
		contentPane.add(btnNewButton);
		
		accnotb = new JTextField();
		accnotb.setBounds(69, 141, 408, 53);
		contentPane.add(accnotb);
		accnotb.setColumns(10);
		
		amounttb = new JTextField();
		amounttb.setColumns(10);
		amounttb.setBounds(69, 249, 408, 53);
		contentPane.add(amounttb);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(0, 0, 565, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TM");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(-27, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
	int acc1;
	public fundtransfer(int acc) {
		acc1=acc;
		getBalance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FUND TRANSFER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(117, 48, 306, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NUMBER");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(71, 90, 146, 40);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("AMOUNT(in ₹)");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(71, 205, 146, 40);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amounttb.getText().equals(0)||amounttb.getText().isEmpty()||accnotb.getText().equals(0)||accnotb.getText().isEmpty()) {
					JOptionPane.showMessageDialog(fundtransfer.this,"please enter the value");
				}
				else {
					try {
						connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
						int result1=0, result2=0;
						PreparedStatement ps = connection.prepareStatement("update accounts set total_balance=total_balance-? where account_number=?");
						ps.setInt(1, Integer.valueOf(amounttb.getText()));
						ps.setInt(2, acc1);
						result1 = ps.executeUpdate();
						ps = connection.prepareStatement("update accounts set total_balance=total_balance+? where account_number=?");
						ps.setInt(1, Integer.valueOf(amounttb.getText()));
						ps.setInt(2, Integer.valueOf(accnotb.getText()));
						result2 = ps.executeUpdate();
						if(oldbalance<Integer.valueOf(amounttb.getText()))
						{
							JOptionPane.showMessageDialog(fundtransfer.this,"unsufficient amount");
						}
						else if(result1==1&&result2==1)
						{
							JOptionPane.showMessageDialog(fundtransfer.this,"acount has been updated");
						}
						else {
							JOptionPane.showMessageDialog(fundtransfer.this,"acount has not been updated");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(fundtransfer.this,e1);
					}
				}
			}
		});
		btnNewButton.setBounds(203, 321, 134, 40);
		contentPane.add(btnNewButton);
		
		accnotb = new JTextField();
		accnotb.setBounds(69, 141, 408, 53);
		contentPane.add(accnotb);
		accnotb.setColumns(10);
		
		amounttb = new JTextField();
		amounttb.setColumns(10);
		amounttb.setBounds(69, 249, 408, 53);
		contentPane.add(amounttb);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(0, 0, 565, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TM");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(-27, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}

int oldbalance;
Connection connection=null;
PreparedStatement state=null;
ResultSet result=null;
java.sql.Statement ment=null;
private void getBalance() {
	try {
		String Query="select * from accounts where account_number='"+acc1+"'";
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
		ment = connection.createStatement();
		result=ment.executeQuery(Query);
		if(result.next()) {
			oldbalance=result.getInt(3);
		}
		
	}catch(Exception e) {
		System.out.println(e);
	}
}
}

