package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	
	static {
		lista.add(new Empresa("Sacola do Bebê", new Date()));
		lista.add(new Empresa("Alura", new Date()));
		lista.add(new Empresa("Celum", new Date()));
	}
	
	
	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}
	
}
