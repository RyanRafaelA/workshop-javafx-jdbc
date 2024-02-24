package modelo.servico;

import java.util.List;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDao;
import modelo.entidades.Departamento;

public class DepartamentoServico {
	
	private DepartamentoDao dao =  FabricaDao.criaDepartamentoDao();
	
	public List<Departamento> buscarTudo(){
		return dao.procurarTudo();
	}

}