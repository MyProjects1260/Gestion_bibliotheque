package com.angular.springboot.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title", length = 50)
	private String title;
	
	@Column(name="author", length = 20)
	private String author;
	
	@Column(name="synopsis", length = 1000)
	private String synopsis;
	
	@Column(name="nbr_availability")
	private int nbr_availability;
	
	@Column(name="categories", length = 50)
	private String categories;
	
	@Column(name="photo", length = 1000)
	private String photo;
	
		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "livre")
	private List<Commentaire> comment;


	public Livre(String title, String author, String synopsis, int nbr_availability, String categories, String photo) {
		super();
		this.title = title;
		this.author = author;
		this.synopsis = synopsis;
		this.nbr_availability = nbr_availability;
		this.categories = categories;
		this.photo = photo;
	}

	public Livre() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getNbr_availability() {
		return nbr_availability;
	}

	public void setNbr_availability(int nbr_availability) {
		this.nbr_availability = nbr_availability;
	}


	
	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public List<Commentaire> getComment() {
		return comment;
	}

	public void setComment(List<Commentaire> comment) {
		this.comment = comment;
	}

}
