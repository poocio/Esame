package it.uniroma3.siw.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.ArtistService;
import it.uniroma3.siw.service.PaintingService;

@Component
public class ArtistValidator implements Validator {
	
	

	final Integer MAX_NAME_LENGTH = 100;
	final Integer MIN_NAME_LENGTH = 2;

	 @Autowired
	 ArtistService artistService;
	 
	 @Override
	 public boolean supports(Class<?> clazz) {
		 return Painting.class.equals(clazz);
	 }
	 
	 @Override
	 public void validate (Object o, Errors errors) {
		 Artist artist= (Artist) o;
	  String firstName = artist.getFirstName().trim();
	  String lastName = artist.getLastName().trim();
	  String nation = artist.getNation();

	  if (firstName.isBlank())
		   errors.rejectValue("firstName", "required");
		  else if (firstName.length() < MIN_NAME_LENGTH || firstName.length() > MAX_NAME_LENGTH)
		   errors.rejectValue("firstName", "size");
		  

		  if (lastName.isBlank())
		   errors.rejectValue("lastName", "required");
		  else if (lastName.length() < MIN_NAME_LENGTH || lastName.length() > MAX_NAME_LENGTH)
		   errors.rejectValue("lastName", "size");
		  
		  if (nation.isBlank())
		   errors.rejectValue("nation", "required");
		  else if (nation.length() < MIN_NAME_LENGTH || nation.length() > MAX_NAME_LENGTH)
		   errors.rejectValue("nation", "size");
		  
		  if(ricercaDoppione(artist))
		   errors.rejectValue("firstName", "duplicate");
		  
	 }
	 
	 private boolean ricercaDoppione(Artist o) {
	  List<Artist> artists = artistService.findByFirstName(o.getFirstName());
	  for(Artist artist : artists) {
	   if(artist.equals(o))
	    return true;
	  }
	  
	  return false;
	 }

	}
