package atm;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.Result;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class dashboard2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard2 frame = new dashboard2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param b 
	 */
	public dashboard2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SERVICES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(226, 24, 222, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblAccountNumber = new JLabel("HELLO");
		lblAccountNumber.setFont(new Font("Verdana", Font.BOLD, 14));
		lblAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountNumber.setBounds(98, 100, 183, 44);
		contentPane.add(lblAccountNumber);
		
		JButton withdrawaltb2 = new JButton("withdrawal");
		withdrawaltb2.setBounds(54, 172, 183, 37);
		contentPane.add(withdrawaltb2);
		
		JButton depositstb2 = new JButton("deposts");
		depositstb2.setBounds(54, 257, 183, 37);
		contentPane.add(depositstb2);
		
		JButton btnBalanceEnquiry2 = new JButton("balance enquiry");
		btnBalanceEnquiry2.setBounds(54, 342, 183, 37);
		contentPane.add(btnBalanceEnquiry2);
		
		JButton btnComplaint2 = new JButton("complaint");
		btnComplaint2.setBounds(437, 172, 183, 37);
		contentPane.add(btnComplaint2);
		
		JButton btnFundTransfer2 = new JButton("fund transfer");
		btnFundTransfer2.setBounds(437, 257, 183, 37);
		contentPane.add(btnFundTransfer2);
		
		JButton btnStatements2 = new JButton("statements");
		btnStatements2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStatements2.setBounds(437, 342, 183, 37);
		contentPane.add(btnStatements2);
		
		JLabel firstname = new JLabel("New label");
		firstname.setForeground(Color.WHITE);
		firstname.setBounds(226, 100, 154, 37);
		contentPane.add(firstname);
		
		JLabel lastname = new JLabel("New label");
		lastname.setForeground(Color.WHITE);
		lastname.setBounds(382, 100, 154, 37);
		contentPane.add(lastname);
		
		JButton withdrawaltb = new JButton("WITHDRAWAL");
		withdrawaltb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection=null;
				PreparedStatement state=null;
				ResultSet result=null;
				Statement ment=null;
				String query="select * from nishant_atm_database.card";
				try {
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					ment = connection.createStatement();
					result = ment.executeQuery(query);
					if(result.next()) {
						new withdrawal(acc1).setVisible(true);
						dashboard2.this.dispose();
					}
					else {
						JFrame y=new JFrame();
						JOptionPane.showMessageDialog(y,"connection lose","error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.print(e1);
				}
				
			}
		});}
	int acc1;
		public dashboard2(int acc) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 706, 577);
			contentPane = new JPanel();
			contentPane.setBackground(Color.GRAY);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel dis = new JLabel("");
			dis.setFont(new Font("Verdana", Font.BOLD, 18));
			dis.setHorizontalAlignment(SwingConstants.CENTER);
			dis.setForeground(Color.WHITE);
			dis.setBackground(Color.WHITE);
			dis.setBounds(162, 81, 358, 37);
			contentPane.add(dis);
			acc1=acc;
			dis.setText(""+acc1);
			
			JLabel lblNewLabel = new JLabel("SERVICES");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel.setBounds(226, 24, 222, 53);
			contentPane.add(lblNewLabel);
			
			JButton withdrawaltb = new JButton("WITHDRAWAL");
			withdrawaltb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Connection connection=null;
					PreparedStatement state=null;
					ResultSet result=null;
					Statement ment=null;
					String query="select * from nishant_atm_database.card";
					try {
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
						ment = connection.createStatement();
						result = ment.executeQuery(query);
						if(result.next()) {
							new withdrawal(acc1).setVisible(true);
							dashboard2.this.dispose();
						}
						else {
							JFrame y=new JFrame();
							JOptionPane.showMessageDialog(y,"connection lose","error", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.print(e1);
					}
					
				}
			});
		withdrawaltb.setBounds(62, 157, 186, 37);
		contentPane.add(withdrawaltb);
		
		JButton complainttb = new JButton("COMPLAINTS");
		complainttb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new complaint(acc1).setVisible(true);
				dashboard2.this.dispose();
			}
		});
		complainttb.setBounds(62, 242, 186, 37);
		contentPane.add(complainttb);
		
		JButton deposittb = new JButton("DEPOSITS");
		deposittb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new deposits(acc1).setVisible(true);
				dashboard2.this.dispose();
			}
		});
		deposittb.setBounds(62, 330, 186, 37);
		contentPane.add(deposittb);
		
		JButton statementtb = new JButton("STATEMENTS");
		statementtb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new statements(acc1).setVisible(true);
				dashboard2.this.dispose();
			}
		});
		statementtb.setBounds(420, 157, 186, 37);
		contentPane.add(statementtb);
		
		JButton balanceenquirytb = new JButton("BALANCE ENQUIRY");
		balanceenquirytb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new balanceenquiry(acc1).setVisible(true);
				dashboard2.this.dispose();
			}
		});
		balanceenquirytb.setBounds(420, 242, 186, 37);
		contentPane.add(balanceenquirytb);
		
		JButton fundtransfertb = new JButton("FUND TRANSFER");
		fundtransfertb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fundtransfer(acc1).setVisible(true);
				dashboard2.this.dispose();
			}
		});
		fundtransfertb.setBounds(420, 330, 186, 37);
		contentPane.add(fundtransfertb);
		
		}
	}

