package COM.EMPLOYEE.SERVICE;

import COM.EMPLOYEE.BIN.Employee;
import COM.EMPLOYEE.DAO.EmployeeDao;
import COM.EMPOLYEE.FACTORY.EmployeeDaoFactory;

public class EmployeeServiceImp implements EmployeeService {

	@Override
	public String addEmployee(Employee etd) {
	
		EmployeeDao edao= EmployeeDaoFactory.getEmployeeDao();
		String status= edao.add(etd);
		
		return status;
	}

	@Override
	public Employee searchEmployee(String eid) {
		EmployeeDao edao = EmployeeDaoFactory.getEmployeeDao();
		Employee etd=edao.search(eid);
		return etd;
	}

	@Override
	public String updateEmployee(Employee etd) {
		EmployeeDao edao = EmployeeDaoFactory.getEmployeeDao();
		String status = edao.update(etd);
		return status;
	}

	@Override
	public String deleteEmployee(String eid) {
		EmployeeDao edao=EmployeeDaoFactory.getEmployeeDao();
		String status=edao.delete(eid);
		
		return status;
	}

}
