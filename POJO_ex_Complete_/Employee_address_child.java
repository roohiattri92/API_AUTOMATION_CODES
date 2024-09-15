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

public class Employee_address_child 
{
	private String street;
	private String city;
	private String state;
	private double pincode;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getPincode() {
		return pincode;
	}
	public void setPincode(double pincode) {
		this.pincode = pincode;
	}

}
