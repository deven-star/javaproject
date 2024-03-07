package COM.EMPOLYEE.FACTORY;

import COM.EMPLOYEE.SERVICE.EmployeeService;
import COM.EMPLOYEE.SERVICE.EmployeeServiceImp;

public class EmployeeServiceFactory {
	
	private static EmployeeService eeservice;
	static 
	{
		eeservice = new EmployeeServiceImp();
	}
	public static EmployeeService getEmployeeService()
	{
		return eeservice;
	}

}
