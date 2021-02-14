package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.controller.validation.CredentialsValidator;
import it.uniroma3.siw.controller.validation.UserValidator;
import it.uniroma3.siw.service.CredentialsService;

@Controller
public class AuthenticationController {
	
	    @Autowired
	    CredentialsService credentialsService;

	    @Autowired
	    UserValidator userValidator;

	    @Autowired
	    CredentialsValidator credentialsValidator;
	    
	    
	    @GetMapping("/login")
	    public String login() {
	    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	
	    	if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
	    		return "login";
	    	}
	    	return "redirect:/home";
	    }


	
	    @RequestMapping(value = { "/users/register" }, method = RequestMethod.GET)
	    public String showRegisterForm(Model model) {
	        model.addAttribute("userForm", new User());
	        model.addAttribute("credentialsForm", new Credentials());

	        return "registerUser";
	    }

	
	
	  @RequestMapping(value = { "/users/register" }, method = RequestMethod.POST)
	   public String registerUser(@Valid @ModelAttribute("userForm") User user,
	                               BindingResult userBindingResult,
	                               @Valid @ModelAttribute("credentialsForm") Credentials credentials,
	                               BindingResult credentialsBindingResult,
	                               Model model) {

	        // validate user and credentials fields
	        this.userValidator.validate(user, userBindingResult);
	        this.credentialsValidator.validate(credentials, credentialsBindingResult);

	        // if neither of them had invalid contents, store the User and the Credentials into the DB
	        if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
	            // set the user and store the credentials;
	            // this also stores the User, thanks to Cascade.ALL policy
	            credentials.setUser(user);
	            credentialsService.saveCredentials(credentials);
	            return "registrationSuccessful";
	        }
	        return "registerUser";
	    }
}
