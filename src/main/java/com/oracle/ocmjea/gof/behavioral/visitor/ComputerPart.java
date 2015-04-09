package com.oracle.ocmjea.gof.behavioral.visitor;

public interface ComputerPart {

	void accept(ComputerPartVisitor computerPartVisitor);
}
