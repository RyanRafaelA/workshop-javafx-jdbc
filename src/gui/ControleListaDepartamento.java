package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.entidades.Departamento;

public class ControleListaDepartamento implements Initializable{
	
	@FXML
	private TableView<Departamento> tabelaDepartamento;
	
	@FXML
	private TableColumn<Departamento, Integer> colunaTabelaId;
	
	@FXML
	private TableColumn<Departamento, String> colunaTabelaNome;
	
	@FXML
	private Button btNovo;
	
	@FXML
	public void sobreBtNovoAcao() {
		System.out.println("sobreBtNovoAcao");
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

}
