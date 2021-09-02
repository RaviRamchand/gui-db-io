package application;

public abstract class Person implements Comparable<Person>{
	//Fields
	protected String _fullName;
	private String _address;

	//Constructors
	public Person(String newName, String newAddress){
		_fullName = newName;
		_address = newAddress;

	}

	@Override
	public String toString(){
		return (_fullName+ ", "+ _address);
	}
	
	//Abstract methods
	public abstract String currentStatus();
	//Interface method
	public abstract int compareTo(Person p);

	
}
