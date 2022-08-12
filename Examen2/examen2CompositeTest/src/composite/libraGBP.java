package composite;

public class libraGBP implements precio {
	
	precio valor;

	public libraGBP(precio valor) {
		this.valor = valor;
		
	}

	@Override
	public double getValor() {
		return valor.getValor() * 24.12;
	}

}
