package claseAbstracta;

public class Español  extends Idioma{

	@Override
	String nombreIdioma() {
		
		return "ESPAÑOL";
	}

	@Override
	String cantidadVocales() {
		
		return "El español tiene cinco vocales, \"a\", \"i\", \"u\", \"e\", \"o\",";
	}
	
	@Override
	String cantidadConsonante() {
	
		return "El español veintidos letras consonantes del alfabeto español";
	}

}
