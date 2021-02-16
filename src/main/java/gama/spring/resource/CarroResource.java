package gama.spring.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gama.spring.model.Carro;
import gama.spring.model.CarroMotor;
import gama.spring.repository.CarroRepository;

@RestController
@RequestMapping(path = "/carros")
public class CarroResource {
	@Autowired
	private CarroRepository service;
	
	@GetMapping
	public List<Carro> listar(){
		return service.select();
	}
	
	@GetMapping(path = "/{placa}") //@PathVariable
	public Carro listar(@PathVariable String placa){
		System.out.println("Buscando carro pela placa " + placa);
		return service.select(placa);
	}
	
	@GetMapping(path ="/params" )
	public Carro listarParam(@RequestParam("placa") String placa){
		System.out.println("Buscando params placa " + placa);
		return service.select(placa);
	}
	
	@PostMapping()
	public void post(@RequestBody Carro carro){
		service.insert(carro);
	}
	
	@PutMapping()
	public void put(@RequestBody Carro carro){
		
		service.insert(carro);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable ("id") String id,  @RequestBody Carro carro){
		Carro dbCarro = service.select(id);
		if(dbCarro!=null) {
			dbCarro.setModelo(carro.getModelo());
			//... 
		}
		service.update(dbCarro);
	}
	
	@PatchMapping("/{id}")
	public void patch(@PathVariable ("id") String id,  @RequestBody CarroMotor motor){
		Carro dbCarro = service.select(id);
		if(dbCarro!=null) {
			dbCarro.setPotencia(motor.getPotencia());
			//... 
		}
		service.update(dbCarro);
	}
}
