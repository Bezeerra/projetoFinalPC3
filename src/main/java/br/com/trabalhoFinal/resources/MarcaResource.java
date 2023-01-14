package br.com.trabalhoFinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhoFinal.domain.*;
import br.com.trabalhoFinal.dto.MarcaDTO;
import br.com.trabalhoFinal.service.MarcaService;


@RestController
@RequestMapping("/api/v1/marcas")
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class MarcaResource {

	@Autowired
	private MarcaService marcaService;

	@PostMapping
	public Marca save(@RequestBody Marca marca) {
		return marcaService.save(marca);
	}
	
	@GetMapping
	public ResponseEntity<List<MarcaDTO>> findAll() {
		List<MarcaDTO> marcas = marcaService.findAll();
		if (marcas == null || marcas.isEmpty()) {
			return new ResponseEntity<List<MarcaDTO>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<MarcaDTO>>(marcas, HttpStatus.OK);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return marcaService.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Marca> update(@PathVariable("id") Long id, @RequestBody Marca marca) {
		return marcaService.findById(id).map(record -> {
			record.setSigla(marca.getSigla());
			record.setDescricao(marca.getDescricao());
			Marca updated = marcaService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return marcaService.findById(id).map(record -> {
			marcaService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
