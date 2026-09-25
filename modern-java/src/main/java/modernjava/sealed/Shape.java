package modernjava.sealed;

public sealed interface Shape permits Circle, Square {

	double area();
}

record Circle(double radius) implements Shape {

	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
}

record Square(double side) implements Shape {

	@Override
	public double area() {
		return side * side;
	}
}
