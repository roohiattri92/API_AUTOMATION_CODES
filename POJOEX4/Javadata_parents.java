package POJOEX4;

import java.util.List;

/*{
    "name": "Tom",
    "job": "Leader",
    "salary": 45000.0,
    "location": "Delhi",
    
    "bankAccount": [
        "SBI",
        "HDFC",
        "AXIS"
    ],
    
    "empaddress": {
        "street": "Parkstreet",
        "city": "Delhi",
        "pincode": 700033,
        "state": "NCR"
    }
}
*/
public class Javadata_parents 
{
   private String name;
 private String job;
   private String salary;
   private String location;
  private Java_data1CHILD empaddress ;
	private List <String> Bank;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Java_data1CHILD getEmpaddress() {
		return empaddress;
	}
	public void setEmpaddress(Java_data1CHILD empaddress) {
		this.empaddress = empaddress;
	}
	public List<String> getBank() {
		return Bank;
	}
	public void setBank(List<String> bank) {
		Bank = bank;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
