package bloodbank;

import java.awt.EventQueue;
//import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import Pack.Checking;
import Pack.mySQLQueries;

import java.awt.Color;
import java.awt.Font;
//import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffRegistration {

	private JFrame frmRegisteration;
	private JTextField txtName;
	private JTextField txtRoll;
	private JTextField txtNrc;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtCon_Pass;
	JLabel lblStaffid = new JLabel("");
	private JTextField txtPhNo;
	mySQLQueries msql=new mySQLQueries();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffRegistration window = new StaffRegistration();
					window.frmRegisteration.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StaffRegistration()throws Throwable{
		AutoID();
		initialize();
	}
	public void AutoID()throws Throwable {
		lblStaffid.setText(String.valueOf(msql.getAutoid("staffid","staff","ST-")));
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisteration = new JFrame();
		frmRegisteration.setTitle("Registeration");
		frmRegisteration.setBounds(100, 100, 528, 591);
		frmRegisteration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegisteration.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 512, 552);
		frmRegisteration.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBorder(new TitledBorder(null, "Staff's Registeration", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 51)));
		panel_1.setBounds(50, 43, 412, 420);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStiffID = new JLabel("Staff ID:");
		lblStiffID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStiffID.setBounds(61, 33, 137, 21);
		panel_1.add(lblStiffID);
		
		
		lblStaffid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStaffid.setBounds(234, 33, 110, 21);
		panel_1.add(lblStaffid);
		
		JLabel lblName1 = new JLabel("Name:");
		lblName1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName1.setBounds(61, 74, 137, 21);
		panel_1.add(lblName1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConfirmPassword.setBounds(61, 160, 137, 21);
		panel_1.add(lblConfirmPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(61, 116, 137, 21);
		panel_1.add(lblPassword);
		
		JLabel lblIdentificationNumber = new JLabel("Identification Number:");
		lblIdentificationNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdentificationNumber.setBounds(61, 199, 161, 31);
		panel_1.add(lblIdentificationNumber);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAddress.setBounds(61, 243, 137, 31);
		panel_1.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(61, 292, 137, 21);
		panel_1.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtName.setBounds(234, 74, 128, 20);
		panel_1.add(txtName);
		txtName.setColumns(10);
		
		txtRoll = new JTextField();
		txtRoll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtRoll.setColumns(10);
		txtRoll.setBounds(234, 373, 128, 20);
		panel_1.add(txtRoll);
		
		txtNrc = new JTextField();
		txtNrc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNrc.setColumns(10);
		txtNrc.setBounds(234, 199, 128, 20);
		panel_1.add(txtNrc);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAddress.setColumns(10);
		txtAddress.setBounds(234, 243, 128, 20);
		panel_1.add(txtAddress);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setColumns(10);
		txtEmail.setBounds(234, 281, 128, 20);
		panel_1.add(txtEmail);
		
		JLabel lblRoll = new JLabel("Roll:");
		lblRoll.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoll.setBounds(61, 386, 137, 21);
		panel_1.add(lblRoll);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setBounds(234, 116, 128, 20);
		panel_1.add(txtPassword);
		
		txtCon_Pass = new JPasswordField();
		txtCon_Pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCon_Pass.setBounds(234, 160, 128, 20);
		panel_1.add(txtCon_Pass);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhoneNumber.setBounds(61, 339, 137, 21);
		panel_1.add(lblPhoneNumber);
		
		txtPhNo = new JTextField();
		txtPhNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhNo.setColumns(10);
		txtPhNo.setBounds(234, 327, 128, 20);
		panel_1.add(txtPhNo);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setMnemonic('R');
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String st[]=new String[1];
				if(Checking.isNull(txtName.getText()))
				{
					JOptionPane.showMessageDialog(null, "First you must enter Staff name.");
					txtName.requestFocus();
					txtName.selectAll();
				}
				else
				{
					st[0]=(String)txtEmail.getText();
					boolean ee=msql.isduplicate("staff", st);
					if(ee)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Record!");
						txtName.requestFocus();
						txtName.selectAll();
					}
					else
					{
						String[] str=new String[8];
						str[0]=lblStaffid.getText();
						str[1]=txtName.getText();
						str[2]=txtPassword.getText();
						str[3]=txtNrc.getText();
						str[4]=txtAddress.getText();
						str[5]=txtEmail.getText();
						str[6]=txtPhNo.getText();
						str[7]=txtRoll.getText();
						boolean register=mySQLQueries.insertData("staff", str);
						if(register)
						{
							JOptionPane.showMessageDialog(null, "Successfullly Registered!");
							txtName.setText("");
							txtPassword.setText("");
							txtCon_Pass.setText("");
							txtNrc.setText("");
							txtAddress.setText("");
							txtEmail.setText("");
							txtPhNo.setText("");
							txtRoll.setText("");
							txtName.requestFocus();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Failed to register.");
							
						}
					}
				}
			}
		});
		btnRegister.setBackground(new Color(255, 0, 51));
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegister.setBounds(78, 484, 105, 27);
		panel.add(btnRegister);
		
		JButton btnCanel = new JButton("Canel");
		btnCanel.setMnemonic('C');
		btnCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setText("");
				txtPassword.setText("");
				txtCon_Pass.setText("");
				txtNrc.setText("");
				txtAddress.setText("");
				txtEmail.setText("");
				txtPhNo.setText("");
				txtRoll.setText("");
				txtName.requestFocus();
				
			}
		});
		btnCanel.setBackground(new Color(255, 0, 51));
		btnCanel.setForeground(new Color(255, 255, 255));
		btnCanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCanel.setBounds(210, 484, 105, 27);
		panel.add(btnCanel);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure want to exit", "Exit?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setMnemonic('E');
		btnExit.setBackground(new Color(255, 0, 51));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBounds(339, 484, 105, 27);
		panel.add(btnExit);
	}
}
