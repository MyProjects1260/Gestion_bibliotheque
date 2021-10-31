package com.angular.springboot.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.Repository.EmpruntRepository;
import com.angular.springboot.Model.Emprunt;

@Service
public class EmpruntServiceImp implements EmpruntService {

	@Autowired
	EmpruntRepository Emprunt;

	@Override
	public void saveOrUpdate(Emprunt emprunt) {
		Emprunt.save(emprunt);
	}

	@Override
	public void delete(long id) {
		Emprunt.deleteById(id);
	}

	@Override
	public void verifierDateRetour(Date today) {
		Emprunt.verifierDateRetour(today);
	}

	@Override
	public List<Emprunt> getAllEmprunt() {
		return Emprunt.findAll();
	}

	@Override
	public Emprunt getEmpruntById(long id) {
			return Emprunt.getOne(id);
	}
}
