package com.angular.springboot.Model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;

//import javax.validation.constraints.NotBlank;

import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Emprunteur")

public class Emprunteur{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotBlank
	//@Size(max = 50)
	@Column(name = "email", nullable = false, unique=true)
	private String email;
	
	private String password;
	
	
	@Column(name="nom", length = 20)
	private String nom;
	
	@Column(name="prenom", length = 20)
	private String prenom;
	
	@Column(name="age")
	private int age;
	
	@Column(name="ville", length = 20)
	private String ville;
	
	@Column(name="tel")
	private int tel;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "emprunteur")
	private List<Commentaire> comment;
		
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

		
	public Emprunteur(long id, String email, String password, String nom, String prenom, int age,
			String ville, int tel) {
		super();
		
		this.id = id;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.ville = ville;
		this.tel = tel;
	}
	


	
	public Emprunteur(String email, String password) {
		super();
		
		this.email = email;
		this.password = password;
	}

	public Emprunteur() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public List<Commentaire> getComment() {
		return comment;
	}

	public void setComment(List<Commentaire> comment) {
		this.comment = comment;
	}

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

	
}
