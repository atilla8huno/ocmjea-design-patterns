package com.oracle.ocmjea.gof.behavioral.visitor;

public class Teclado implements ComputerPart {

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		computerPartVisitor.visit(this);
	}
}
