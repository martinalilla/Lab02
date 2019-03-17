package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	private DizionarioAlieno dictionary ;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
   
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
        

        dictionary=new DizionarioAlieno();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String s=txtWord.getText();
    	String[] parole=s.split(" ");
    	String pattern="[a-z]*";
    	
    	/*if(dictionary.formatoNonValido(parole[0])==true) {
    		txtResult.clear();
    		txtResult.appendText("Formato non valido!");
    	}*/
    	
    	if(parole.length==2) {
    		
    		if(!parole[0].matches(pattern)||!parole[1].matches(pattern)) {
    			txtResult.appendText("Formato non valido!");
    		}
    		else {
    			boolean b=dictionary.addWord(parole[0], parole[1]);
    			
    			txtResult.clear();
    			
    			txtWord.clear();
    			if(b==false) {
    				txtResult.appendText("Parola aggiunta!");
    			}
    			if(b==true) {
    				txtResult.appendText("Parola modificata!");
    			}
    		}
    		
    	}
    	
    	if(parole.length==1) {
    		
    		if(!parole[0].matches(pattern)) {
    			txtResult.appendText("Formato non valido!");
    		}
    		else {
    			String str=dictionary.translateWord(parole[0]);
    			if(str==null) {
    				txtResult.clear();
            		txtWord.clear();
            		txtResult.appendText("Questa parola non e' ancora presente nel dizionario!");
    			}
    			if(str!=null) {
        		txtResult.clear();
        		txtWord.clear();
        		
        		txtResult.appendText("Traduzione: "+str);
    			}
    		}
    		
    		}
    	}
    	    	
    
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	dictionary.elimina();
    	

    }
    
}
