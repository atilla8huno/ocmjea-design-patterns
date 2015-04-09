package com.oracle.ocmjea.gof.behavioral.visitor;

public interface ComputerPartVisitor {

	void visit(Computer computer);
	void visit(Mouse mouse);
	void visit(Teclado teclado);
	void visit(Monitor monitor);
}
