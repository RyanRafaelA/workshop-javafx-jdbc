package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alertas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import modelo.servico.DepartamentoServico;

public class ControleVisualizacaoPrincipal implements Initializable {

	@FXML
	private MenuItem menuItemiVendedor;

	@FXML
	private MenuItem menuItemDepartemento;

	@FXML
	private MenuItem menuItemSobre;

	@FXML
	public void sobreMenuItemVendedorAcao() {
		System.out.println("sobreMenuItemVendedorAcao");
	}

	@FXML
	public void sobreMenuItemDepartamentoAcao() {
		carregarVisualizacao("/gui/ListaDepartamento.fxml", (ControleListaDepartamento controle) -> {
			controle.setDepartamentoServico(new DepartamentoServico());
			controle.atualizarTabelaVisualizacao();
		});
	}

	@FXML
	public void sobreMenuItemSobreAcao() {
		carregarVisualizacao("/gui/Sobre.fxml", x -> {});
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {

	} 

	private synchronized <T> void carregarVisualizacao(String nomeAbsoluto, Consumer<T> acaoInicializacao) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(nomeAbsoluto));
			VBox novoVBox = loader.load();
			
			Scene cenaPrincipal = Main.getCenaPrincipal();
			VBox principalVBox = (VBox) ((ScrollPane) cenaPrincipal.getRoot()).getContent();
			
			Node menuPrincipal = principalVBox.getChildren().get(0);
			principalVBox.getChildren().clear();
			principalVBox.getChildren().add(menuPrincipal);
			principalVBox.getChildren().addAll(novoVBox.getChildren());
			
			T controle = loader.getController();
			acaoInicializacao.accept(controle);
		} catch (IOException e) {
			Alertas.showAlert("IO Exception", "Erro ao carregar visualização", e.getMessage(), AlertType.ERROR);
		}
	}
}
