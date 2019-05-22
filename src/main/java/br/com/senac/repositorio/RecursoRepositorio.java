package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Recurso;

@Repository
public interface RecursoRepositorio  extends JpaRepository<Recurso, Integer> {

}
