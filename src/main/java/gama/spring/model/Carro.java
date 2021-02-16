package gama.spring.model;

public class Carro {
	private String placa;
	private String modelo;
	//varios atributos
	private Integer potencia=0;
	
	public Carro() {
		this(null,null);
	}
	
	public Carro(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public Integer getPotencia() {
		return potencia;
	}
	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
