package claseInterface;

public class Español  implements Idioma{

	@Override
	public String nombreIdioma() {
		
		return "ESPAÑOL";
	}

	@Override
	public String cantidadVocales() {
		
		return "El español tiene cinco vocales, \"a\", \"i\", \"u\", \"e\", \"o\",";
	}
	
	@Override
	public String cantidadConsonante() {
	
		return "El español veintidos letras consonantes del alfabeto español";
	}

}
