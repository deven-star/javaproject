package COM.EMPLOYEE.SERVICE;

import COM.EMPLOYEE.BIN.Employee;

public interface EmployeeService {
	
	String addEmployee(Employee etd);
	Employee searchEmployee(String eid);
	String updateEmployee (Employee etd );
	String deleteEmployee (String eid);

}
