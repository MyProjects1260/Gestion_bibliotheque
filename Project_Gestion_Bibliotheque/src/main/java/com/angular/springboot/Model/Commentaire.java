package com.angular.springboot.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;


@Entity
@Table(name = "Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="commentaire", length = 500)
	private String comment;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at", nullable = false, updatable = false)
	private Date created_at;
	@CreatedDate
	
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "emprunteur_id", referencedColumnName = "id", nullable = false)
	private Emprunteur emprunteur;
	
	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "livre_id", referencedColumnName = "id", nullable = false)
	private Livre livre;
	
	
	
	public Commentaire() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentaire() {
		return comment;
		}

	public void setCommentaire(String comment) {
		this.comment = comment;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Emprunteur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Emprunteur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	

}
