package mz.co.basse.cattlecore.models;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Representa um usuário do Sistema
 * 
 * 
 */
@Entity
@Table(name = "user")
public class User implements Comparable<User>{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String login;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;

	@Column(name = "phone", nullable = true)
	private String phone;

	@Column(name = "phone2", nullable = true)
	private String phone2;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id", nullable = false)
	private Profile profile;
	
	@OneToMany(mappedBy="registador")
	private List<Saida> saidasRegistadas = new ArrayList<Saida>();

	@Column(nullable = false, columnDefinition = "bit")
	private boolean active = true;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return login.equals(((User) obj).login);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return login.hashCode();
	}

	public int compareTo(User o) {
		return login.compareTo(o.login);
	}

	@Override
	public String toString() {
		return login;
	}

}
