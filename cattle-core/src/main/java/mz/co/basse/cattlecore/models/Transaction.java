package mz.co.basse.cattlecore.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Representa uma Transacção do Sistema, uma funcionalidade ou grupo de
 * funcionalidades relacionadas do sistema.
 * 
 * 
 */
@Entity
@Table(name = "transaction")
public class Transaction implements Comparable<Transaction> {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String code;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, columnDefinition = "bit")
	private boolean active = true;

	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transaction) {
			return ((Transaction) obj).getCode().equals(getCode());
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return getCode().hashCode();
	}

	@Override
	public String toString() {
		return getCode() + " - " + getName();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int compareTo(Transaction o) {
		return name.compareTo(o.name);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
