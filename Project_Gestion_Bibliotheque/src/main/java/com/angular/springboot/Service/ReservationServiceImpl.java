package com.angular.springboot.Service;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.Model.Reservation;
import com.angular.springboot.Repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationRepository reservation;

	@Override
	public List<Reservation> getAllReservation() {
		return reservation.findAll();
	}

	@Override
	public void saveOrUpdate(Reservation res) {
		reservation.save(res);
	}


	@Override
	public void deleteReservation(long id) {
		reservation.deleteById(id);
	}

	@Override
	public List<Reservation> findReservationLike(Date date_debut, Date date_fin, String title, String emprunteur,
			String auth) {
		return reservation.findReservationLike(date_debut, date_fin, title, emprunteur, auth);
	}

	@Override
	public Reservation getReservationById(long id) {
		return  reservation.findById(id).get();
	}

	







	
}
