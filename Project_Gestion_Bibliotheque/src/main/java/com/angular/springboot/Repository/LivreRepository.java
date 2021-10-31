package com.angular.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.angular.springboot.Model.Livre;

public interface LivreRepository extends JpaRepository<Livre,Long> {
	

	
	public List<Livre> findByCategoriesAndTitle(String categories, String title);
		
	@Query(value="SELECT * FROM `livre` \r\n" + 
			"where title Like \'%:pseudo%\' or categories Like \'%:cat%\' or author Like \'%:pseudo%\'", nativeQuery = true)
	public List<Livre> Search(@Param("pseudo") String p, @Param("cat") String categ);

	@Modifying
	@Query(value="UPDATE livre set nbr_availability= livre.nbr_availability+1 WHERE id=:id", nativeQuery = true)
	public void availaibleplus(@Param("id") long livre_id);
	
	@Modifying
	@Query(value="UPDATE livre set nbr_availability= livre.nbr_availability-1 WHERE id=:id", nativeQuery = true)
	public void availaibleminus(@Param("id") long livre_id);
	
	@Query(value="SELECT DISTINCT categories from livre", nativeQuery = true )
	public List<String> getAllCategories();
}
