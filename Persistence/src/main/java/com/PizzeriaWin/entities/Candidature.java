package com.PizzeriaWin.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_candidature")
public class Candidature{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_candidat")
	private int id;

	@Column(name = "civilite")
	private String civilite;

	@Column(name = "poste")
	private String poste;

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

//	@Column(name = "nom_candidat")
//	private String nom;
//
//	@Column(name = "prenom_candidat")
//	private String prenom;
//
//	@Column(name = "adresse_candidat")
//	private String adresse;
//
//	@Column(name = "date_de_Naissance")
//	private String dateNaissance;
//
//	@Column(name = "code_postale")
//	private Long codepostale;
//
//	@Column(name = "Ville")
//	private String ville;
//
//	@Column(name = "Email")
//	private String email;
//
//	@Column(name = "Telephone")
//	private String tel;
//
//	@Column(name = "Experience")
//	private String experience;
//
//	@Column(name = "enPoste")
//	private String enPoste;
//
//	@Column(name = "Disponibilite")
//	private String disponibilite;
//
//	@Column(name = "Langues")
//	private String langues;
//
//	@Column(name = "PermisB")
//	private String permisB;
//
//	@Column(name = "vehicule")
//	private String vehicule;

	 

}
