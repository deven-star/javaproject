package COM.EMPLOYEE.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import COM.EMPLOYEE.BIN.Employee;
import COM.EMPOLYEE.FACTORY.ConnectionFactory;


public class EmployeeDaoImp implements EmployeeDao {
	
	Connection con=ConnectionFactory.getConnection();
	Statement st;
	ResultSet rs ;
	
	
	@Override
	public String add(Employee etd) {
		String status="";
		try {
			
			st=con.createStatement();
			
			rs = st.executeQuery("Select * from employee where eid='"+etd.getEid()+"'");
			boolean b = rs.next();
			
			if(b==true)
			{
				status= "Employee already Existed ";
				
			}
			else
			{
				int rowCount = st.executeUpdate("insert into employee values('"+etd.getEid()+"','"+etd.getEname()+"','"+etd.getEaddr()+"','"+etd.getEsal()+"' )"); 
				
				if(rowCount==1)
				{
					status="Employee record inserted ";
				}
				else
				{
					status="Employee record insertion  Failuer!";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	
	

	
	
	
	
	
	@Override
	public Employee search(String eid) {
	     Employee etd=null;
	     try {
	    	 con=ConnectionFactory.getConnection();
	    	 st=con.createStatement();
	    	 rs=st.executeQuery("select * from employee where eid='"+eid+"'");
	    	boolean b = rs.next();
	    	if(b==true){
	    		 etd = new Employee();
	    		etd.setEid(rs.getString("EID"));
	    		etd.setEname(rs.getString("ENAME"));
	    		etd.setEaddr(rs.getString("EADDR"));
	    		etd.setEsal(rs.getString("esal"));
	    	
	    	}
	    	else
	    	{
	    		
	    	}
	    	
	    	 
	    	 
	     }catch (Exception e) {
			e.printStackTrace();
		}
	     
	     
		return etd;
	}

	@Override
	public String update(Employee etd) {
		String status=" ";
		try 
		{
			Connection con =ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			
			int rowCount=st.executeUpdate("update employee set ename='"+etd.getEname()+"',eaddr='"+etd.getEaddr()+"',esal='"+etd.getEsal()+"' where eid='"+etd.getEid()+"'");
		   if(rowCount==1)
		   {
			   status = "EMPLOYEE RECORD UPDATED";
			   
		   }
		   else
		   {
			   status="UPDATE FAILED";
			   
		   }
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return status;
	}

	@Override
	public String delete(String eid) {
		String status=" ";
		try {

			Connection con =ConnectionFactory.getConnection();
			Statement st=con.createStatement();
		int rowCount=	st.executeUpdate("delete  from employee where eid='"+eid+"'");
		if(rowCount==1) {
			
			System.out.println("EMPLOYEE RECORD DELETED");
		}
		else
		{
			System.out.println("EMPLOYEE RECORD NOT AVAILABLE ON ID : '"+eid+"'");
			
		}
			
			
		}catch (Exception e) {
	         e.printStackTrace();
		}
		return status;
		
	}

}
