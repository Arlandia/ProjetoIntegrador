package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.OrdemDeServico;


@Repository
public interface OrdemDeServicoRepositorio  extends JpaRepository<OrdemDeServico, Long>{

}
