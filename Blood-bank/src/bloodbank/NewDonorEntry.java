package bloodbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
//import javax.swing.border.CompoundBorder;
import java.awt.Rectangle;
//import javax.swing.border.LineBorder;
//import javax.swing.border.MatteBorder;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import Pack.Checking;
import Pack.mySQLQueries;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class NewDonorEntry {

	 JFrame frame;
	 JTextField txtname;
	 JTextField txtidnumber;
	 JTextField phoneno;
	 JTextField txtaddress;
	 JTextField txttownship;
	 JTextField txtremark;
	 JComboBox<Object> cbobloodtype = new JComboBox<>();
	 JLabel lbldonorID = new JLabel("");
	 mySQLQueries msql=new mySQLQueries();
	 /**
	  * @wbp.nonvisual location=-59,304
	  */
	  final JDayChooser dayChooser = new JDayChooser();
	 private final ButtonGroup buttonGroup = new ButtonGroup();
	 private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDonorEntry window = new NewDonorEntry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Throwable 
	 */
	public NewDonorEntry() throws Throwable {
		AutoID();
		initialize();
		fillBloodType();
	}
	public void fillBloodType() throws Throwable {
		cbobloodtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showBloodType();
			}
		});
		String str[] = msql.getIDForChoice("bloodtype");
		for (int i = 0; i < str.length; i++) {
			cbobloodtype.addItem(str[i].toString());
		}
	}
	public void showBloodType() {
		if (cbobloodtype.getSelectedIndex()==0) {
			//txtbloodtype.setText("");
		}else {
			String result = msql.getBloodTypeName(cbobloodtype.getSelectedItem().toString());
			//txtbloodtype.setText(result);
		}
	}
	public void AutoID() {
		lbldonorID.setText(String.valueOf(msql.getAutoid("donorid", "donor", "D-")));
	}
	
	public void clear()
	{
		txtname.setText("");
		txtname.requestFocus();
		txtidnumber.setText("");
		txtidnumber.requestFocus();
		phoneno.setText("");
		phoneno.requestFocus();
		txtaddress.setText("");
		txtaddress.requestFocus();
		txttownship.setText("");
		txttownship.requestFocus();
		txtremark.setText("");
		txtremark.requestFocus();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(51, 51, 51));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(100, 100, 805, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Donor Info:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel.setBounds(37, 49, 713, 359);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Donor ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(28, 48, 82, 16);
		panel.add(lblNewLabel);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFullName.setBounds(28, 89, 82, 32);
		panel.add(lblFullName);
		
		JLabel lblLastDonateDate = new JLabel("Last Donate Date:");
		lblLastDonateDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastDonateDate.setBounds(28, 146, 118, 19);
		panel.add(lblLastDonateDate);
		
		
		lbldonorID.setBounds(174, 48, 140, 16);
		panel.add(lbldonorID);
		
		JLabel lblNewLabel_2 = new JLabel("Blood Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(28, 194, 95, 19);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Identification Number:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(363, 48, 160, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gender:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(363, 94, 56, 22);
		panel.add(lblNewLabel_4);
		
		txtname = new JTextField();
		txtname.setBounds(171, 94, 150, 22);
		panel.add(txtname);
		txtname.setColumns(10);
		
		txtidnumber = new JTextField();
		txtidnumber.setBounds(527, 45, 150, 22);
		panel.add(txtidnumber);
		txtidnumber.setColumns(10);
		
		JRadioButton rdomale = new JRadioButton("Male");
		buttonGroup.add(rdomale);
		rdomale.setBounds(527, 93, 74, 25);
		panel.add(rdomale);
		
		JRadioButton rdofemale = new JRadioButton("Female");
		buttonGroup.add(rdofemale);
		rdofemale.setBounds(605, 93, 74, 25);
		panel.add(rdofemale);
		
		
		cbobloodtype.setBounds(171, 192, 150, 22);
		panel.add(cbobloodtype);
		
		JLabel lblNewLabel_8 = new JLabel("Phone No:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(363, 149, 103, 16);
		panel.add(lblNewLabel_8);
		
		phoneno = new JTextField();
		phoneno.setBounds(527, 146, 150, 22);
		panel.add(phoneno);
		phoneno.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Date Of Birth:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(28, 240, 95, 22);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Address:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(363, 195, 103, 16);
		panel.add(lblNewLabel_11);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(527, 192, 150, 22);
		panel.add(txtaddress);
		txtaddress.setColumns(10);
		
		txttownship = new JTextField();
		txttownship.setBounds(527, 240, 150, 22);
		panel.add(txttownship);
		txttownship.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Remark:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(28, 285, 97, 22);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Dieases:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(363, 288, 103, 16);
		panel.add(lblNewLabel_13);
		
		txtremark = new JTextField();
		txtremark.setBounds(171, 285, 150, 22);
		panel.add(txtremark);
		txtremark.setColumns(10);
		
		JRadioButton rdopositive = new JRadioButton("Positive");
		buttonGroup_1.add(rdopositive);
		rdopositive.setBounds(527, 284, 74, 25);
		panel.add(rdopositive);
		
		JRadioButton rdonegative = new JRadioButton("Negative");
		buttonGroup_1.add(rdonegative);
		rdonegative.setBounds(597, 284, 82, 25);
		panel.add(rdonegative);
		
		JDateChooser dateofbirth = new JDateChooser();
		dateofbirth.setBounds(171, 240, 150, 22);
		panel.add(dateofbirth);
		
		JDateChooser lastdonatedate = new JDateChooser();
		lastdonatedate.setBounds(171, 143, 150, 22);
		panel.add(lastdonatedate);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setMnemonic('C');
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setBounds(338, 430, 102, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure want to exit", "Exit?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setMnemonic('E');
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(517, 430, 102, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Checking.isNull(txtname.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Donor Name!");
					txtname.requestFocus();
					txtname.selectAll();
				}
				else if(Checking.isNull(txtidnumber.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Identification Number");
				}
				else if(Checking.isNull(phoneno.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Identification Number");
				}
				else if(Checking.isNull(txtaddress.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Identification Number");
				}
				else if(Checking.isNull(txttownship.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Identification Number");
				}
				else if(Checking.isNull(txtremark.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Identification Number");
				}
				else {
					String gender = null;
					if(rdomale.isSelected()) 
				        gender="Male";
				    else if(rdofemale.isSelected()) 
				        gender="Female";
					String dieases = null;
					if(rdopositive.isSelected()) 
						dieases="Positive";
				    else if(rdonegative.isSelected()) 
				    	dieases="Negative";
					String dob=""+dateofbirth.getDate();
					String ldd=""+lastdonatedate.getDate();
					SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
					Date_Format.format(dateofbirth.getDate());
					Date_Format.format(lastdonatedate.getDate());
					
					String[] str = new String[14];
					str[0] = lbldonorID.getText();
					str[1] = null;
					str[2] = txtname.getText();
					str[3] = txtidnumber.getText();
					str[4] = gender;
					str[5] = ldd;
					str[6] = null;
					str[8] = phoneno.getText();
					str[9] = dob;
					str[10] = txtaddress.getText();
					str[11] = txttownship.getText();
					str[12] = txtremark.getText();
					str[13] = dieases;
					boolean save = mySQLQueries.insertData("blood", str);
					if (save) {
						JOptionPane.showMessageDialog(null, "Saved Successfully!","Saved Record",JOptionPane.INFORMATION_MESSAGE);
						AutoID();
						clear();
					} else {
						JOptionPane.showMessageDialog(null, "Failed to Save new Record!","Cannot Saved",JOptionPane.INFORMATION_MESSAGE);
						AutoID();
					}
						
				}
			}
		});
		btnNewButton_2.setBounds(new Rectangle(0, 0, 1, 1));
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 0, 51));
		btnNewButton_2.setBounds(168, 430, 97, 30);
		frame.getContentPane().add(btnNewButton_2);
	}
}
