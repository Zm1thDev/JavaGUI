import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeForm {

	private JFrame frame;
	private JTextField TF_ID;
	private JTextField TF_Fname;
	private JTextField TF_Lname;
	private JTextField TF_Salary;
	private JTextField TF_Phone;
	private JTable table;
	private JTextField TF_Search;
	private JTextField TF_Job;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm window = new EmployeeForm();
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
	Employee emy = new Employee();
	public EmployeeForm() {
		initialize();
		emy.fillEmployeetable(table, "");
		table.setRowHeight(30);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ButtonGroup bg = new ButtonGroup();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(242, 155, 77));
		panel_1.setBounds(0, 0, 1184, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbMEmployee = new JLabel("Manage Employee");
		lbMEmployee.setForeground(new Color(255, 255, 255));
		lbMEmployee.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbMEmployee.setBounds(439, 11, 283, 50);
		panel_1.add(lbMEmployee);
		
		JLabel lbID = new JLabel("ID : ");
		lbID.setForeground(new Color(255, 255, 255));
		lbID.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbID.setBounds(136, 113, 40, 25);
		panel.add(lbID);
		
		JLabel lbFname = new JLabel("Frist name : ");
		lbFname.setForeground(new Color(255, 255, 255));
		lbFname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbFname.setBounds(64, 157, 112, 22);
		panel.add(lbFname);
		
		JLabel lbLname = new JLabel("Last name : ");
		lbLname.setForeground(Color.WHITE);
		lbLname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbLname.setBounds(64, 206, 112, 22);
		panel.add(lbLname);
		
		JLabel lbJposition = new JLabel("Job position : ");
		lbJposition.setForeground(Color.WHITE);
		lbJposition.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbJposition.setBounds(48, 317, 124, 22);
		panel.add(lbJposition);
		
		JLabel lbSalary = new JLabel("Salary  : ");
		lbSalary.setForeground(Color.WHITE);
		lbSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbSalary.setBounds(96, 370, 78, 22);
		panel.add(lbSalary);
		
		JLabel lbPhone = new JLabel("Phone  : ");
		lbPhone.setForeground(Color.WHITE);
		lbPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPhone.setBounds(96, 427, 80, 22);
		panel.add(lbPhone);
		
		JLabel lbSex = new JLabel("Sex : ");
		lbSex.setForeground(Color.WHITE);
		lbSex.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbSex.setBounds(121, 259, 50, 22);
		panel.add(lbSex);
		
		JLabel lbAddress = new JLabel("Address : ");
		lbAddress.setForeground(Color.WHITE);
		lbAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAddress.setBounds(85, 485, 91, 22);
		panel.add(lbAddress);
		
		TF_ID = new JTextField();
		TF_ID.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_ID.setBounds(186, 116, 78, 25);
		panel.add(TF_ID);
		TF_ID.setColumns(10);
		
		TF_Fname = new JTextField();
		TF_Fname.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Fname.setColumns(10);
		TF_Fname.setBounds(186, 161, 200, 25);
		panel.add(TF_Fname);
		
		TF_Lname = new JTextField();
		TF_Lname.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Lname.setColumns(10);
		TF_Lname.setBounds(186, 210, 200, 25);
		panel.add(TF_Lname);
		
		JRadioButton RDOBT_Male = new JRadioButton("Male");
		RDOBT_Male.setFont(new Font("Tahoma", Font.BOLD, 15));
		RDOBT_Male.setBounds(186, 258, 67, 27);
		bg.add(RDOBT_Male);
		panel.add(RDOBT_Male);
		
		JRadioButton RDOBT_Female = new JRadioButton("Female");
		RDOBT_Female.setFont(new Font("Tahoma", Font.BOLD, 15));
		RDOBT_Female.setBounds(278, 258, 85, 27);
		bg.add(RDOBT_Female);
		panel.add(RDOBT_Female);
		
		TF_Job = new JTextField();
		TF_Job.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Job.setColumns(10);
		TF_Job.setBounds(186, 317, 200, 25);
		panel.add(TF_Job);
		
		TF_Salary = new JTextField();
		TF_Salary.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {  //Salary รับเฉพาะตัวเลข
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();		
				}
			}
		});
		TF_Salary.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Salary.setColumns(10);
		TF_Salary.setBounds(184, 370, 200, 25);
		panel.add(TF_Salary);
		
		TF_Phone = new JTextField();
		TF_Phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {   //Password รับเฉพาะตัวเลข
				if(!Character.isDigit(e.getKeyChar())) {
					e.consume();		
				}
			}
		});
		TF_Phone.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Phone.setColumns(10);
		TF_Phone.setBounds(182, 427, 200, 25);
		panel.add(TF_Phone);
		
		JTextArea TA_Address = new JTextArea();
		TA_Address.setFont(new Font("Tahoma", Font.BOLD, 15));
		TA_Address.setBounds(186, 487, 280, 70);
		panel.add(TA_Address);
		
		
		// Add data employee
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = TF_Fname.getText();
				String lname = TF_Lname.getText();
				String sex = "Male";
				if(RDOBT_Female.isSelected()) {
					sex = "Female";
				}
				String job = TF_Job.getText();
				String salary = TF_Salary.getText();
				String phone = TF_Phone.getText();
				String address = TA_Address.getText();
				
			    emy.InsertUpdateDeleteEmployee('i', null, fname, lname, sex, job, salary, phone, address);
			    table.setModel(new DefaultTableModel(null,new Object[] {"ID","First Name","Last Name","Sex","Job Position","Salary","Phone","Address"}));
			    emy.fillEmployeetable(table,"");
			    
			    TF_ID.setText("");
			    TF_Fname.setText("");
			    TF_Lname.setText("");
			    RDOBT_Male.setSelected(false);
			    RDOBT_Female.setSelected(false);
			    TF_Job.setText("");
			    TF_Salary.setText("");
			    TF_Phone.setText("");
			    TA_Address.setText("");
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(365, 614, 101, 40);
		panel.add(btnAdd);
		
		// Edit data employee
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname = TF_Fname.getText();
				String lname = TF_Lname.getText();
				String sex = "Male";
				if(RDOBT_Female.isSelected()) {
					sex = "Female";
				}
				String job = TF_Job.getText();
				String salary = TF_Salary.getText();
				String phone = TF_Phone.getText();
				String address = TA_Address.getText();
				int id = Integer.valueOf(TF_ID.getText());
				
				emy.InsertUpdateDeleteEmployee('u', id, fname, lname, sex, job, salary, phone, address);
				table.setModel(new DefaultTableModel(null,new Object[] {"ID","First Name","Last Name","Sex","Job Position","Salary","Phone","Address"}));
			    emy.fillEmployeetable(table,"");
			    
			    TF_ID.setText("");
			    TF_Fname.setText("");
			    TF_Lname.setText("");
			    RDOBT_Male.setSelected(false);
			    RDOBT_Female.setSelected(false);
			    TF_Job.setText("");
			    TF_Salary.setText("");
			    TF_Phone.setText("");
			    TA_Address.setText("");
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEdit.setBounds(225, 614, 101, 40);
		panel.add(btnEdit);
		
		// Delete data employee
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TF_ID.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No Employee Selected");
				}else {
					int id = Integer.valueOf(TF_ID.getText());
					emy.InsertUpdateDeleteEmployee('d', id, null, null, null, null, null, null, null);
					table.setModel(new DefaultTableModel(null,new Object[] {"ID","First Name","Last Name","Sex","Job Position","Salary","Phone","Address"}));
				    emy.fillEmployeetable(table,"");
				    
				    TF_ID.setText("");
				    TF_Fname.setText("");
				    TF_Lname.setText("");
				    RDOBT_Male.setSelected(false);
				    RDOBT_Female.setSelected(false);
				    TF_Job.setText("");
				    TF_Salary.setText("");
				    TF_Phone.setText("");
				    TA_Address.setText("");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(85, 614, 101, 40);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 157, 650, 497);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {  //เมื่อคลิกที่ข้อมูลจะไปโชในช่องกรอกข้อมูล
				int rowIndex = table.getSelectedRow();
				DefaultTableModel  model = (DefaultTableModel) table.getModel();
				
				if(model.getValueAt(rowIndex,3).toString().equals("Male")) {
					RDOBT_Male.setSelected(true);
					RDOBT_Female.setSelected(false);
				}else {
					RDOBT_Male.setSelected(false);
					RDOBT_Female.setSelected(true);
				}
				
				TF_ID.setText(model.getValueAt(rowIndex, 0).toString());
				TF_Fname.setText(model.getValueAt(rowIndex, 1).toString());
				TF_Lname.setText(model.getValueAt(rowIndex, 2).toString());
				TF_Job.setText(model.getValueAt(rowIndex, 4).toString());
				TF_Salary.setText(model.getValueAt(rowIndex, 5).toString());
				TF_Phone.setText(model.getValueAt(rowIndex, 6).toString());
				TA_Address.setText(model.getValueAt(rowIndex, 7).toString());
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {  //กดแป้นพิมลูกศรขึ้น-ลง ข้อมูลจะไปโชในช่องกรอกข้อมูล
				int rowIndex = table.getSelectedRow();
				DefaultTableModel  model = (DefaultTableModel) table.getModel();
				if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
					if(model.getValueAt(rowIndex,3).toString().equals("Male")) {
						RDOBT_Male.setSelected(true);
						RDOBT_Female.setSelected(false);
					}else {
						RDOBT_Male.setSelected(false);
						RDOBT_Female.setSelected(true);
					}
					
					TF_ID.setText(model.getValueAt(rowIndex, 0).toString());
					TF_Fname.setText(model.getValueAt(rowIndex, 1).toString());
					TF_Lname.setText(model.getValueAt(rowIndex, 2).toString());
					TF_Job.setText(model.getValueAt(rowIndex, 4).toString());
					TF_Salary.setText(model.getValueAt(rowIndex, 5).toString());
					TF_Phone.setText(model.getValueAt(rowIndex, 6).toString());
					TA_Address.setText(model.getValueAt(rowIndex, 7).toString());
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Frist name", "Last name", "Sex", "Job position", "Salary", "Phone", "Address"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lbSearch = new JLabel("Search : ");
		lbSearch.setForeground(Color.WHITE);
		lbSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbSearch.setBounds(495, 113, 80, 25);
		panel.add(lbSearch);
		
		TF_Search = new JTextField();
		TF_Search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) { //ค้นหาข้อมูล ชื่อ
				table.setModel(new DefaultTableModel(null,new Object[] {"ID", "Frist name", "Last name", "Sex", "Job position", "Salary", "Phone", "Address"}));
			    emy.fillEmployeetable(table, TF_Search.getText());
			}
		});
		TF_Search.setFont(new Font("Tahoma", Font.BOLD, 15));
		TF_Search.setColumns(10);
		TF_Search.setBounds(585, 113, 560, 25);
		panel.add(TF_Search);
		
	}
}
