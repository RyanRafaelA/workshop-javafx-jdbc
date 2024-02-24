package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alertas;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
	public void sobreBtNovoAcao(ActionEvent evento) {
		Stage estagioParente = Utils.estagioAtual(evento);
		
		criarFormularioDialogo("/gui/DepartamentoFormulario.fxml", estagioParente);
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
	
	private void criarFormularioDialogo(String nomeAbsoluto, Stage estagioParente) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			Pane painel = loader.load();
			
			Stage estagioDialogo = new Stage();
			estagioDialogo.setTitle("Entre data Departamento");
			estagioDialogo.setScene(new Scene(painel));
			estagioDialogo.setResizable(false);
			estagioDialogo.initOwner(estagioParente);
			estagioDialogo.initModality(Modality.WINDOW_MODAL);
			estagioDialogo.showAndWait();
		}
		catch(IOException e) {
			Alertas.showAlert("IO Esception", "Erro no carregamento da view", e.getMessage(), AlertType.ERROR);
		}
	}

}
