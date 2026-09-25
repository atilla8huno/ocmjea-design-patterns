package modernjava.records;

public record Person(String name, int age) {

	public String introduction() {
		return name + " is " + age + " years old";
	}
}
