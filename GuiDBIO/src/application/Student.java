package application;

public class Student extends Person{
	//Fields
	private double _gpa;	
	
	//Constructors 
	public Student(String name, String address, double gpa) {
		super(name, address);
		this._gpa = gpa;
	}
	
	//override toString() from Person.java	
	@Override
	public String toString() {
		return super.toString() +", " +this._gpa;
	}
	
	//implementation of abstract methods 
	public String currentStatus() {
		return "Student";
	}
	@Override
	public int compareTo(Person p) {
		//Compare elements based off of first name
		return this._fullName.compareTo(p._fullName);
	}

}
