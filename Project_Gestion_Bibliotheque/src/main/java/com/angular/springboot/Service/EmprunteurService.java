package com.angular.springboot.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.angular.springboot.Model.Emprunteur;
import com.angular.springboot.Model.UserRegistrationDto;

public interface EmprunteurService extends UserDetailsService{

	Emprunteur findByEmail(String email);

    Emprunteur save(UserRegistrationDto registration);
    
    List<Emprunteur> findAll();
    
    public void deleteEmprunteur(long id);
    
}
