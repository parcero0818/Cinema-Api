package co.com.cinema.CinemaApi.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@GetMapping
	private List<TblSucursales> getSucursales() {
		return sucursalesRepository.findAll();
	}

	@PostMapping(value = "/addSala")
	public ResponseEntity<?> addSala(@RequestBody TblSalas sala) {
		try {
			salasRepository.save(sala);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
