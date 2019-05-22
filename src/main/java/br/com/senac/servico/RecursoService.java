package br.com.senac.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.senac.dominio.Recurso;
import br.com.senac.repositorio.RecursoRepositorio;
import br.com.senac.servico.exception.ObjctNotFundException;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepositorio repoRecur;
	
	public Recurso buscar(Integer id) {
		Optional<Recurso> objRecurso = repoRecur.findById(id);
		return objRecurso.orElseThrow(() -> new ObjctNotFundException("Recurso não encontrada! Id:"
			+ id + "Tipo: " + Recurso.class.getName()));
		
	}
	public Recurso inserir (Recurso objRecurso) {
		//estou colacondo um objeto novo entao o id precisa ser null
		objRecurso.setId(null);
		return repoRecur.save(objRecurso);
	}
	
	public Recurso alterar(Recurso objRecurso) {
		
		Recurso objRecursoEncotrado = buscar(objRecurso.getId());
		objRecursoEncotrado.setId(objRecurso.getId());
		objRecursoEncotrado.setNome(objRecurso.getNome());
		objRecursoEncotrado.setDescricao(objRecurso.getDescricao());
		objRecursoEncotrado.setMateriais(objRecurso.getMateriais());
		
		return repoRecur.save(objRecursoEncotrado);
	}
    public void excluir(Integer id) {
    	repoRecur.deleteById(id);
    }
    public List<Recurso> listaRecurso(){
    	return repoRecur.findAll();
    }
}
