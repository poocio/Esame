package it.uniroma3.siw.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.session.SessionData;
import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.PaintingService;


@Controller
public class PaintingController {
	
	
	@Autowired
	private PaintingService paintingService;
	
	@Autowired
	private SessionData sessionData;
	
	
	@RequestMapping(value = { "/researchPainting" }, method = RequestMethod.GET)
	   public String home(Model model) {
	       User loggedUser = sessionData.getLoggedUser();
	       model.addAttribute("user", loggedUser);
	       return "research";
	   }
	

	@RequestMapping(value = "/researchYear", method = RequestMethod.GET)
	public String getAnno(Model model) {
		Set<Integer> years = paintingService.selectYears();
		model.addAttribute("years", years);
		return "years";
	}
	
	@RequestMapping(value = "/paintingsByYear/{year}", method = RequestMethod.GET)
	public String opereByAnno(@PathVariable int year,
						Model model) {
		List<Painting> paintings = paintingService.getPainting(year);
		model.addAttribute("paintingsByYear", paintings);
		return "paintingsByYear";
	}
	
	@RequestMapping(value = "/paintingsById/{id}", method = RequestMethod.GET)
	public String opereByTitolo(@PathVariable long id,
						Model model) {
		Painting paintings = paintingService.findById(id);
		model.addAttribute("paintingsById", paintings);
		return "paintingsById";
	}
	
	@RequestMapping(value = "/allPaintings", method = RequestMethod.GET)
	 public String getOpere(Model model) {
	  List<Painting> paintings = paintingService.findAll();
	  model.addAttribute("paintings", paintings);
	  return "paintings";
	 }

}
