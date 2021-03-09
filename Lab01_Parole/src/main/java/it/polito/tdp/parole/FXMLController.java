package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnCancella;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double inizio = System.nanoTime();
    	String p =txtParola.getText().toLowerCase();
    	elenco.addParola(p);
    	double fine = System.nanoTime();
    	txtTempi.setText("Per aggiungere la parola "+p+" sono necessari "+ (fine -inizio) +" nanosecondi");
    	btnReset.setDisable(false);
    	btnCancella.setDisable(false);
    	elenco.getElenco();
    	for (String s: elenco.getElenco()) {
    		txtResult.setText(elenco.toString());
    	}
    	
    	txtParola.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.setText("");
    	txtParola.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String s= txtResult.getSelectedText();
    	double inizio = System.nanoTime();
    	elenco.cancellaParola(s);
    	double fine = System.nanoTime();
    	txtTempi.setText("Per rimuovere la parola "+s+" sono necessari "+ (fine - inizio)+" nanosecondi");
    	for (String ss: elenco.getElenco()) {
    		txtResult.setText(elenco.toString());
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
