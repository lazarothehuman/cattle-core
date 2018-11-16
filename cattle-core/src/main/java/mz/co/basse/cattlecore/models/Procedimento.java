package mz.co.basse.cattlecore.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Procedimento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy="procedimento")
	private List<AnimalProcedimento> animalProcedimento = new ArrayList<AnimalProcedimento>();
	
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

	public List<AnimalProcedimento> getAnimalProcedimento() {
		return Collections.unmodifiableList(animalProcedimento);
	}

	public void setAnimalProcedimento(List<AnimalProcedimento> animalProcedimento) {
		this.animalProcedimento = animalProcedimento;
	}
	
	public void addAnimal(AnimalProcedimento animalProcedimento) {
		if (animalProcedimento != null) {
			this.animalProcedimento.add(animalProcedimento);
		}
	}
	
	public void removeAnimal(AnimalProcedimento animalProcedimento) {
		if (animalProcedimento != null) {
			this.animalProcedimento.remove(animalProcedimento);
		}
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	

}
