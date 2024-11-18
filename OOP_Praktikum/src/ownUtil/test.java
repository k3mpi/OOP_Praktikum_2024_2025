package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCSVProduct extends Product {

	private BufferedWriter writer;

	public ConcreteCSVProduct()
	{
		try {
			writer = new BufferedWriter(new FileWriter("test.csv"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		writer.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));
	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}

}




package factory;

public class ConcreteCSVProductCreator extends Creator {

	@Override
	public Product factoryMethod() {
		return new ConcreteCSVProduct();
	}

}




package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtProduct extends Product {

	private BufferedWriter writer;

	public ConcreteTxtProduct()
	{
		try {
			writer = new BufferedWriter(new FileWriter("test.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		Freizeitbad bad = (Freizeitbad)object;
		writer.write(String.format("Daten des Freizeitbades\nName des Freizeitbads:\t%s\nÖffnungszeit des Freizeitbads\t%.2f - %.2f\nBeckenlänge des Freizeitbads:\t%d\nWassertemperatur des Freizeitbads\t%d", 
				     bad.getName(), bad.getGeoeffnetBis(), bad.getGeoeffnetVon(), bad.getBeckenlaenge(), bad.getTemperatur()));
	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}

}



package factory;

public class ConcreteTxtProductCreator extends Creator {

	@Override
	public Product factoryMethod() {
		return new ConcreteTxtProduct();
	}

}


package factory;

public abstract class Creator {
	public abstract Product factoryMethod();
}



package factory;

import java.io.IOException;

public abstract class Product {
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;
	public abstract void schliesseDatei() throws IOException;
}