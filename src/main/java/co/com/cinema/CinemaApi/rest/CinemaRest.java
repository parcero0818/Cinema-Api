package co.com.cinema.CinemaApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.com.cinema.CinemaApi.model.TblSalas;
import co.com.cinema.CinemaApi.model.TblSucursales;
import co.com.cinema.CinemaApi.repository.TblSalasRepository;
import co.com.cinema.CinemaApi.repository.TblSucursalesRepository;

@RestController
@RequestMapping("/cinema")
public class CinemaRest {

	TblSucursalesRepository sucursalesRepository;
	TblSalasRepository salasRepository;

	@Autowired
	public CinemaRest(TblSucursalesRepository sucursalesRepository, TblSalasRepository salasRepository) {
		// TODO Auto-generated constructor stub
		this.sucursalesRepository = sucursalesRepository;
		this.salasRepository = salasRepository;
	}

	@CrossOrigin
	@GetMapping
	private List<TblSucursales> getSucursales() {
		return sucursalesRepository.findAll();
	}

	@CrossOrigin
	@PostMapping(value = "/addSala", consumes = "application/json")
	public String addSala(@RequestBody TblSalas sala) {
		System.out.println(sala.getNumeroFilas());
		try {
			salasRepository.save(sala);
			return "200";
		}catch (Exception e) {
			// TODO: handle exception
			return "500";
		}
	}
}
