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


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="date_reservation")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateReservation;
	
	@JoinColumn(name = "livre_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Livre livre;
	
	@JoinColumn(name = "emprunteur_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Emprunteur emp;

	public Reservation() {
		super();
	}

	public Date getDate_reservation() {
		return dateReservation;
	}

	public void setDate_reservation(Date dateReservation) {
		this.dateReservation = dateReservation;
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

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	

}
