package bloodbank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
//import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

import Pack.Checking;
import Pack.mySQLQueries;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BloodTypeEntry {

	JFrame frame;
	JTextField txtbloodtype;
	JLabel lblbloodtypeid = new JLabel("");
	mySQLQueries msql=new mySQLQueries();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodTypeEntry window = new BloodTypeEntry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BloodTypeEntry() {
		AutoID();
		initialize();
	}
	
	public void AutoID()
	{
		lblbloodtypeid.setText((String.valueOf(msql.getAutoid("bloodtypeid","bloodtype","BT-"))));
	}
	public void clear()
	{
		txtbloodtype.setText("");
		txtbloodtype.requestFocus();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 426, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setForeground(Color.RED);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "BloodType Info:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel.setBounds(34, 28, 338, 162);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BloodType ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 46, 97, 16);
		panel.add(lblNewLabel);
		
		
		lblbloodtypeid.setBounds(159, 46, 144, 16);
		panel.add(lblbloodtypeid);
		
		JLabel lblNewLabel_2 = new JLabel("Blood Type:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(35, 101, 79, 19);
		panel.add(lblNewLabel_2);
		
		txtbloodtype = new JTextField();
		txtbloodtype.setBounds(157, 99, 144, 22);
		panel.add(txtbloodtype);
		txtbloodtype.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] st = new String[1];
				if (Checking.isNull(txtbloodtype.getText())) {
					JOptionPane.showMessageDialog(null, "You must Enter BloodType!");
					txtbloodtype.requestFocus();
					txtbloodtype.selectAll();
				}
				else {
					st[0] = (String)txtbloodtype.getText();
					boolean dup = msql.isduplicate("bloodtype", st);
					if(dup) {
						JOptionPane.showMessageDialog(null, "Duplicate Record!");
						txtbloodtype.requestFocus();
						txtbloodtype.selectAll();
					}
					else {
						String[] str = new String[2];
						str[0] = lblbloodtypeid.getText();
						str[1] = txtbloodtype.getText();
						boolean save = mySQLQueries.insertData("bloodtype", str);
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
			}
		});
		btnNewButton.setMnemonic('A');
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBounds(44, 215, 87, 32);
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
		btnNewButton_1.setBounds(159, 215, 87, 32);
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
		btnNewButton_2.setBounds(269, 215, 87, 32);
		frame.getContentPane().add(btnNewButton_2);
	}
}
