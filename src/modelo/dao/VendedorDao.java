package modelo.dao;

import java.util.List;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public interface VendedorDao {
	
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletarPorId(Integer id);
	Vendedor procurarPorId(Integer id);
	List<Vendedor> procurarTudo();
	List<Vendedor> procurarPorDepartamento(Departamento departamento);
}
