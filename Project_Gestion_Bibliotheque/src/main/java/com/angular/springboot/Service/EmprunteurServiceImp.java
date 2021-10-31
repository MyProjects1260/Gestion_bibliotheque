package com.angular.springboot.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.springboot.Model.Emprunteur;
import com.angular.springboot.Model.Role;
import com.angular.springboot.Model.UserRegistrationDto;
import com.angular.springboot.Repository.EmprunteurRepository;

@Service
@Transactional
public class EmprunteurServiceImp implements EmprunteurService {

	 @Autowired
	 private EmprunteurRepository userRepository;

	 @Autowired
	 private PasswordEncoder passwordEncoder;

	 

	    public Emprunteur findByEmail(String email){
	        return userRepository.findByEmail(email);
	    }

	    public Emprunteur save(UserRegistrationDto registration){
	    	Emprunteur user = new Emprunteur();
	        user.setPrenom(registration.getFirstName());
	        user.setNom(registration.getLastName());
	        user.setEmail(registration.getEmail());
	        user.setPassword(passwordEncoder.encode(registration.getPassword()));
	        user.setAge(registration.getAge());
	        user.setTel(registration.getTel());
	        user.setVille(registration.getVille());
	        user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
	        return userRepository.save(user);
	    }

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    	Emprunteur user = userRepository.findByEmail(email);
	        if (user == null){
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(),
	                user.getPassword(),
	                mapRolesToAuthorities(user.getRoles()));
	    }

	    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }

		@Override
		public List<Emprunteur> findAll() {
			return userRepository.findAll();
		}

		@Override
		public void deleteEmprunteur(long id) {
			userRepository.deleteById(id);
			
		}
		
	  
}
