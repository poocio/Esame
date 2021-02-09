package it.uniroma3.siw.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	private LocalDateTime creationTimestamp;
	
	private LocalDateTime lastUpdateTimestamp;

	
	@OneToOne
	private Painting paintingModify;
	
	@OneToMany
	private List<Painting> paintingVisibility;
	
	

	public User() {
		
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



	public LocalDateTime getCreationTimestamp() {
		return creationTimestamp;
	}



	public void setCreationTimestamp(LocalDateTime creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}



	public LocalDateTime getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}



	public void setLastUpdateTimestamp(LocalDateTime lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}



	public Painting getPaintingModify() {
		return paintingModify;
	}



	public void setPaintingModify(Painting paintingModify) {
		this.paintingModify = paintingModify;
	}



	public List<Painting> getPaintingVisibility() {
		return paintingVisibility;
	}



	public void setPaintingVisibility(List<Painting> paintingVisibility) {
		this.paintingVisibility = paintingVisibility;
	}



}
