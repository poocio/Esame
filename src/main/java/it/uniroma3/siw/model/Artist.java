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

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateOfDeath == null) ? 0 : dateOfDeath.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateOfDeath == null) {
			if (other.dateOfDeath != null)
				return false;
		} else if (!dateOfDeath.equals(other.dateOfDeath))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		return true;
	}



}
