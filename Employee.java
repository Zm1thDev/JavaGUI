import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Employee {
	//เพิ่ม,อัพเดท,ลบ ข้อมูล
	public void InsertUpdateDeleteEmployee(char operation,Integer id,String fname,String lname,
			                                                  String sex,String job,String salary,String phone,
			                                                  String address) {
		
		Connection con = Myconnection.getConection();
		PreparedStatement ps;
		
		// add data
		if(operation == 'i') {
			try {
				ps = con.prepareStatement("INSERT INTO companyemployee(first_name, last_name, sex, job, salary, phone, address) VALUES (?,?,?,?,?,?,?)");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, job);
				ps.setString(5, salary);
				ps.setString(6, phone);
				ps.setString(7, address);
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null,"New Employee Add");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// edit and update data
		if(operation == 'u') {
			try {
				ps = con.prepareStatement("UPDATE `companyemployee` SET `first_name`= ?, `last_name`= ?, `sex`= ?,`job`= ?,`salary`= ?, `phone`= ?, `address`= ? WHERE `id`= ?");
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, sex);
				ps.setString(4, job);
				ps.setString(5, salary);
				ps.setString(6, phone);
				ps.setString(7, address);
				ps.setInt(8, id);
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null,"Employee Data Update");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// delete data
		if(operation == 'd') {
			try {
				ps = con.prepareStatement("DELETE FROM `companyemployee` WHERE `id` = ?");
				ps.setInt(1, id);
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null,"Employee Deleted");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//นำข้อมูลมาโชในตารางและค้นหา
    public void fillEmployeetable(JTable table,String ValueToSearch) {
    	Connection con = Myconnection.getConection();
		PreparedStatement ps;
		
		try {
			ps = con.prepareStatement("SELECT * FROM `companyemployee` WHERE CONCAT(`first_name`,`last_name`,`job`,`salary`,`phone`,`address`)LIKE ?");
			ps.setString(1,"%"+ ValueToSearch + "%");
			
			ResultSet rs = ps.executeQuery();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			Object[]row;
			
			while(rs.next()) {
				row = new Object[8];
				row[0] = rs.getInt(1);
				row[1] = rs.getString(2);
				row[2] = rs.getString(3);
				row[3] = rs.getString(4);
				row[4] = rs.getString(5);
				row[5] = rs.getString(6);
				row[6] = rs.getString(7);
				row[7] = rs.getString(8);
				
				model.addRow(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
