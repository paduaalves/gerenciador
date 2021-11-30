package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {

	private static List<Empresa> lista;
	private static Integer id;

	static {
		lista = new ArrayList<Empresa>();
		lista.add(new Empresa(1, "Sacola do Bebê", new Date()));
		lista.add(new Empresa(2, "Alura", new Date()));
		lista.add(new Empresa(3, "Celum", new Date()));
		Banco.id = 4;
	}

	public static void adiciona(Empresa empresa) {
		empresa.setId(Banco.id);
		Banco.lista.add(empresa);
		Banco.id++;
	}

	public static List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public static void remove(Empresa empresa) {
		Banco.lista.remove(empresa);
	};

	public static Empresa getEmpresa(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId().equals(id)) {
				return empresa;
			}
		}
		return null;
	}
}
