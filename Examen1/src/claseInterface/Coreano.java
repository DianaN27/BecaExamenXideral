package claseInterface;

public class Coreano implements Idioma{
	

	@Override
	public String nombreIdioma() {
		
		return "COREANO";
	}

	@Override
	public String cantidadVocales() {
		
		return "El coreano tiene diez vocales";
	}
	
	@Override
	public String cantidadConsonante() {
	
		return "El coreano catorce letras consonantes del alfabeto coreano";
	}

}
