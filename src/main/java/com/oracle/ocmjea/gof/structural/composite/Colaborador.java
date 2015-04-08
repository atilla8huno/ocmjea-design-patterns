package com.oracle.ocmjea.gof.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Colaborador {

	private String nome;
	private String departamento;
	private double salario;
	private List<Colaborador> subordinados;
	
	public Colaborador(String nome, String departamento, double salario) {
		this.nome = nome;
		this.departamento = departamento;
		this.salario = salario;
		this.subordinados = new ArrayList<Colaborador>();
	}
	
	public void add(Colaborador colaborador) {
		subordinados.add(colaborador);
	}
	
	public void remove(Colaborador colaborador) {
		subordinados.remove(colaborador);
	}

	public List<Colaborador> getSubordinados() {
		return subordinados;
	}

	@Override
	public String toString() {
		return ("Colaborador :[ Name : " + nome + ", dept : " + departamento + ", salary :" + salario +" ]");
	}
}
