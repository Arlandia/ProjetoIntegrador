package br.com.senac.inicializacao;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import br.com.senac.dominio.OrdemDeServico;
import br.com.senac.dominio.Recurso;
import br.com.senac.dominio.Usuario;
import br.com.senac.repositorio.OrdemDeServicoRepositorio;
import br.com.senac.repositorio.RecursoRepositorio;
import br.com.senac.repositorio.UsuarioRepositorio;
@Component
public class Init   implements ApplicationListener<ContextRefreshedEvent>{
	 @Autowired
	OrdemDeServicoRepositorio ordemDeServicoRepositorio;
	
	 @Autowired
	RecursoRepositorio recursoRepositorio;
	
	 @Autowired
	UsuarioRepositorio usuarioRepositorio;
	 
	    @Override
		public void onApplicationEvent(ContextRefreshedEvent event) {
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Lanny");
			usuario1.setEmail("lanny.cardoso@hotmail.com");
			Usuario usuario2 = new Usuario();
			usuario2.setNome("james");
			usuario2.setEmail("james@hotmail.com");
			
			usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2));
	  
	    // criando ordem de servico
	   OrdemDeServico ordemServico1= new OrdemDeServico(null,"lanny", "james",null, null);
	   OrdemDeServico ordemServico2 = new OrdemDeServico(null,"arlandia", "coroa", null, null);
		
	   ordemDeServicoRepositorio.saveAll(Arrays.asList(ordemServico1,ordemServico2));
	   
	   
	   // criando recurso, material
	   Recurso material1 = new Recurso(null,"lapa", "fio");
	   Recurso material2 = new Recurso(null,"Gloria","Chuva");
		
	   
	   recursoRepositorio.saveAll(Arrays.asList(material1,material2));
		
	      
		
	    }
}
