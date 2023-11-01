import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginForm {

	private JFrame frame;
	private JTextField TF_User;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 155, 77));
		panel_1.setBounds(0, 0, 584, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbLogin = new JLabel("Login Form");
		lbLogin.setForeground(new Color(255, 255, 255));
		lbLogin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbLogin.setBounds(208, 11, 176, 40);
		panel_1.add(lbLogin);
		
		JLabel lbUsername = new JLabel("Username : ");
		lbUsername.setForeground(new Color(255, 255, 255));
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbUsername.setBounds(97, 136, 150, 31);
		panel.add(lbUsername);
		
		JLabel lbPassword = new JLabel("Password : ");
		lbPassword.setForeground(Color.WHITE);
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbPassword.setBounds(97, 207, 144, 31);
		panel.add(lbPassword);
		
		TF_User = new JTextField();
		TF_User.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_User.setBounds(268, 136, 205, 31);
		panel.add(TF_User);
		TF_User.setColumns(10);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Tahoma", Font.BOLD, 15));
		Password.setBounds(268, 207, 205, 31);
		panel.add(Password);
		
		JLabel lb_1 = new JLabel("*");
		lb_1.setForeground(new Color(255, 0, 0));
		lb_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_1.setBounds(478, 136, 34, 14);
		lb_1.setVisible(false);
		panel.add(lb_1);
		
		JLabel lb_2 = new JLabel("*");
		lb_2.setForeground(Color.RED);
		lb_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lb_2.setBounds(478, 207, 34, 14);
		lb_2.setVisible(false);
		panel.add(lb_2);
		
		// btn-Login
				JButton btnLogin = new JButton("Login");
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lb_1.setVisible(false);
						lb_2.setVisible(false);
						if(TF_User.getText().equals("")) {
							lb_1.setVisible(true);
						}else if(String.valueOf(Password.getPassword()).equals("")){
							lb_2.setVisible(true);
						}else {
					
							Connection con = Myconnection.getConection();
							PreparedStatement ps;
							
							try {
								ps = con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
								ps.setString(1,TF_User.getText());
								ps.setString(2,String.valueOf(Password.getPassword()));
								
								ResultSet rs = ps.executeQuery();
								
								if(rs.next()) {
									JOptionPane.showMessageDialog(null, "Login Complete");
									EmployeeForm.main(null);
								}else {
									JOptionPane.showMessageDialog(null, "User and Pass Incorrect");
								}
							} catch (SQLException ex) {
								ex.printStackTrace();
							}
						}
					}
				});
				btnLogin.setForeground(new Color(0, 0, 0));
				btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnLogin.setBounds(361, 298, 112, 39);
				panel.add(btnLogin);
				
		// btn-Cancel
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				btnCancel.setForeground(Color.BLACK);
				btnCancel.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnCancel.setBounds(97, 298, 112, 39);
				panel.add(btnCancel);
	}
}
