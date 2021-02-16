package gama.spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import gama.spring.model.Carro;

@Repository
public class CarroRepository {
	private Map<String, Carro> carros = new HashMap<String, Carro>();
	public void insert(Carro carro) {
		carros.put(carro.getPlaca(), carro);
	}
	public void update(Carro carro) {
		carros.put(carro.getPlaca(), carro);
	}
	public void delete(String placa) {
		carros.remove(placa);
	}
	public Carro select(String id) {
		return carros.get(id); 
	}
	public List<Carro>select(){
		List<Carro> lista = carros.values().stream().collect(Collectors.toList());
		return lista;
	}
}
