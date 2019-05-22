package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.senac.dominio.Usuario;
import br.com.senac.servico.OrdemDeServicoService;
import br.com.senac.servico.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;



@Controller
@RequestMapping("/usuario")
public class ControleUsuario {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private OrdemDeServicoService ordemDeServicoService;
	
	@GetMapping("/listarUsuario")
	public ModelAndView listaUsuarios() {
	ModelAndView	mv = new ModelAndView("usuario/paginaUsuarios");
	mv.addObject("usuarios", usuarioService.listaUsuarios());
	return mv;
	}
	
	@GetMapping("/adicionarUsuario")
	public ModelAndView add() {
	ModelAndView	mv = new ModelAndView("usuario/paginaAdicionarUsuario");
	mv.addObject("usuario", new Usuario());
//	mv.addObject("servicos", ordemDeServicoService.listaOrdemDeServicos());
	return mv;
	
	} 
	
	@PostMapping("/salvarUsuario")
	public ModelAndView inserir(Usuario usuario) {
		usuarioService.inserir(usuario);
		return listaUsuarios();
	}
	@GetMapping("/excluirUsuario/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
		usuarioService.excluir(id);
		return listaUsuarios();
	
	}
	@GetMapping("/alterarUsuario/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) throws ObjectNotFoundException{
	ModelAndView	mv = new ModelAndView("usuario/paginaAlterarUsuario");
	mv.addObject("usuario", usuarioService.buscar(id));
	//mv.addObject("usuarios", ordemDeServicoService.listaOrdemDeServico());
	return mv;
	}
	
	@PostMapping("/alterarUsuario")
	public ModelAndView alterar(Usuario usuario) throws ObjectNotFoundException{
		usuarioService.alterar(usuario);
		return listaUsuarios();
	}

}
