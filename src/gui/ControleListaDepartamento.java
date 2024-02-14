package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidades.Departamento;
import modelo.servico.DepartamentoServico;

public class ControleListaDepartamento implements Initializable{
	
	private DepartamentoServico servico;
	
	@FXML
	private TableView<Departamento> tabelaDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> colunaTabelaId;
	
	@FXML
	private TableColumn<Departamento, String> colunaTabelaNome;
	
	@FXML
	private Button btNovo;
	
	private ObservableList<Departamento> obsLista;
	
	@FXML
	public void sobreBtNovoAcao() {
		System.out.println("sobreBtNovoAcao");
	}
	
	public void setDepartamentoServico(DepartamentoServico servico) {
		this.servico = servico;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inicializarNo();
	}

	private void inicializarNo() {
		colunaTabelaId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaTabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		Stage estagio =(Stage) Main.getCenaPrincipal().getWindow();
		tabelaDepartamento.prefHeightProperty().bind(estagio.heightProperty());
	}
	
	public void atualizarTabelaVisualizacao() {
		if(servico == null) {
			throw new IllegalStateException("O servico estava nulo");
		}
		List<Departamento> lista = servico.buscarTudo();
		obsLista = FXCollections.observableArrayList(lista);
		tabelaDepartamento.setItems(obsLista);
	}

}
