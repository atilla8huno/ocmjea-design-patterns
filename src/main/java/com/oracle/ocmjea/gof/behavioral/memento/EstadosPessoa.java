package com.oracle.ocmjea.gof.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class EstadosPessoa {

	private List<PessoaOld> estadosDaPessoa = new ArrayList<PessoaOld>();

	public void add(PessoaOld state) {
		estadosDaPessoa.add(state);
	}

	public PessoaOld get(int index) {
		return estadosDaPessoa.get(index);
	}
}
