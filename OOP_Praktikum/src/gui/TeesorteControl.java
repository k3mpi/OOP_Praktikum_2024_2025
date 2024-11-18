package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Teesorte;
import business.TeesorteModel;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class TeesorteControl {

	
	private TeesorteView view = null;
	private TeesorteModel model = null;
	
	
	
	public TeesorteControl(Stage s) {
		System.out.println("ctrl init");
		this.model = new TeesorteModel();
		this.view = new TeesorteView(s, this, model);
		
	}
	
	void nehmeBuergeramtAuf(){
    	try{
    		this.model.setTeesorte(new Teesorte(
    		Integer.parseInt(this.view.getArtikelNummer()),
   	        this.view.getBezeichnung(),
   	        this.view.getKategorie(),
   	        this.view.getMitKoffein(),
    		this.view.getInhalt()));
    		zeigeInformationsfensterAn("Das BÃ¼rgeramt wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		zeigeFehlermeldungsfensterAn(exc.getMessage());
h     	}
    }
   
    void zeigeBuergeraemterAn(){
    	if(this.model.getTeesorte() != null){
    		this.view.setAnzeige(this.model.getTeesorte().gibBuergeramtZurueck(' '));
    	}
    	else{
    		zeigeInformationsfensterAn("Bisher wurde kein BÃ¼rgeramt aufgenommen!");
    	}
    }    
		  
    void leseAusDatei(String typ){
    	try {
      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Buergeraemter.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.model.setTeesorte(new Teesorte(
      				Integer.parseInt(zeile[0]), 
      				zeile[1], 
      				zeile[2], 
      				zeile[3], 
      				zeile[4].split("_")));
      				ein.close();
      	  			zeigeInformationsfensterAn(
      	  	   			"Die BÃ¼rgerÃ¤mter wurden gelesen!");
      		}
       		else{
	   			zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	void schreibeBuergeraemterInCsvDatei() {
		try {
			this.model.schreibeBuergeraemterInCsvDatei();
		}	
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    private void zeigeInformationsfensterAn(String meldung){
    	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
    		"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
    void zeigeFehlermeldungsfensterAn(String meldung){
       	new MeldungsfensterAnzeiger(AlertType.ERROR,
        	"Fehler", meldung).zeigeMeldungsfensterAn();
    }

	
	
	
	
}