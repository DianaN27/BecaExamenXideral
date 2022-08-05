package claseInterface;

public class Japones implements Idioma{

	@Override
	public String nombreIdioma() {
		
		return "JAPONES";
	}

	@Override
	public String cantidadVocales() {
		
		return "El japonés tiene cinco vocales, \"a\", \"i\", \"u\", \"e\", \"o\",";
	}
	
	@Override
	public String cantidadConsonante() {
	
		return "El japonés tiene diecinueve consonantes";
	}

}
