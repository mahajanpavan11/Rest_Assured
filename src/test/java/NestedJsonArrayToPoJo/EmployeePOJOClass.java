package NestedJsonArrayToPoJo;

public class EmployeePOJOClass {
/*	{
  "firstName": "pavan",
  "lastName": "mahajan",
  "gender": "Male",
  "age": 30,
  "salary:10000.56,
  "Address":{
	       "Street": "koli wada",
	       "City": "Thane Mumbai",
	       "State": "Maharastra",
	       "pin code":400601
        }
}                     */

	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double sallary;
	private employeeAddress address;
	
	// create getters and setters method
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	
	public double getSallary() 
	{
		return sallary;
	}
	public void setSallary(double sallary) 
	{
		this.sallary = sallary;
	}
	
	
	public employeeAddress getAddress() 
	{
		return address;
	}
	public void setAddress(employeeAddress address) 
	{
		this.address = address;
	} 

}
