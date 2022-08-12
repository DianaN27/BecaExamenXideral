package composite;

public class pesoMXN implements precio {

	double valor;
	
	public pesoMXN(double valor) {
		this.valor = valor;
	}

	@Override
	public double getValor() {
		return valor;
	}

}
