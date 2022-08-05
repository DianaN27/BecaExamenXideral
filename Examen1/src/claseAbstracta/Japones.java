package claseAbstracta;

public class Japones extends Idioma{

	@Override
	String nombreIdioma() {
		
		return "JAPONES";
	}

	@Override
	String cantidadVocales() {
		
		return "El japonés tiene cinco vocales, \"a\", \"i\", \"u\", \"e\", \"o\",";
	}
	
	@Override
	String cantidadConsonante() {
	
		return "El japonés tiene diecinueve consonantes";
	}

}
