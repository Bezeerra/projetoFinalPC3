package br.com.trabalhoFinal.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.trabalhoFinal.domain.*;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
