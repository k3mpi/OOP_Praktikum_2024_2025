package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.TeesorteModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class TeesorteView {
	
	
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblName 					= new Label("Name:");
    private Label lblGeoeffnetVon   		= new Label("GeÃ¶ffnet von:");
    private Label lblGeoeffnetBis  	 		= new Label("GeÃ¶ffnet bis:");
    private Label lblStrasseHNr   			= new Label("StraÃŸe und Hausnummer:");
    private Label lblDienstleistungen  		= new Label("Dienstleistungen:");
    private TextField txtArtikelNummer			= new TextField();
    private TextField txtBezeichnung		= new TextField();
    private TextField txtKategorie		= new TextField();
    private TextField txtMitKoffein		= new TextField();
    private TextField txtEnthalteneKraeuter	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");    
    //-------Ende Attribute der grafischen Oberflaeche-------
	
	
	private TeesorteModel model = null;
	private TeesorteControl control = null;
	
	
	public TeesorteView(Stage s, TeesorteControl control, TeesorteModel model) {
		System.out.println("view_init");
		this.model = model;
		this.control = control;
		
		Scene scene = new Scene(this.pane, 700, 340);
    	s.setScene(scene);
    	s.setTitle("Verwaltung von BÃ¼rgerÃ¤mtern");
    	s.show();
    	this.initKomponenten();
		this.initListener();
	}
	
	private void initKomponenten(){
		// Labels
	    lblEingabe.setLayoutX(20);
	   	lblEingabe.setLayoutY(40);
	    Font font = new Font("Arial", 24); 
	   	lblEingabe.setFont(font);
	   	lblEingabe.setStyle("-fx-font-weight: bold;"); 
	   	lblAnzeige.setLayoutX(400);
	   	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
	    lblAnzeige.setStyle("-fx-font-weight: bold;"); 
    	lblName.setLayoutX(20);	    	
    	lblName.setLayoutY(90);
	    lblGeoeffnetVon.setLayoutX(20);
	    lblGeoeffnetVon.setLayoutY(130);
	    lblGeoeffnetBis.setLayoutX(20);
	    lblGeoeffnetBis.setLayoutY(170);
	    lblStrasseHNr.setLayoutX(20);
	    lblStrasseHNr.setLayoutY(210);
	    lblDienstleistungen.setLayoutX(20);
	    lblDienstleistungen.setLayoutY(250);    	
	    pane.getChildren().addAll(lblEingabe, lblAnzeige, 
	    lblName, lblGeoeffnetVon, lblGeoeffnetBis,
   		lblStrasseHNr, lblDienstleistungen);
	    
	    	// Textfelder
	     	txtArtikelNummer.setLayoutX(170);
	    	txtArtikelNummer.setLayoutY(90);
	    	txtArtikelNummer.setPrefWidth(200);
	    	txtBezeichnung.setLayoutX(170);
	    	txtBezeichnung.setLayoutY(130);
	    	txtBezeichnung.setPrefWidth(200);
	    	txtKategorie.setLayoutX(170);
	    	txtKategorie.setLayoutY(170);
	    	txtKategorie.setPrefWidth(200);
	      	txtMitKoffein.setLayoutX(170);
	    	txtMitKoffein.setLayoutY(210);
	    	txtMitKoffein.setPrefWidth(200);
	    	txtEnthalteneKraeuter.setLayoutX(170);
	    	txtEnthalteneKraeuter.setLayoutY(250);
	    	txtEnthalteneKraeuter.setPrefWidth(200);
	      	pane.getChildren().addAll( 
	     		txtArtikelNummer, txtBezeichnung, txtKategorie,
	     		txtMitKoffein, txtEnthalteneKraeuter);
	     	
	        // Textbereich	
	        txtAnzeige.setEditable(false);
	     	txtAnzeige.setLayoutX(400);
	    	txtAnzeige.setLayoutY(90);
	     	txtAnzeige.setPrefWidth(270);
	    	txtAnzeige.setPrefHeight(185);
	       	pane.getChildren().add(txtAnzeige); 
	       	
	        // Buttons
	        btnEingabe.setLayoutX(20);
	        btnEingabe.setLayoutY(290);
	        btnAnzeige.setLayoutX(400);
	        btnAnzeige.setLayoutY(290);
	        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
	        
	 		// Menue
	  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
	  	    this.mnDatei.getItems().add(mnItmCsvImport);
	  	    this.mnDatei.getItems().add(mnItmTxtImport);
	  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
	  	    this.mnDatei.getItems().add(mnItmCsvExport);
	 	    pane.getChildren().add(mnbrMenuLeiste);
	   }


	private void initListener() {
		    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	        	    control.nehmeBuergeramtAuf();
	            }
		    });
		    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		            control.zeigeBuergeraemterAn();
		        } 
	   	    });
		    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
		    	@Override
		        public void handle(ActionEvent e) {
		       	 	control.leseAusDatei("csv");
		    	}
		    });
		    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			    @Override
			    public void handle(ActionEvent e) {
			     	control.leseAusDatei("txt");
			    }
	    	});
		    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					control.schreibeBuergeraemterInCsvDatei();
				}	
		    });
	 }
	
	
	
	public String getArtikelNummer(){
		
		return txtArtikelNummer.getText();
	}
	
	public String getBezeichnung() {
		return txtBezeichnung.getText();
	}
	
	public String getKategorie() {
		
		return txtKategorie.getText();
	}
	
	public String getMitKoffein() {
		return txtMitKoffein.getText();
	}
	
	public String getInhalt() {
		return txtEnthalteneKraeuter.getText();
	}
	
	
	public void setAnzeige(String text){
		txtAnzeige.setText(text);
	}
	
	
}
	
	

	