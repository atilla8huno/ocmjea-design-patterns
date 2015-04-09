package com.oracle.ocmjea.gof.behavioral.visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		System.out.println("Mostrando Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Mostrando Mouse.");
	}

	@Override
	public void visit(Teclado teclado) {
		System.out.println("Mostrando Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Mostrando Monitor.");
	}
}
