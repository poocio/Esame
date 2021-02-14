package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;


@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Size(min=2, max=100, message="Il nome deve essere compreso tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String firstName;
	
	@Size(min=2, max=100, message="Il cognome deve essere compreso tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String lastName;
	
	@Size(min=2, max=100, message="La nazione deve essere compresa tra 2 e 100 caratteri")
	@Column(nullable = false)
	private String nation;
	
	@Size(min=1, message="Campo obbligatorio")
	private String dateOfBirth;
	
	private String dateOfDeath;
	
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private List<Painting> painting;

	public Artist() {
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public List<Painting> getPainting() {
		return painting;
	}

	public void setPainting(List<Painting> painting) {
		this.painting = painting;
	}

	
	





}
