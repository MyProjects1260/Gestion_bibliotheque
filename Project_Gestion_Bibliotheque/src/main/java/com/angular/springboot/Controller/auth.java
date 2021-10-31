package com.angular.springboot.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.angular.springboot.Model.Emprunteur;
import com.angular.springboot.Model.UserRegistrationDto;
import com.angular.springboot.Service.EmprunteurService;

@Controller
public class auth {
	
	
	  @GetMapping("/login")
	    public String login(Model model) {
	        return "login";
	    }
	  
	  @Autowired
	    private EmprunteurService userService;

	  @ModelAttribute("user")
	  public UserRegistrationDto userRegistrationDto() {
	      return new UserRegistrationDto();
	  }

	  @GetMapping("/registration")
	  public String showRegistrationForm() {
	      return "registration";
	  }

	  @PostMapping("/registration")
	  public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
	                                    BindingResult result){

		  Emprunteur existing = userService.findByEmail(userDto.getEmail());
	      if (existing != null){
	          result.rejectValue("email", null, "There is already an account registered with that email");
	      }

	      if (result.hasErrors()){
	          return "registration";
	      }

	      userService.save(userDto);
	      return "redirect:login";
	    }
}
