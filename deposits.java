package atm;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import java.util.Date;
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
import java.awt.event.ActionEvent;

public class deposits extends JFrame {

	private JPanel contentPane;
	private JTextField amounttb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposits frame = new deposits();
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
	public deposits() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPOSITS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 67, 276, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("₹");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 144, 61, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("DEPOSIT");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(195, 228, 187, 47);
		contentPane.add(btnNewButton);
		
		amounttb = new JTextField();
		amounttb.setBounds(81, 147, 401, 47);
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
		lblNewLabel_4.setBounds(-16, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
int acc1;
public deposits(int acc) {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 591, 372);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 128));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("DEPOSITS");
	lblNewLabel.setForeground(Color.WHITE);
	lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(143, 67, 276, 47);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("₹");
	lblNewLabel_1.setForeground(Color.WHITE);
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_1.setBounds(10, 144, 61, 47);
	contentPane.add(lblNewLabel_1);
	
	amounttb = new JTextField();
	amounttb.setBounds(81, 147, 401, 47);
	contentPane.add(amounttb);
	amounttb.setColumns(10);
	acc1=acc;
	getBalance();
	JButton btnNewButton = new JButton("DEPOSIT");
	btnNewButton.setBackground(new Color(0, 255, 255));
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(amounttb.getText().equals(0)||amounttb.getText().isEmpty()) {
				JOptionPane.showMessageDialog(deposits.this,"please enter the value");
			}
			else {
				try {
					connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
					String query="update accounts set total_balance=? where account_number=?";
					PreparedStatement pw=connection.prepareStatement(query);
					pw.setInt(1, oldbalance+Integer.valueOf(amounttb.getText()));
					pw.setInt(2, acc1);
					if(pw.executeUpdate()==1)
					{
						JOptionPane.showMessageDialog(deposits.this,"acount has been updated");
						money();
					}
					else {
						JOptionPane.showMessageDialog(deposits.this,"acount has been updated");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(deposits.this,e1);
				}
			}
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewButton.setBounds(195, 228, 187, 47);
	contentPane.add(btnNewButton);
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
private void money() {
	try {
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
		PreparedStatement add=connection.prepareStatement("insert into transaction values(?,?,?,?)");
		add.setInt(1, 1);
		add.setInt(2, acc1);
		add.setString(3, amounttb.getText());
		add.setString(4,mydate);
		int row=add.executeUpdate();
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
String mydate;
public void date() {
	Date date=new Date();
	SimpleDateFormat s= new SimpleDateFormat("MM/DD/Y HH:mm");
	mydate=s.format(date);
}

}