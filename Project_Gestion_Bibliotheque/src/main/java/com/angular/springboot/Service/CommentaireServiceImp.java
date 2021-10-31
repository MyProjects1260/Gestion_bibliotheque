package com.angular.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.springboot.Model.Commentaire;
import com.angular.springboot.Repository.CommentaireRepository;

@Service
public class CommentaireServiceImp implements CommentaireService{
	
	@Autowired
	CommentaireRepository comment;

	@Override
	public List<Commentaire> getCommnetaireByLivre(long livre_id) {
		return comment.getCommnetaireByLivre(livre_id);
	}

	@Override
	public void addOrUpdateCommentaireToLivre(Commentaire commentaire) {
		comment.save(commentaire);
	}

	@Override
	public void removeCommentaireToLivre(Commentaire commentaire) {
		comment.delete(commentaire);
	}
	
	@Override
	public List<Commentaire> findAll(){
		return comment.findAll();
	}

}
