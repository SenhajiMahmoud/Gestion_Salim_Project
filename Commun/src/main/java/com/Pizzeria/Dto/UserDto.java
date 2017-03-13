package com.Pizzeria.Dto;

/**
 * @author Mahmoud
 *
 */
public class UserDto {
	
	private int id;
	private String Nom;
	private String prenom;
	private String ville;
	private String adresse;
	private String CPostale;
	private String email;
	private String password;
	public UserDto() {
	}
	public UserDto(int id, String nom, String prenom, String ville, String adresse, String cPostale, String email,
			String password) {
		this.id = id;
		Nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.adresse = adresse;
		CPostale = cPostale;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCPostale() {
		return CPostale;
	}
	public void setCPostale(String cPostale) {
		CPostale = cPostale;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
