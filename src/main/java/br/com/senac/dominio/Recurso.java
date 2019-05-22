package br.com.senac.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Recurso implements Serializable{
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	@ManyToMany
	@JoinTable(name="Material", joinColumns = @JoinColumn (name = "recurso_id"), inverseJoinColumns = @JoinColumn (name = "servico_id"))
	private List<OrdemDeServico> materiais = new ArrayList<>();
	
	public Recurso() {
		
	}
	
	public Recurso(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
   

	public List<OrdemDeServico> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<OrdemDeServico> materiais) {
		this.materiais = materiais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

}
