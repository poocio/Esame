package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Transactional
	public Artist findById(Long id){
		Optional<Artist> result = artistRepository.findById(id);
		return result.orElse(null);
	}
	
	public List<Artist> findAll(){
		List<Artist> result = new ArrayList<>();
		Iterable<Artist> iterable = this.artistRepository.findAll();
		for(Artist artist : iterable)
			result.add(artist);
		return result;
	}
	
	 @Transactional
	 public Artist saveArtist(Artist artist) {
	     return this.artistRepository.save(artist);
	 }
	 
	 @Transactional
	 public void delete(long id){
		 this.artistRepository.deleteById(id);
		}
	
	

}
