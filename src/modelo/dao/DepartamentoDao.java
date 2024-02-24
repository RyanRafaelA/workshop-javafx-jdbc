package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;

public interface DepartamentoDao {

	void inserir(Departamento obj);
	void atualizar(Departamento obj);
	void deletarPorId(Integer id);
	Departamento procurarPorId(Integer id);
	List<Departamento> procurarTudo();
}
