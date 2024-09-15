package POJO_EX;
//in order to create payload we are using pojo class. pojo place old java object) 
	//it is structred representation of data which will do what key of the json will come into variable to private variable 
	//once we create private variable 
	//set going to set the value.
	//getter method used to get the value which we have used.
	//we want to pass payload 

public class Employee_info_INjava {
	

    private String name;
    private String job;
    private double salary;
    private String location;
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
}
	