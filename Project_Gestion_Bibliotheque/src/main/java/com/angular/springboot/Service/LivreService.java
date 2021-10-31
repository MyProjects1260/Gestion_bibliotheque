package com.angular.springboot.Service;

import java.util.List;
import com.angular.springboot.Model.Livre;


public interface LivreService {
	
	public List<Livre> getAllLivre();
	
	public Livre getLivreById(long id);
	
	public void saveOrUpdate(Livre livre);
	
	public void deleteLivre(long id);
	
	public List<Livre> findByCategoriesAndTitle(String categories,String title);
	
    public List<Livre> Search(String pseudo, String categorie);
       
    public void availabilityplus(long id);
    
    public void availabilityminus(long id);
    
    public List<String> getAllCategories();

}
