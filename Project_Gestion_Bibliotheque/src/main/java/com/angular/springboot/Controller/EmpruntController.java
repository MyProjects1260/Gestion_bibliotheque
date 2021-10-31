package com.angular.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.angular.springboot.Service.EmpruntServiceImp;

@Controller

public class EmpruntController {

	@Autowired
	EmpruntServiceImp emprunt;
	
	
}
