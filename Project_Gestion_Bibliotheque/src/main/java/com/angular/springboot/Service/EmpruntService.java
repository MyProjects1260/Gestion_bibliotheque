package com.angular.springboot.Service;

import java.sql.Date;
import java.util.List;

import com.angular.springboot.Model.Emprunt;

public interface EmpruntService {

	public List<Emprunt> getAllEmprunt();
	
	public Emprunt getEmpruntById(long id);
	
	public void saveOrUpdate(Emprunt Emprunt);
	
	public void delete(long id);
	
	public void verifierDateRetour(Date today);
}
