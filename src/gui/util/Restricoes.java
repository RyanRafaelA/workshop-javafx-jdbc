package gui.util;

import javafx.scene.control.TextField;

public class Restricoes {
	
	public static void setTextFieldInteiro(TextField txt) {
		txt.textProperty().addListener((obs, antigoValor, novoValor) -> {
			if(novoValor != null && !novoValor.matches("//d*")) {
				txt.setText(antigoValor);
			}
		});
	}
	
	public static void setTexteFieldComprimentoMax(TextField txt, int max) {
		txt.textProperty().addListener((obs, antigoValor, novoValor) -> {
			if(novoValor != null && novoValor.length() >max) {
				txt.setText(antigoValor);
			}
		});
	}
	
	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, antigoValor, novoValor) -> {
			if(novoValor != null && !novoValor.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(antigoValor);
			}
		});
	}

}
