package it.uniroma3.siw.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.PaintingService;

@Component
public class PaintingValidator implements Validator {
	
	

	final Integer MAX_NAME_LENGTH = 100;
	final Integer MIN_NAME_LENGTH = 2;

	 @Autowired
	 PaintingService paintingService;
	 
	 @Override
	 public boolean supports(Class<?> clazz) {
		 return Painting.class.equals(clazz);
	 }
	 
	 @Override
	 public void validate (Object o, Errors errors) {
	  Painting opera = (Painting) o;
	  String tecnica = opera.getTechnique().trim();
	  String titolo = opera.getTitle().trim();
	  String dimensione = opera.getSize().trim();


	  if (tecnica==null || tecnica.trim().isEmpty())
	   errors.rejectValue("technique", "required");
	  else if (tecnica.length() < MIN_NAME_LENGTH || tecnica.length() > MAX_NAME_LENGTH)
	   errors.rejectValue("technique", "size");
	  else if(ricercaDoppione(opera))
	   errors.rejectValue("title", "duplicate");

	  if (titolo==null || titolo.trim().isEmpty())
	   errors.rejectValue("title", "required");
	  else if (titolo.length() < MIN_NAME_LENGTH || titolo.length() > MAX_NAME_LENGTH)
	   errors.rejectValue("title", "size");
	  
	  if (dimensione==null || dimensione.trim().isEmpty())
		   errors.rejectValue("size", "required");
		  else if (dimensione.length() < MIN_NAME_LENGTH || titolo.length() > MAX_NAME_LENGTH)
		   errors.rejectValue("size", "size");

	 }
	 private boolean ricercaDoppione(Painting o) {
	  List<Painting> opereArte = paintingService.getPainting(o.getTitle());
	  for(Painting opera : opereArte) {
	   if(opera.equals(o))
	    return true;
	  }
	  
	  return false;
	 }

	}
