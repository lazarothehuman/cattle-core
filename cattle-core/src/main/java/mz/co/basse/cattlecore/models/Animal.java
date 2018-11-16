package mz.co.basse.cattlecore.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="data_nascimento", nullable=false)
	@Type(type="date")
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Coral coral;
	
	@Column(nullable=false)
	private Double peso;
	
	@Column(nullable=false)
	private Double altura;
	
	@Column(unique=true)
	private String code;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gado tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn
	private Animal pai;
	
	@ManyToOne
	@JoinColumn
	private Animal mae;
	
	/*@ManyToMany
	List<Procedimento> procedimentos = new ArrayList<>();
	*/
	@OneToMany(mappedBy="animal")
	private List<AnimalProcedimento> animalProcedimento = new ArrayList<AnimalProcedimento>();
	
	@OneToOne(mappedBy="animal")
	private Saida saida;
	
	@Column(nullable = false, columnDefinition = "bit")
	private Boolean active = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Coral getCoral() {
		return coral;
	}

	public void setCoral(Coral coral) {
		this.coral = coral;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Gado getTipo() {
		return tipo;
	}

	public void setTipo(Gado tipo) {
		this.tipo = tipo;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		this.pai = pai;
	}

	public Animal getMae() {
		return mae;
	}

	public void setMae(Animal mae) {
		this.mae = mae;
	}

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}
	
	public void addProcedimento(AnimalProcedimento animalProcedimento) {
		if (animalProcedimento != null) {
			this.animalProcedimento.add(animalProcedimento);
		}
	}
	
	public void removeProcedimento(AnimalProcedimento animalProcedimento) {
		if (animalProcedimento != null) {
			this.animalProcedimento.remove(animalProcedimento);
		}
	}

	public List<AnimalProcedimento> getAnimalProcedimento() {
		return Collections.unmodifiableList(animalProcedimento);
	}

	public void setAnimalProcedimento(List<AnimalProcedimento> animalProcedimento) {
		this.animalProcedimento = animalProcedimento;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
