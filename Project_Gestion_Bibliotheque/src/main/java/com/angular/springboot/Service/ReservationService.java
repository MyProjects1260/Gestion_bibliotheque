package com.angular.springboot.Service;


import java.sql.Date;
import java.util.List;

import com.angular.springboot.Model.Reservation;

public interface ReservationService {
	
	public List<Reservation> getAllReservation();
	
	public void saveOrUpdate(Reservation res);
	
	//public List<Reservation> findReservationLike(Date date_debut, Date date_fin , Livre l, Emprunteur emp);

	public void deleteReservation(long id);

	List<Reservation> findReservationLike(Date date_debut, Date date_fin, String title, String emprunteur, String auth);

	Reservation getReservationById(long id);
}
