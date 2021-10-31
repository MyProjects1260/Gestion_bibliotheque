package com.angular.springboot.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Emprunt")

public class Emprunt {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="date_retour")
	private Date date_retour;
	
	@JoinColumn(name = "livre_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Livre livre;
	
	@JoinColumn(name = "emprunteur_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Emprunteur emp;

	public Emprunt() {
		super();
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour2) {
		this.date_retour = date_retour2;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Emprunteur getEmp() {
		return emp;
	}

	public void setEmp(Emprunteur emp) {
		this.emp = emp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
