package mz.co.basse.cattlecore.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class AnimalProcedimento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Animal animal;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Procedimento procedimento;
	
	@Column(name="data_realizacao", nullable=false)
	@Type(type="date")
	private Date dataRealizacao;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private User registador;
	
	@Column(nullable = false, columnDefinition = "bit")
	private Boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
