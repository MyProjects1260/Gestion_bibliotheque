package com.angular.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.angular.springboot.Model.Reservation;
import com.angular.springboot.Service.EmprunteurServiceImp;
import com.angular.springboot.Service.LivreServiceImp;
import com.angular.springboot.Service.ReservationServiceImpl;

@Controller	
@RequestMapping("/")
public class EmprunteurController {

	@Autowired
	ReservationServiceImpl reservation;
	
	@Autowired
	EmprunteurServiceImp emp;
	
	@Autowired
	LivreServiceImp livre;
	
	@GetMapping("reserver")
	public String ListReservation(@RequestParam("id") Long id, Model model) {
			Reservation reser = new Reservation();
			reser.setId(id);
			model.addAttribute("res", reser);
			return "AddReservation";
	}
	
	@PostMapping("reservation/save")
	public String saveOrUpdate(@RequestParam("id") Long id, @ModelAttribute("res") Reservation res, Authentication authentication) {
			String name =authentication.getName();
			res.setEmp(emp.findByEmail(name));
			res.setLivre(livre.getLivreById(id));
			reservation.saveOrUpdate(res);
			return "redirect:/image/show";
	}
	
}
