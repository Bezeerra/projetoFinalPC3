package br.com.trabalhoFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trabalhoFinal.domain.*;
import br.com.trabalhoFinal.repository.VeiculoRepository;

@Service
public class VeiculoService {
	@Autowired
	private VeiculoRepository aulaRepository;

	public Veiculo save(Veiculo aula) {
		return aulaRepository.save(aula);
	}

	public List<Veiculo> findAll() {
		return (List<Veiculo>) aulaRepository.findAll();
	}

	public Optional<Veiculo> findById(Long id) {
		return aulaRepository.findById(id);
	}

	public Veiculo update(Veiculo aula) {
		return aulaRepository.save(aula);
	}

	public void deleteById(Long id) {
		aulaRepository.deleteById(id);
	}

}
