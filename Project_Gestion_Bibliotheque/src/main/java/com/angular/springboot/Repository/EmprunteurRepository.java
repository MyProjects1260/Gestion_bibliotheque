package com.angular.springboot.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.angular.springboot.Model.Emprunteur;


public interface EmprunteurRepository extends JpaRepository<Emprunteur,Long>{

	//public Optional<Emprunteur> findByEmail(String Email);
	//Emprunteur findByUserName(String userName);
	Emprunteur findByEmail(String email);
	
	//Boolean existsByEmail(String Email);
	
	
}
