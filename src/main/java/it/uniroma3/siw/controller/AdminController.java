package it.uniroma3.siw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.siw.controller.session.SessionData;
import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.service.ArtistService;
import it.uniroma3.siw.service.PaintingService;

@Controller
public class AdminController {
	
	 @Autowired
	    SessionData sessionData;
	 
	 @Autowired
		private PaintingService paintingService;
	 
	 @Autowired
		private ArtistService artistService;
	 
	
	 @RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	    public String admin(Model model) {
	        User loggedUser = sessionData.getLoggedUser();
	        model.addAttribute("user", loggedUser);
	        return "admin";
	    }
	 

	 
	 @RequestMapping(value = "/admin/paintings", method = RequestMethod.GET)
	 public String getOpere(Model model) {
	  List<Painting> paintings = paintingService.findAll();
	  model.addAttribute("paintings", paintings);
	  return "paintings";
	 }
	 
	 @RequestMapping(value = "/admin/paintings/{id}/remove", method = RequestMethod.POST)
	    public String delete(@PathVariable long id,
	     Model model) {
		 paintingService.delete(id);
		 return "redirect:/admin/paintings";
	    }
	 
	 @RequestMapping(value = "/admin/addPainting", method = RequestMethod.GET)
	 public String addOpera(Model model) {
		 User loggedUser = sessionData.getLoggedUser();
		 List<Artist> artists = artistService.findAll();
		 model.addAttribute("user", loggedUser);
		 model.addAttribute("painting",new Painting());
		 model.addAttribute("artists", artists);
		 return "addPainting";
		 
	 }
	 
	 @RequestMapping( value = "/admin/addPainting", method = RequestMethod.POST)
	  public String checkOperaInfo(@Valid @ModelAttribute Painting painting, 
	    									BindingResult bindingResult, Model model) {
	    	
	        if (bindingResult.hasErrors()) {
	        	List<Artist> artists = artistService.findAll();
	            model.addAttribute("artists", artists);
	            return "addPainting";
	        }
	        else {
	        	model.addAttribute(painting);
	        	paintingService.savePainting(painting);
	        }
	        return "showPainting";
	    }
	 
	 @RequestMapping(value = "/admin/addArtist", method = RequestMethod.GET)
	 public String addAutore(Model model) {
		 User loggedUser = sessionData.getLoggedUser();
		 model.addAttribute("user", loggedUser);
		 model.addAttribute("artist",new Artist());
		 return "addArtist";
		 
	 }
	 
	 @RequestMapping( value = "/admin/addArtist", method = RequestMethod.POST)
	  public String checkArtistInfo(@Valid @ModelAttribute Artist artist, 
	    									BindingResult bindingResult, Model model) {
	    	
	        if (bindingResult.hasErrors()) {
	        	
	            return "addArtist";
	        }
	        else {
	        	
	        	model.addAttribute(artist);
	        	artistService.saveArtist(artist);
	        }
	        
	        return "redirect:/admin/addPainting";
	    }
	
}
