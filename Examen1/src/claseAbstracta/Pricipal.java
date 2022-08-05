package claseAbstracta;

import java.util.*;

public class Pricipal {

	public static void main(String[] args) {
		//Creando arreglo que guarde las opciones
		Idioma [] idiomas = {new Japones(),new Español(),new Coreano()};
		realizarSorteo(idiomas);
		

	}
	
	static void realizarSorteo(Idioma [] idiomas) {
		//Creando varianble con valor random hasta 3
		int i = new Random().nextInt(3);
		Idioma posicionIdioma = idiomas[i];
		//Impresion del resultado en consola
		System.out.println("=================================================================");
		System.out.println(posicionIdioma.nombreIdioma());
		System.out.println(posicionIdioma.cantidadConsonante());
		System.out.println(posicionIdioma.cantidadVocales());
		System.out.println("=================================================================");
        
    }

}
