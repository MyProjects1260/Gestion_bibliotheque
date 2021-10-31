package com.angular.springboot.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.angular.springboot.Model.Emprunt;
import com.angular.springboot.Model.Emprunteur;
import com.angular.springboot.Model.Livre;
import com.angular.springboot.Model.Reservation;
import com.angular.springboot.Service.EmpruntServiceImp;
import com.angular.springboot.Service.EmprunteurServiceImp;
import com.angular.springboot.Service.LivreServiceImp;
import com.angular.springboot.Service.ReservationServiceImpl;

@Controller
@RequestMapping("/admin/")
public class admin {
	
	@Autowired
	ReservationServiceImpl reservation;
	
	@Autowired
	EmpruntServiceImp emprunt;

	@Autowired
	LivreServiceImp livre;
	
	@Autowired
	EmprunteurServiceImp emprunteur;
	
	
	 @GetMapping("Acceuil")
	    public String VisualAdmin(Model model) {
	        return "index";
	    }
	  
	 @GetMapping("emprunteur_List")
		public String EmprunteurList(Model model) {
			
			List<Emprunteur> emp = emprunteur.findAll();
			model.addAttribute("emprunteur", emp);
			return "EmprunteurList";
		}
	 
	 
	 @RequestMapping("delete_Emprunteur/{id}")
		public String deleteEmprunteur(@PathVariable(name = "id") int id) {
		
		 emprunteur.deleteEmprunteur(id);
		    return "redirect:/admin/emprunteur_List";      
		}
	 
	 @GetMapping("livre_List")
		String LivreList(Model model) {

		 List<Livre> l = livre.getAllLivre();
			model.addAttribute("livre", l);
			return "LivreList";
		}
	 
	 @RequestMapping("delete_Livre/{id}")
		public String deleteLivre(@PathVariable(name = "id") int id) {
		 
		 livre.deleteLivre(id);
		    return "redirect:/admin/livre_List";      
		}
	 
	 @RequestMapping("edit_Livre/{id}")
		public String editLivre(@PathVariable(name = "id") int id) {
		 
		 livre.getLivreById(id);
		 
		    return "redirect:/admin/LivreList";      
		}
	 
	@GetMapping("reservation_List")
	public String show(Model model) {
		
		List<Reservation> res = reservation.getAllReservation();
		model.addAttribute("reservation", res);
		return "ReservationList";
	}
	
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    reservation.deleteReservation(id);
	    return "redirect:/admin/reservation_List";      
	}
	
	@GetMapping("emprunt_List")
	public String EmpruntList(Model model) {
		
		List<Emprunt> emp = emprunt.getAllEmprunt();
		model.addAttribute("emprunt", emp);
		return "EmpruntList";
	}
	
	
	@RequestMapping("reservation_List/{id}")
	public String valider(@PathVariable(name = "id") long id) {
	 Emprunt empruntee =new Emprunt();
	 
	 Reservation res =reservation.getReservationById(id);
	 
	 empruntee.setEmp(res.getEmp());
	 empruntee.setLivre(res.getLivre());
	 empruntee.setDate_retour(java.sql.Date.valueOf(LocalDate.now().plusDays(3)));
	 
	 emprunt.saveOrUpdate(empruntee);
	 livre.availabilityminus(res.getLivre().getId());
	 reservation.deleteReservation(id);
	 
	 return "redirect:/admin/reservation_List";
	}
	
	
	@RequestMapping("Emprunt_delete/{id}")
		public String deleteEmprunt(@PathVariable(name = "id") int id) {

			Emprunt emp = emprunt.getEmpruntById(id);
		    livre.availabilityplus(emp.getLivre().getId());
		    emprunt.delete(id);
		    return "redirect:/admin/emprunt_List";   
	}
	
	
	
	/**
	@GetMapping("Emprunteur_List")
	public String EmprunteurList(Model model) {
		
		List<Emprunteur> res = reservation.getAllReservation();
		model.addAttribute("reservation", res);
		return "EmprunteurList";
	}
	*/

	

}
