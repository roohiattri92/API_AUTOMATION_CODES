package POJO_ex_Complete_;


/* "name":"ramanpreet",
 "job":"Leader",
 "salary":"45567",
 "location":"banglore",
 "address":
 {
 "street":"parkstreet",
 "city":"delhi",
 "pincode":"143512",
 "state":"ncr"
 }
 }
 
*/

public class Employee1Pojo_parents 
{
	
	
	private String name;
    private String job;
    private double salary;
    private String location;
    private Employee_address_child empaddress; //have to take refence of child class in parent class
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee_address_child getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(Employee_address_child empaddress) {
		this.empaddress = empaddress;
	}
    
    
    
    
}