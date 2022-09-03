package atm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class statements extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statements frame = new statements();
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
	public statements() {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATEMENTS");
		lblNewLabel.setBounds(216, 73, 280, 48);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		Object[]columns= {"transaction_id,amount_debited,date"};
		DefaultTableModel model=new DefaultTableModel();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 165, 554, 104);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		
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
		lblNewLabel_4.setBounds(-18, 5, 136, 40);
		contentPane.add(lblNewLabel_4);
	}
int acc1;
private JScrollPane scrollPane;
public statements(int acc) {
	acc1=acc;
	setForeground(Color.BLACK);
	setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 752, 469);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 128, 128));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblNewLabel = new JLabel("STATEMENTS");
	lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(139, 11, 280, 48);
	contentPane.add(lblNewLabel);
	
	table = new JTable();
	Object[]columns= {"transaction_id,amount_debited,date"};
	DefaultTableModel model=new DefaultTableModel();
	table.setFont(new Font("Verdana", Font.PLAIN, 14));
	table.setBounds(10, 98, 555, 299);
	contentPane.add(table);
	displaytable();
}
private void displaytable() {
	Connection connection;
	try {
		String query="select * from linked_to_relation natural join performs_relation natural join transaction where account_number='"+acc1+"'";
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nishant_atm_database","root","Nishant@123");
		Statement state=connection.createStatement();
		ResultSet result=state.executeQuery(query);
		table.setModel(DbUtils.resultSetToTableModel(result));
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
}
}
