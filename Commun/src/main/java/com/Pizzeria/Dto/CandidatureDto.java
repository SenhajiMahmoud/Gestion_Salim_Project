package com.Pizzeria.Dto;

import java.io.Serializable;


public class CandidatureDto implements Serializable{

	private int id;
	private String civilite;
	private String poste;
//	private String nom;
//	private String prenom;
//	private String adresse;
//	private String dateNaissance;
//	private Long codepostale;
//	private String ville;
//	private String email;
//	private String tel;
//	private String experience;
//	private String enPoste;
//	private String disponibilite;
//	private String langues;
//	private String permisB;
//	private String vehicule;
	
	
	public CandidatureDto() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCivilite() {
		return civilite;
	}


	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}

 
	
}
