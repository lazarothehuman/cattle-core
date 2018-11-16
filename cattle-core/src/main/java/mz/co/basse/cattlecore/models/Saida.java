package mz.co.basse.cattlecore.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Saida {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String descricao;
	
	@Column(name="data_realizacao", nullable=false)
	@Type(type="date")
	private Date dataRealizacao;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User registador;
	
	@OneToOne
	private Animal animal;
	
	@Column(nullable = false, columnDefinition = "bit")
	private Boolean active = true;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public Date getDataRealizacao() {
		return dataRealizacao;
	}


	public void setDataRealizacao(Date dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}


	public User getRegistador() {
		return registador;
	}


	public void setRegistador(User registador) {
		this.registador = registador;
	}


	public Animal getAnimal() {
		return animal;
	}


	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	public Boolean getActive() {
		return active;
	}


	public void setActive(Boolean active) {
		this.active = active;
	}

}
