package com.oracle.ocmjea.gof.behavioral.command;

public class ArquivoInvoker {

	public Comando comando;

	public ArquivoInvoker(Comando comando) {
		this.comando = comando;
	}

	public void execute() {
		comando.execute();
	}
}
