package com.angular.springboot.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.angular.springboot.Model.Livre;
import com.angular.springboot.Repository.LivreRepository;

@Service
@Transactional
public class LivreServiceImp implements LivreService{

	@Autowired
	LivreRepository livre;
	

	@Override
	public Livre getLivreById(long id) {
		return livre.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Livre l) {
		livre.save(l);
	}

	@Override
	public void deleteLivre(long id) {
		livre.deleteById(id);
	}

	@Override
	public List<Livre> findByCategoriesAndTitle(String categories, String title) {
		return livre.findByCategoriesAndTitle(categories,title);
	}

	@Override 
	public List<Livre> Search(String pseudo, String categorie) {
		return livre.Search(pseudo, categorie);
	}

	@Override
	public List<Livre> getAllLivre() {
		return  livre.findAll();
	}


	@Override
	public void availabilityplus(long id) {
		livre.availaibleplus(id);
		
	}

	@Override
	public void availabilityminus(long id) {
		livre.availaibleminus(id);
	}

	@Override
	public List<String> getAllCategories() {
		return livre.getAllCategories();
	}
}
