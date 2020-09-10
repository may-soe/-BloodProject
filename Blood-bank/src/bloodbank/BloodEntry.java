package bloodbank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import Pack.Checking;
import Pack.mySQLQueries;
import javax.swing.JComboBox;

public class BloodEntry {

	 JFrame frame;
	 JTextField txtbloodtype=new JTextField("");
	 JTextField txtqty=new JTextField("");;
	 JLabel lblbloodid = new JLabel("");
	 
	 JComboBox<Object> cbobloodtype = new JComboBox<>();
	 mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodEntry window = null;
					try {
						window = new BloodEntry();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Throwable 
	 */
	public BloodEntry() throws Throwable {
		AutoID();
		initialize();
		fillBloodType();
	}

	public void AutoID()
	{
		lblbloodid.setText((String.valueOf(msql.getAutoid("bloodid","blood","B-"))));
	}
	

	public void fillBloodType() throws Throwable {
		cbobloodtype.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showBloodType();
			}
		});
		cbobloodtype.addItem("-Selected-");
		String str[] = msql.getIDForChoice("bloodtype");
		for (int i = 0; i < str.length; i++) {
			cbobloodtype.addItem(str[i].toString());
		}
	}
	public void showBloodType() {
		if (cbobloodtype.getSelectedIndex()==0) {
			txtbloodtype.setText("");
		}else {
			String result = msql.getBloodTypeName(cbobloodtype.getSelectedItem().toString());
			txtbloodtype.setText(result);
		}
	}
	
	
	public void clear()
	{
		txtbloodtype.setText("");
		txtqty.setText("");
		cbobloodtype.setSelectedIndex(0);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setForeground(Color.RED);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Blood Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(34, 28, 340, 273);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Blood ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 46, 97, 16);
		panel.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Blood Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(35, 154, 79, 19);
		panel.add(lblNewLabel_2);
		
	
		cbobloodtype.setBounds(154, 100, 124, 22);
		panel.add(cbobloodtype);
		
		JLabel lblBloodtypeid = new JLabel("BloodType ID:");
		lblBloodtypeid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBloodtypeid.setBounds(35, 103, 97, 16);
		panel.add(lblBloodtypeid);
		
		//JLabel lblbloodid = new JLabel("");
		lblbloodid.setBounds(156, 46, 124, 16);
		panel.add(lblbloodid);
		
		txtbloodtype = new JTextField();
		txtbloodtype.setEditable(false);
		txtbloodtype.setForeground(Color.DARK_GRAY);
		txtbloodtype.setBounds(154, 152, 124, 22);
		panel.add(txtbloodtype);
		txtbloodtype.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantity.setBounds(35, 205, 97, 16);
		panel.add(lblQuantity);
		
		txtqty = new JTextField();
		txtqty.setBounds(154, 202, 124, 22);
		panel.add(txtqty);
		txtqty.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Checking.isNull(txtqty.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter Blood Quantity!");
					txtqty.requestFocus();
					txtqty.selectAll();
				}
				else {
						String[] str = new String[3];
						str[0] = lblbloodid.getText();
						str[1] = cbobloodtype.getSelectedItem().toString();
						str[2] = txtqty.getText();
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
		btnNewButton.setMnemonic('A');
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBounds(45, 331, 87, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear();
			}
		});
		btnNewButton_1.setMnemonic('C');
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_1.setBackground(new Color(255, 0, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(155, 331, 87, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure want to exit", "Exit?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_2.setMnemonic('E');
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBackground(new Color(255, 0, 51));
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton_2.setBounds(267, 331, 87, 32);
		frame.getContentPane().add(btnNewButton_2);
	}
}
