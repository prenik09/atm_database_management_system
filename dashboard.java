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

public class dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dis = new JLabel("");
		dis.setFont(new Font("Verdana", Font.BOLD, 18));
		dis.setHorizontalAlignment(SwingConstants.CENTER);
		dis.setForeground(Color.WHITE);
		dis.setBackground(Color.WHITE);
		dis.setBounds(160, 81, 358, 37);
		contentPane.add(dis);
		
		JLabel lblNewLabel = new JLabel("SERVICES");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(226, 24, 222, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblAccNo = new JLabel("Acc No.");
		lblAccNo.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblAccNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccNo.setBounds(200, 81, 112, 37);
		contentPane.add(lblAccNo);
		
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
						dashboard.this.dispose();
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
		public dashboard(int acc) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 706, 577);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
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
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel.setBounds(226, 24, 222, 53);
			contentPane.add(lblNewLabel);
			
			JLabel lblAccNo = new JLabel("Acc No.");
			lblAccNo.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblAccNo.setForeground(new Color(255, 255, 255));
			lblAccNo.setHorizontalAlignment(SwingConstants.CENTER);
			lblAccNo.setBounds(200, 81, 112, 37);
			contentPane.add(lblAccNo);
			
			JButton withdrawaltb = new JButton("WITHDRAWAL");
			withdrawaltb.setBackground(new Color(0, 255, 255));
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
							dashboard.this.dispose();
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
		complainttb.setBackground(new Color(0, 255, 255));
		complainttb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new complaint(acc1).setVisible(true);
				dashboard.this.dispose();
			}
		});
		complainttb.setBounds(62, 242, 186, 37);
		contentPane.add(complainttb);
		
		JButton deposittb = new JButton("DEPOSITS");
		deposittb.setBackground(new Color(0, 255, 255));
		deposittb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new deposits(acc1).setVisible(true);
				dashboard.this.dispose();
			}
		});
		deposittb.setBounds(62, 330, 186, 37);
		contentPane.add(deposittb);
		
		JButton statementtb = new JButton("STATEMENTS");
		statementtb.setBackground(new Color(0, 255, 255));
		statementtb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new statements(acc1).setVisible(true);
				dashboard.this.dispose();
			}
		});
		statementtb.setBounds(420, 157, 186, 37);
		contentPane.add(statementtb);
		
		JButton balanceenquirytb = new JButton("BALANCE ENQUIRY");
		balanceenquirytb.setBackground(new Color(0, 255, 255));
		balanceenquirytb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new balanceenquiry(acc1).setVisible(true);
				dashboard.this.dispose();
			}
		});
		balanceenquirytb.setBounds(420, 242, 186, 37);
		contentPane.add(balanceenquirytb);
		
		JButton fundtransfertb = new JButton("FUND TRANSFER");
		fundtransfertb.setBackground(new Color(0, 255, 255));
		fundtransfertb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new fundtransfer(acc1).setVisible(true);
				dashboard.this.dispose();
			}
		});
		fundtransfertb.setBounds(420, 330, 186, 37);
		contentPane.add(fundtransfertb);
		
		}
	}

