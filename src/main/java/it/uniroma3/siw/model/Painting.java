package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
public class Painting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min=2, max=100, message="Il titolo deve essere compreso tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String title;
	
	@Size(min=2, max=100, message="La tecnica deve essere compresa tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String technique;
	
	@Size(min=2, max=100, message="La dimensione deve essere compresa tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String size;
	
	@Column(nullable = false)
	private int year;
	
	@ManyToOne
	private Artist artist; 

	
	public Painting() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTechnique() {
		return technique;
	}

	public void setTechnique(String technique) {
		this.technique = technique;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}

	