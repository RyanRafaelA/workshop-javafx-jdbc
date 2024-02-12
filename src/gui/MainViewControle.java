package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewControle implements Initializable{

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
		System.out.println("sobreMenuItemDepartamentoAcao");
	}
	
	@FXML
	public void sobreMenuItemSobreAcao() {
		System.out.println("sobreMenuItemSobreAcao");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		
	}
	

}
