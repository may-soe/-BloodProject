package bloodbank;

import java.awt.EventQueue;
//import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
public class Dashboard{

	private JFrame frame;
	//private Image img_logo=new ImageIcon(Dashboard.class.getResource("img/index.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private NewDonorEntry NewDonorEntry;
	private StaffRegistration StaffRegistration;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 788, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		NewDonorEntry=new NewDonorEntry();
		StaffRegistration=new StaffRegistration();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 0, 51));
		panel.setBounds(0, 0, 277, 553);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblcon = new JLabel("New label");
		lblcon.setBounds(0, 0, 277, 167);
		//lblcon.setIcon(new ImageIcon(img_logo));
		panel.add(lblcon);
		
		JPanel home = new JPanel();
		home.addMouseListener(new PanelButtonMouseAdapter(home));
		home.setBackground(new Color(204, 51, 51));
		home.setBounds(0, 160, 277, 40);
		panel.add(home);
		home.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setBounds(73, 13, 178, 22);
		home.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		
		JPanel newDonor = new JPanel();
		newDonor.addMouseListener(new PanelButtonMouseAdapter(newDonor));
		newDonor.setBackground(new Color(204, 51, 51));
		newDonor.setBounds(0, 200, 277, 40);
		panel.add(newDonor);
		newDonor.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New Donor");
		lblNewLabel_1.setBounds(73, 0, 180, 35);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		newDonor.add(lblNewLabel_1);
		
		JPanel Donordetail = new JPanel();
		Donordetail.addMouseListener(new PanelButtonMouseAdapter(Donordetail));
		Donordetail.setBackground(new Color(204, 51, 51));
		Donordetail.setBounds(0, 240, 277, 40);
		panel.add(Donordetail);
		Donordetail.setLayout(null);
		
		JLabel lblDonorDetail = new JLabel("Donor Detail");
		lblDonorDetail.setForeground(Color.WHITE);
		lblDonorDetail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDonorDetail.setBounds(72, 0, 180, 40);
		Donordetail.add(lblDonorDetail);
		
		JPanel bloodstock = new JPanel();
		bloodstock.addMouseListener(new PanelButtonMouseAdapter(bloodstock));
		bloodstock.setBackground(new Color(204, 51, 51));
		bloodstock.setBounds(0, 280, 277, 40);
		panel.add(bloodstock);
		bloodstock.setLayout(null);
		
		JLabel lblBloodStock_1 = new JLabel("Blood Stock");
		lblBloodStock_1.setForeground(Color.WHITE);
		lblBloodStock_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBloodStock_1.setBounds(70, 0, 180, 40);
		bloodstock.add(lblBloodStock_1);
		
		JPanel Requestblood = new JPanel();
		Requestblood.addMouseListener(new PanelButtonMouseAdapter(Requestblood));
		Requestblood.setBackground(new Color(204, 51, 51));
		Requestblood.setBounds(0, 320, 277, 40);
		panel.add(Requestblood);
		Requestblood.setLayout(null);
		
		JLabel lblRequestBlood = new JLabel("Request Blood");
		lblRequestBlood.setForeground(Color.WHITE);
		lblRequestBlood.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRequestBlood.setBounds(70, 0, 180, 40);
		Requestblood.add(lblRequestBlood);
		
		JPanel RequestDetail = new JPanel();
		RequestDetail.addMouseListener(new PanelButtonMouseAdapter(RequestDetail));
		RequestDetail.setBackground(new Color(204, 51, 51));
		RequestDetail.setBounds(0, 360, 277, 40);
		panel.add(RequestDetail);
		RequestDetail.setLayout(null);
		
		JLabel lblRequestDetail = new JLabel("Request Detail");
		lblRequestDetail.setForeground(Color.WHITE);
		lblRequestDetail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRequestDetail.setBounds(70, 0, 180, 40);
		RequestDetail.add(lblRequestDetail);
		
		JPanel Hospital = new JPanel();
		Hospital.addMouseListener(new PanelButtonMouseAdapter(Hospital));
		Hospital.setBackground(new Color(204, 51, 51));
		Hospital.setBounds(0, 400, 277, 40);
		panel.add(Hospital);
		Hospital.setLayout(null);
		
		JLabel lblHospital = new JLabel("Hospital");
		lblHospital.setForeground(Color.WHITE);
		lblHospital.setFont(new Font("Dialog", Font.BOLD, 14));
		lblHospital.setBounds(70, 0, 180, 40);
		Hospital.add(lblHospital);
		
		JPanel staff = new JPanel();
		staff.addMouseListener(new PanelButtonMouseAdapter(home));
		staff.setBackground(new Color(204, 51, 51));
		staff.setBounds(0, 440, 277, 40);
		panel.add(staff);
		staff.setLayout(null);
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setForeground(Color.WHITE);
		lblStaff.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStaff.setBounds(70, 0, 180, 40);
		staff.add(lblStaff);
		
		JPanel logout = new JPanel();
		logout.addMouseListener(new PanelButtonMouseAdapter(logout));
		logout.setBackground(new Color(204, 51, 51));
		logout.setBounds(0, 480, 277, 40);
		panel.add(logout);
		logout.setLayout(null);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Dialog", Font.BOLD, 14));
		lblLogout.setBounds(70, 0, 180, 40);
		logout.add(lblLogout);
	}
}

public void menuclicked(JPanel panel) {
	home.setVariable("false");
	staff.setVariable("false");
}

class PanelButtonMouseAdapter extends MouseAdapter{
	JPanel panel;
	public PanelButtonMouseAdapter(JPanel panel) {
		this.panel=panel;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(204, 51, 51));
	}
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(204, 51, 51));
	}
	public void mousePressed(MouseEvent e) {
		panel.setBackground(new Color(204, 51, 51));
	}
	public void mouseRelease(MouseEvent e) {
		panel.setBackground(new Color(204, 51, 51));
	}
	
}