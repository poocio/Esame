package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;
import it.uniroma3.siw.model.User;
import it.uniroma3.siw.repository.PaintingRepository;



@Service
public class PaintingService {
	
	 @Autowired
	 protected PaintingRepository paintingRepository;
	 
	 @Transactional
	 public Painting getPainting(Painting title)
	 {
		 Optional<Painting> result = this.paintingRepository.findByTitle(title);
		 return result.orElse(null);
	 }
	 
	 @Transactional
	 public List<Painting> findAll(){
		 List<Painting> result = new ArrayList<>();
	        Iterable<Painting> iterable = this.paintingRepository.findAll();
	        for(Painting painting : iterable)
	            result.add(painting);
	        return result;
	 }
	 
	 @Transactional 
	 public Set<Integer> selectYears() {
	  Set<Integer> result = new HashSet<>();
	  Iterable<Painting> iterable = this.paintingRepository.findAll();
	        for(Painting Painting : iterable)
	            result.add(Painting.getYear());
	        return result;
	 }
	 
	 public Painting findById(long id)
	 {
		 Optional<Painting> result = this.paintingRepository.findById(id);
		 return result.orElse(null);
	}
	 
	 public Optional <List<Painting>> findByTechnique(String technique){
			return this.paintingRepository.findByTechnique(technique);
		}
	 
	 @Transactional
	 public List<Painting> getPainting(int year)
	 {
		 Optional<List<Painting>> result = this.paintingRepository.findByYear(year);
		 return result.orElse(null);
	 }

	 @Transactional
	 public List<Painting> getPainting(Artist artist)
	 {
		 Optional<List<Painting>> result = this.paintingRepository.findByArtist(artist);
		 return result.orElse(null);
	 }
	 
	 @Transactional
	 public Painting savePainting(Painting painting) {
	     return this.paintingRepository.save(painting);
	 }
	 

	 @Transactional
	 public void delete(long id){
		 this.paintingRepository.deleteById(id);
		}
	 
}
