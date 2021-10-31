package com.angular.springboot.Repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.angular.springboot.Model.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire,Long>{

     public List<Commentaire> getCommnetaireByLivre(long livre_id);
     
    @Query(value = "INSERT INTO commentaire(commentaire, created_at, emprunteur_id, livre_id) "
 			+ "VALUES (\":comment\",\":date\",:emp_id,:comm_id)", nativeQuery = true)
 	public void addCommentaireToLivre(@Param("comment") String comment, @Param("date") Date date, @Param("emp_id") long emp_id, @Param("comm_id") long comm_id);
 	
    @Query(value = " DELETE FROM commentaire(commentaire, emprunteur_id, livre_id) "
 			+ "VALUES (\":comment\",:emp_id,:comm_id)", nativeQuery = true)
 	public void removeCommentaireToLivre(@Param("comment") String comment, @Param("emp_id") long emp_id, @Param("comm_id") long comm_id);
 	
    }
