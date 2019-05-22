package br.com.senac.servico;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import br.com.senac.dominio.OrdemDeServico;
import br.com.senac.repositorio.OrdemDeServicoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class OrdemDeServicoService {
	

	private OrdemDeServicoRepositorio repoOrdem;
	
	public OrdemDeServico buscar(Long id) throws ObjectNotFoundException {
		Optional<OrdemDeServico> objOrdemDeServico = repoOrdem.findById(id);
		return objOrdemDeServico.orElseThrow(() -> new  ObjectNotFoundException(
				" não encotrado! id: " + id + ", Tipo!" + OrdemDeServico.class.getName()));
	}	
	
	public OrdemDeServico inserir (OrdemDeServico servico) {
		//estou colacondo um objeto novo entao o id precisa ser null
		servico.setId((Long) null);
		return repoOrdem.save(servico);
	}
	
   public OrdemDeServico alterar(OrdemDeServico objOrdemDeServico) throws ObjectNotFoundException{
		
	   OrdemDeServico objOrdemServicoEncotrado = buscar(objOrdemDeServico.getId());
	   objOrdemServicoEncotrado = buscar(objOrdemDeServico.getId());
	   objOrdemServicoEncotrado.setNome(objOrdemDeServico.getNome());
	   objOrdemServicoEncotrado.setDataInicio(objOrdemDeServico.getDataInicio());
	   objOrdemServicoEncotrado.setDataTermino(objOrdemDeServico.getDataTermino());
	   objOrdemServicoEncotrado.setDescricao(objOrdemDeServico.getDescricao());
	   objOrdemServicoEncotrado.setRecursos(objOrdemDeServico.getRecursos());
	  
		return repoOrdem.save(objOrdemServicoEncotrado);
	}
   		
   public void excluir(Long id) {
   		repoOrdem.deleteById(id);
   }
   
   public List<OrdemDeServico> listaOrdemDeServico(){
   		return repoOrdem.findAll();
   }

}
