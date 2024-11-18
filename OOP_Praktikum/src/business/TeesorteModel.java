package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Alert.AlertType;
import ownUtil.MeldungsfensterAnzeiger;

public class TeesorteModel {
	
	
	  // speichert temporaer ein Objekt vom Typ Buergeramt
    private Teesorte teesorte;
    
    
    public void schreibeBuergeraemterInCsvDatei() {
		try {
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeesortenAusgabe.csv", true));
			aus.write(teesorte.gibBuergeramtZurueck(';'));
			aus.close();
   			zeigeInformationsfensterAn(
	   			"Die Teesorten wurden gespeichert!");
		}	
		catch(IOException exc){
			zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

    public Teesorte getTeesorte() {
		return teesorte;
	}

	public void setTeesorte(Teesorte teesorte) {
		this.teesorte = teesorte;
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