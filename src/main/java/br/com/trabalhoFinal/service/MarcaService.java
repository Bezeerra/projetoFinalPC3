package br.com.trabalhoFinal.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhoFinal.domain.*;
import br.com.trabalhoFinal.dto.MarcaDTO;
import br.com.trabalhoFinal.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public Marca save(Marca curso) {
		return marcaRepository.save(curso);
	}
	
	public List<MarcaDTO> findAll(){		
		return marcaRepository.findAll()
				.stream()
				.map(curso -> new MarcaDTO(curso)).collect(Collectors.toList());		
	}
	
	
	public Optional<Marca> findById(Long id) {
		return marcaRepository.findById(id);
	}
	
	public Marca update(Marca curso) {
		return marcaRepository.save(curso);
	}
	
	public void deleteById(Long id) {
		marcaRepository.deleteById(id);		
	}

}
