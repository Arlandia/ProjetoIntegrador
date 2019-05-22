package br.com.senac.dominio;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class OrdemDeServico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
	private Date dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy") // formatar a data
	protected Date dataTermino;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	/*
	@Column(length = 255)
	private String urlRegistroInstalacao;
	
	@Column(length = 255)
	private String latitudeInstalacao;
	
	@Column(length = 255)
	private String longitudeInstalacao;
	
	private boolean fechada;
	
	*/
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarios;
	
	@ManyToMany(mappedBy="materiais")
	private List<Recurso> recursos;
	 
	public OrdemDeServico() {
			
	}
		
	 public OrdemDeServico(Long id,String nome, String descricao, Date dataInicio, Date dataTermino) {
	    super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio= dataInicio;
		this.dataTermino = dataTermino;	
	}
		
	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

}
