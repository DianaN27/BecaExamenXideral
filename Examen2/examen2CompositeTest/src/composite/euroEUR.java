package composite;

public class euroEUR implements precio {
	
	precio valor;

	public euroEUR(precio valor) {
		this.valor = valor;
		
	}

	@Override
	public double getValor() {
		return valor.getValor() * 20.44;
	}

}
