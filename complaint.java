package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class complaint extends JFrame {

	private JPanel contentPane;
	private JTextField problemtb;
	private JTextField nametb;
	private JTextField pincodetb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					complaint frame = new complaint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */public complaint() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 559, 727);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 128, 128));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel contentPane_1 = new JPanel();
			contentPane_1.setLayout(null);
			contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane_1.setBackground(new Color(0, 128, 128));
			contentPane_1.setBounds(0, 0, 551, 416);
			contentPane.add(contentPane_1);
			
			JLabel lblNewLabel = new JLabel("COMPLAINT");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel.setBounds(117, 74, 306, 53);
			contentPane_1.add(lblNewLabel);
			
			JLabel lblNewLabel_1_1 = new JLabel("PROBLEM:");
			lblNewLabel_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(72, 138, 146, 40);
			contentPane_1.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("NAME OF THE BANK OF ATM:");
			lblNewLabel_1_1_1.setForeground(Color.WHITE);
			lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblNewLabel_1_1_1.setBounds(71, 271, 210, 40);
			contentPane_1.add(lblNewLabel_1_1_1);
			
			problemtb = new JTextField();
			problemtb.setColumns(10);
			problemtb.setBounds(72, 189, 408, 53);
			contentPane_1.add(problemtb);
			
			nametb = new JTextField();
			nametb.setColumns(10);
			nametb.setBounds(71, 322, 408, 53);
			contentPane_1.add(nametb);
			
			JLabel lblNewLabel_3 = new JLabel("N");
			lblNewLabel_3.setForeground(Color.CYAN);
			lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
			lblNewLabel_3.setBackground(Color.BLACK);
			lblNewLabel_3.setBounds(0, 0, 565, 40);
			contentPane_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("TM");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
			lblNewLabel_4.setBounds(-28, 5, 136, 40);
			contentPane_1.add(lblNewLabel_4);
			
			JButton btnRegisterComplaint = new JButton("REGISTER COMPLAINT");
			btnRegisterComplaint.setBackground(new Color(0, 255, 255));
			btnRegisterComplaint.setForeground(Color.BLACK);
			btnRegisterComplaint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try {
						 String query="INSERT INTO `nishant_atm_database`.`complaint` (`account_number`, `problem`, `name_of_bank`, `atm_pincode`) VALUES ( ?, ?, ?, ?);";
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
						PreparedStatement state=connection.prepareStatement(query);
						state.setInt(1, acc1);
						state.setString(2, problemtb.getText());
						state.setString(3, nametb.getText());
						state.setString(4, pincodetb.getText());
						if(state.executeUpdate()==1) {
							JOptionPane.showMessageDialog(complaint.this,"complaint has been registered");
							connection.close();
						}
						else {
							JOptionPane.showMessageDialog(complaint.this,"complaint has not been registered");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
				}
			});
			btnRegisterComplaint.setBounds(180, 548, 167, 40);
			contentPane.add(btnRegisterComplaint);
			
			pincodetb = new JTextField();
			pincodetb.setColumns(10);
			pincodetb.setBounds(71, 451, 408, 53);
			contentPane.add(pincodetb);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("PINCODE OF ATM:");
			lblNewLabel_1_1_2.setBounds(71, 400, 194, 40);
			contentPane.add(lblNewLabel_1_1_2);
			lblNewLabel_1_1_2.setForeground(Color.WHITE);
			lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		}
	 int acc1;
	public complaint(int acc) {
		acc1=acc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(0, 128, 128));
		contentPane_1.setBounds(0, 0, 551, 416);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("COMPLAINT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(117, 74, 306, 53);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("PROBLEM:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(72, 138, 146, 40);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NAME OF THE BANK OF ATM:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(71, 271, 210, 40);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		
		problemtb = new JTextField();
		problemtb.setColumns(10);
		problemtb.setBounds(72, 189, 408, 53);
		contentPane_1.add(problemtb);
		
		nametb = new JTextField();
		nametb.setColumns(10);
		nametb.setBounds(71, 322, 408, 53);
		contentPane_1.add(nametb);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("PINCODE OF ATM:");
		lblNewLabel_1_1_2.setBounds(71, 400, 194, 40);
		contentPane.add(lblNewLabel_1_1_2);
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JButton btnRegisterComplaint = new JButton("REGISTER COMPLAINT");
		btnRegisterComplaint.setBackground(new Color(0, 255, 255));
		btnRegisterComplaint.setForeground(Color.BLACK);
		btnRegisterComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 String query="INSERT INTO `nishant_atm_database`.`complaint` (`account_number`, `problem`, `name_of_bank`, `atm_pincode`) VALUES ( ?, ?, ?, ?);";
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					PreparedStatement state=connection.prepareStatement(query);
					state.setInt(1, acc1);
					state.setString(2, problemtb.getText());
					state.setString(3, nametb.getText());
					state.setString(4, pincodetb.getText());
					if(state.executeUpdate()==1) {
						JOptionPane.showMessageDialog(complaint.this,"complaint has been registered");
						connection.close();
					}
					else {
						JOptionPane.showMessageDialog(complaint.this,"complaint has not been registered");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		});
		btnRegisterComplaint.setBounds(180, 548, 167, 40);
		contentPane.add(btnRegisterComplaint);
		
		pincodetb = new JTextField();
		pincodetb.setColumns(10);
		pincodetb.setBounds(71, 451, 408, 53);
		contentPane.add(pincodetb);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 31));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(0, 0, 565, 40);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TM");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_4.setBounds(-28, 5, 136, 40);
		contentPane_1.add(lblNewLabel_4);
	}
}
