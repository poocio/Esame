package it.uniroma3.siw.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Artist;
import it.uniroma3.siw.model.Painting;

public interface PaintingRepository   extends CrudRepository<Painting, Long>{
	
	public Optional<List<Painting>> findByArtist(Artist artist);

	public Optional<List<Painting>> findByYear(int year);
	
	public Optional<List<Painting>> findByTitle(String titolo);
	
	public Optional<List<Painting>> findByTechnique(String technique);
	
	
}
