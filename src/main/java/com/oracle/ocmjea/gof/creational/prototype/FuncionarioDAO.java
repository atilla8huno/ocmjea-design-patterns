package com.oracle.ocmjea.gof.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements Cloneable {

	private List<String> funcionarios;

	public FuncionarioDAO() {
		funcionarios = new ArrayList<String>();
	}

	public FuncionarioDAO(List<String> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void cargaDados() {
		funcionarios.add("Átilla");
		funcionarios.add("João");
		funcionarios.add("José");
		funcionarios.add("Maria");
		funcionarios.add("Pedro");
	}

	public List<String> getFuncionarios() {
		return funcionarios;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		for (String s : getFuncionarios()) {
			temp.add(s);
		}
		return new FuncionarioDAO(temp);
	}
}
