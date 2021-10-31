package com.angular.springboot.Service;

import java.util.List;

import com.angular.springboot.Model.Commentaire;

public interface CommentaireService {

	
	public List<Commentaire> getCommnetaireByLivre(long livre_id);
	
	public void addOrUpdateCommentaireToLivre(Commentaire commentaire);
	
	public void removeCommentaireToLivre(Commentaire commentaire);

	public List<Commentaire> findAll();
}
