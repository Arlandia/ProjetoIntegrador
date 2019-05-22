package br.com.senac.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.dominio.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	 
		Usuario findByEmail(String email);
		
		@Query("select a from Usuario a where a.nome = ?1")
		Usuario findByNome(String nome);
		 
	}


