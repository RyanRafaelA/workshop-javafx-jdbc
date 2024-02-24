package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Restricoes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleFormularioDepartamento implements Initializable{
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label erroNomeLabel;
	
	@FXML
	private Button btSalve;
	
	@FXML
	private Button btCancelar;
	
	@FXML
	public void sobreBtAcaoSalva() {
		System.out.println("sobreBtAcaoSalva");
	}
	
	@FXML
	public void sobreBtAcaoCancelar() {
		System.out.println("sobreBtAcaoCancelar");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		inicializacaoNos();
		
	}
	
	private void inicializacaoNos() {
		Restricoes.setTextFieldInteiro(txtId);
		Restricoes.setTexteFieldComprimentoMax(txtNome, 30);
	}
}
