package COM.EMPLOYEE.DAO;

import COM.EMPLOYEE.BIN.Employee;

public interface EmployeeDao {
	
	String add(Employee etd);
	Employee search(String eid );
	String  update(Employee etd);
	String delete (String eid);
	

}
