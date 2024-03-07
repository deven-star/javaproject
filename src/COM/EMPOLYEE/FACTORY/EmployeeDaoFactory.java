package COM.EMPOLYEE.FACTORY;

import COM.EMPLOYEE.DAO.EmployeeDao;
import COM.EMPLOYEE.DAO.*;

public class EmployeeDaoFactory {
	
	private static EmployeeDao eedao;
	static 
	{
		eedao = new EmployeeDaoImp();
		
	}
	public static EmployeeDao getEmployeeDao()
	{
		return eedao;
	}

}



