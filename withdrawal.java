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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class withdrawal extends JFrame {

	private JPanel contentPane;
	private JTextField amounttb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdrawal frame = new withdrawal();
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
	public withdrawal() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WITHDRAWAL");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 37, 276, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FAST CASH");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(77, 76, 94, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("₹200");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.setBounds(25, 130, 84, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("₹500");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_1.setBounds(25, 197, 84, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("₹2000");
		btnNewButton_2.setBackground(new Color(0, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_2.setBounds(25, 272, 84, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("₹5000");
		btnNewButton_3.setBackground(new Color(0, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_3.setBounds(145, 197, 84, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("₹10000");
		btnNewButton_4.setBackground(new Color(0, 255, 255));
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(145, 272, 84, 27);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("₹100");
		btnNewButton_5.setBackground(new Color(0, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_5.setBounds(145, 130, 84, 27);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("OTHER AMOUNT");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(386, 140, 123, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("₹");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(322, 177, 57, 27);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_6 = new JButton("WITHDRAW");
		btnNewButton_6.setBackground(new Color(0, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setBounds(400, 225, 99, 23);
		contentPane.add(btnNewButton_6);
		
		amounttb = new JTextField();
		amounttb.setBounds(385, 172, 136, 42);
		contentPane.add(amounttb);
		amounttb.setColumns(10);
		
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
		lblNewLabel_4.setBounds(-15, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
	int acc1;
	public withdrawal(int acc) {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		acc1=acc;
		getBalance();
		
		JLabel lblNewLabel = new JLabel("WITHDRAWAL");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 37, 276, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FAST CASH");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(77, 76, 94, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("₹200");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-200);
					pw.setInt(2, acc1);
					if(oldbalance<200) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
			});
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.setBounds(25, 130, 84, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("₹500");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-200);
					pw.setInt(2, acc1);
					if(oldbalance<500) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_1.setBounds(25, 197, 84, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("₹2000");
		btnNewButton_2.setBackground(new Color(0, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-5000);
					pw.setInt(2, acc1);
					if(oldbalance<2000) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"there was a problem please try again");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_2.setBounds(25, 272, 84, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("₹5000");
		btnNewButton_3.setBackground(new Color(0, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-5000);
					pw.setInt(2, acc1);
					if(oldbalance<5000) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"there was a problem please try again");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_3.setBounds(145, 197, 84, 27);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("₹10000");
		btnNewButton_4.setBackground(new Color(0, 255, 255));
		btnNewButton_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-10000);
					pw.setInt(2, acc1);
					if(oldbalance<10000) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"there was a problem please try again");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
		});
		btnNewButton_4.setBounds(145, 272, 84, 27);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("₹100");
		btnNewButton_5.setBackground(new Color(0, 255, 255));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance-100);
					pw.setInt(2, acc1);
					if(oldbalance<100) {
						JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
					}
					else if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
					}
					else {
						JOptionPane.showMessageDialog(withdrawal.this,"there was a problem please try again");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(withdrawal.this,e1);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton_5.setBounds(145, 130, 84, 27);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("OTHER AMOUNT");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(386, 140, 123, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("₹");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(322, 177, 57, 27);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_6 = new JButton("WITHDRAW");
		btnNewButton_6.setBackground(new Color(0, 255, 255));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amounttb.getText().equals(0)||amounttb.getText().isEmpty()) {
					JOptionPane.showMessageDialog(withdrawal.this,"please enter the value");
				}else if(oldbalance<Integer.valueOf(amounttb.getText())) {
					JOptionPane.showMessageDialog(withdrawal.this,"sorry, if you want to withdraw this amount you ahve to earn more");
				}
				else {
					try {
						connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
						String query="update accounts set total_balance=? where account_number=?";
						PreparedStatement pw=connection.prepareStatement(query);
						pw.setInt(1, oldbalance-Integer.valueOf(amounttb.getText()));
						pw.setInt(2, acc1);
						if(pw.executeUpdate()==1)
						{
							JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
						}
						else {
							JOptionPane.showMessageDialog(withdrawal.this,"acount has been updated");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(withdrawal.this,e1);
					}
				}
			}
		});
		btnNewButton_6.setBounds(400, 225, 99, 23);
		contentPane.add(btnNewButton_6);
		
		amounttb = new JTextField();
		amounttb.setBounds(385, 172, 136, 42);
		contentPane.add(amounttb);
		amounttb.setColumns(10);
		
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
		lblNewLabel_4.setBounds(-15, 5, 136, 40);
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
