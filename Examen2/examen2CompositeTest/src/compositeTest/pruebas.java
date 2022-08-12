package compositeTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import composite.*;



class pruebas {
	
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Iniciando conversiones con el precio del dia de hoy: " + LocalDate. now());
	}

	@Test
	void testDolar() {
		precio pesos = new dolarUSD(new pesoMXN(4.0));
		
						
		assertEquals(79.6, pesos.getValor());
	}
	
	void testLibra() {
		precio pesos = new euroEUR(new pesoMXN(45.0));
		
						
		assertEquals(919.8, pesos.getValor());
	}
	
	
	void testDEuro() {
		precio pesos = new libraGBP(new pesoMXN(96.90));
		
						
		assertEquals(2,337.228, pesos.getValor());
	}
	
	
	@Test
	
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(1), () -> {
			precio pesos = new dolarUSD(new pesoMXN(12.0));
			precio pesos2 = new euroEUR(new pesoMXN(12.0));
			precio pesos3 = new libraGBP(new pesoMXN(12.0));
			System.out.println("Equivalencia de 12 pesos en dolar: " + pesos.getValor()+", euro: " + pesos2.getValor() + " y libra: " + pesos3.getValor());
			
		});
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("Terminando pruebas");
	}

}
