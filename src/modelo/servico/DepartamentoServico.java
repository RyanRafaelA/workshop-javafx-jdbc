package modelo.servico;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Departamento;

public class DepartamentoServico {
	
	public List<Departamento> buscarTudo(){
		List<Departamento> lista = new ArrayList<>();
		
		lista.add(new Departamento(1, "Livros"));
		lista.add(new Departamento(2, "Computadores"));
		lista.add(new Departamento(3, "Eletronicos"));
		
		return lista;
	}

}