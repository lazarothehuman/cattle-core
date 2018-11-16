package mz.co.basse.cattlecore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile implements Comparable<Profile> {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false, columnDefinition = "bit")
	private boolean active = true;

	@ManyToMany
	@JoinTable(name = "profile_transaction", joinColumns = { @JoinColumn(name = "profile_id") }, inverseJoinColumns = { @JoinColumn(name = "transaction_id") })
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile) {
			return getName().equals(((Profile) obj).getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int compareTo(Profile o) {
		return name.compareTo(o.name);
	}
	
	public boolean isSystemDeveloperProfile() {
		return Long.valueOf(1).equals(id);
	}
}
