package business;

public class Teesorte {
	
	// Name des Buergeramtes
    private int artikelNummer;
    private String bezeichnung;
    private String kategorie;
    private String mitKoffein;
    private String enthalteneKraeuter;

    public Teesorte(int artikelnummer, String bezeichnung, String kategorie, String mitKoffein, String enthalteneKraeuter) {
    	this.artikelNummer = artikelnummer;
    	this.bezeichnung = bezeichnung;
    	this.kategorie = kategorie;
    	this.mitKoffein = mitKoffein;
    	this.enthalteneKraeuter = enthalteneKraeuter;
    }
    

	
	public int getArtikelNummer() {
		return artikelNummer;
	}



	public void setArtikelNummer(int artikelNummer) {
		this.artikelNummer = artikelNummer;
	}



	public String getBezeichnung() {
		return bezeichnung;
	}



	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}



	public String getEnthalteneKraeuter() {
		return enthalteneKraeuter;
	}



	public void setEnthalteneKraeuter(String enthalteneKraeuter) {
		this.enthalteneKraeuter = enthalteneKraeuter;
	}



	public String getKategorie() {
		return kategorie;
	}



	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}


	public String getMitKoffein() {
		return this.mitKoffein;
	}



	public void setMitKoffein(String mitKoffein) {
		this.mitKoffein = mitKoffein;
	}
	
	
	


/*	
	public String getKraeuterAlsString() {
		String inhalt = "";
		for(int i=0; i<this.enthalteneKraeuter.length; i++) {
			inhalt = inhalt + this.enthalteneKraeuter[i] + ", ";
		}
		return inhalt;
	}


*/
	public String gibBuergeramtZurueck(char trenner){
  		return this.getArtikelNummer() + trenner 
  			+ this.getBezeichnung() + trenner
  		    + this.getKategorie() + trenner
  		    + this.getMitKoffein() + trenner + "\n"
  		    + this.getEnthalteneKraeuter() + "\n";
  	}
}