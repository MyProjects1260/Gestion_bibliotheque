package com.angular.springboot.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.angular.springboot.Model.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt,Long>{

	@Query(value="Select E from Emprunt E where E.date_retour = :today")
	public List<Emprunt> verifierDateRetour(Date today);
}
