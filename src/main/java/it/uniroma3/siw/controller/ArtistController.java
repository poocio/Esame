package it.uniroma3.siw.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.service.ArtistService;
import it.uniroma3.siw.service.PaintingService;

@Controller
public class ArtistController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private PaintingService paintingService;

	
	@RequestMapping(value = "paintingsByArtist/{id}", method = RequestMethod.GET)
	public String opereByAutore(@PathVariable long id,
						Model model) {
		Artist artist = artistService.findById(id);
		List<Painting> paintings = paintingService.getPainting(artist);
		
		model.addAttribute("artist", artist);
		model.addAttribute("paintingsByArtist", paintings);
		return "paintingsByArtist";
	}

	
	@RequestMapping(value = "/artistById/{id}", method = RequestMethod.GET)
	public String opereByTitolo(@PathVariable long id,
						Model model) {
		Artist artist = artistService.findById(id);
		model.addAttribute("artist", artist);
		return "showArtist";
	}
	
	@RequestMapping(value = "researchArtist", method = RequestMethod.GET)
	public String getArtist(Model model) {
		List<Artist> artists = artistService.findAll();
		model.addAttribute("artists", artists);
		return "artists";
	}
}
