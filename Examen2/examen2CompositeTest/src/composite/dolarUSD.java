package composite;

public class dolarUSD implements precio {
	
	precio valor;

	public dolarUSD(precio valor) {
		this.valor = valor;
		
	}

	@Override
	public double getValor() {
		return valor.getValor() * 19.90;
	}

}
