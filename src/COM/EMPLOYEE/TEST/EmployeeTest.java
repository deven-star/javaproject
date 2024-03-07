package COM.EMPLOYEE.TEST;

import java.io.BufferedReader;
import java.io.InputStreamReader;



import COM.EMPLOYEE.BIN.Employee;
import COM.EMPLOYEE.SERVICE.EmployeeService;
import COM.EMPOLYEE.FACTORY.EmployeeServiceFactory;


public class EmployeeTest  {
	
	public static void main(String[] args) {
	
	
	
	
		try {
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
			System.out.println("******************************");
			
			System.out.println("SELECT ONE OF FOLLOWING OPTIONS");
			System.out.println("1.ADD RECORD");
			System.out.println("2.SEARCH RECORD");
			System.out.println("3.UPDATE RECORD");
			System.out.println("4.DELETE RECORD");
			System.out.println("5.EXIT");
			
			int option=Integer.parseInt(br.readLine());
			
			Employee etd = new Employee();//bin  class object
			String eid,ename,eaddr,esal,status;
			EmployeeService eservice = EmployeeServiceFactory.getEmployeeService() ;
			
			
			switch(option)
			{
			case 1:
				
				
				System.out.println("Enter Unique Employee ID");
				 eid = br.readLine();
				
				System.out.println("Enter  Employee Name");
				 ename = br.readLine();
				
				System.out.println("Enter  Employee Address");
				 eaddr = br.readLine();
				
				 System.out.println("Enter Epmloyee SALARY");
				esal=br.readLine();
				
			//	etd= new Employee();
				
				etd.setEid(eid);
				etd.setEname(ename);
				etd.setEaddr(eaddr);
				etd.setEsal(esal);
				status = eservice.addEmployee(etd);
			
				System.out.println("Status :"+status );
			
			break;
			
			case 2:
				System.out.println("**************************");
				System.out.println("Enter Employee ID:");
				eid=br.readLine();
				etd=eservice.searchEmployee(eid);
				if(etd==null)
				{
					System.out.println("NO EMPLOYEE PRESENT ON THIS ID: "+eid);
					
				}
				else
				{
					System.out.println("*******************EMPLOYEE ID "+etd.getEid()+"******************");
					System.out.println("NAME:"+etd.getEname());
					System.out.println("ADDRESS:"+etd.getEaddr());
					System.out.println("SALARY:"+etd.getEsal());
					
				}
				
				
				
				
				break;
				
			case 3:
				System.out.println("**************************");
				System.out.println("Enter Employee ID:");
				eid=br.readLine();
				
				etd=eservice.searchEmployee(eid);
				
				if(etd==null)
				{
					System.out.println("NO RECORD FOUND");
				}
				else
				{  
			         System.out.println("****************UPDATING EMPLOYEE ID :  "+etd.getEid()+"****************");
				      System.out.println("EMPLOYEE NAME'"+etd.getEname()+"'UPDATED NAME OR PRESS ENTER TO SKIP :");
				
				      String new_name= br.readLine();
				
				
				
				      if(new_name==null || new_name.equals(""))
				     { 
					       new_name=etd.getEname();
					
				        }
				System.out.println("EMPLOYEE ADDRESS : '"+etd.getEaddr()+"'UPDATE NAME OR PRESS ENTER TO SKIP ");
				String new_addr = br.readLine();
				if(new_addr==null||new_addr.equals(""))
				{
					
							new_addr=etd.getEaddr();
							
							
				}
				System.out.println("EMPLOYEE SALARY:'"+etd.getEsal()+"'UPDATE SALARY OR PRESS ENTER TO SKIP ");
				String new_salary=br.readLine();
				if(new_salary == null||new_salary.equals(""))
				{
					new_salary=etd.getEsal();
				}
				
				Employee new_etd=new Employee();
				new_etd.setEid(eid);
				new_etd.setEname(new_name);
				new_etd.setEaddr(new_addr);
				new_etd.setEsal(new_salary);
				
				
				 status=eservice.updateEmployee(new_etd);
				 
				 System.out.println("STATUS :"+status );
				 
				
							
				}
				break;
			case 4:
				System.out.println("ENTER EMPLOYEE UNIQUE ID:");
				 eid=br.readLine();
				 etd.setEid(eid);
				 
				 
				 
				status=eservice.deleteEmployee(eid);
				System.out.println("STATUS:"+status );
				
				break;
			case 5:
				   System.out.println("HAVE A NICE WORK-DAY,VISIT AGAIN");
				   System.exit(0);
				  
				default:
					System.out.println("INVALID OPTION");
					break;
				}
				
				
				
			
			
			
			
				
				
				
				
				
				
				
			
			}}
			
			
		 catch (Exception e) {
			e.printStackTrace();
		}
	
		
	


}}
