public class Person {
	private String name;
	private String surname;
	private String pesel;
	
	public Person(String surname, String name, String pesel)
	{
		this.name = name;
		this.surname = surname;
		this.pesel = pesel;
	}
	public String toString() {
		return (surname+" | "+name+" | "+pesel+" | ");
	}
	
	public void set_surname(String surname)
	{
		this.surname = surname;
	}
	public void set_name(String name)
	{
		this.name = name;
	}
	public void set_pesel(String pesel)
	{
		this.pesel = pesel;
	}
	
	public String get_nazwisko()
	{
		return surname;
	}
	public String get_imie()
	{
		return name;
	}
	public String get_pesel()
	{
		return pesel;
	}
	
	public void printPerson()
	{
		System.out.println(surname + " | "+ name + " | " + pesel);
	}
}
