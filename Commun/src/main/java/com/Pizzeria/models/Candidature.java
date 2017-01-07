package com.Pizzeria.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

/**
 * @author Mahmoud
 *
 */
@Entity
@Table(name = "tb_candidature")
@Scope("session")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_candidat")
	private int id;

	@Column(name = "civilite")
	private String civilite;

	@Column(name = "poste")
	private String poste;

	@Column(name = "nom_candidat")
	private String nom;

	@Column(name = "prenom_candidat")
	private String prenom;

	@Column(name = "adresse_candidat")
	private String adresse;

	@Column(name = "date_de_Naissance")
	private String dateNaissance;

	@Column(name = "code_postale")
	private Long codepostale;

	@Column(name = "Ville")
	private String ville;

	@Column(name = "Email")
	private String email;

	@Column(name = "Telephone")
	private String tel;

	@Column(name = "Experience")
	private String experience;

	@Column(name = "enPoste")
	private String enPoste;

	@Column(name = "Disponibilite")
	private String disponibilite;

	@Column(name = "Langues")
	private String langues;

	@Column(name = "PermisB")
	private String permisB;

	@Column(name = "vehicule")
	private String vehicule;

	public Candidature() {
		super();
	}

	public Candidature(int id, String civilite, String poste, String nom, String prenom, String adresse,
			String dateNaissance, Long codepostale, String ville, String email, String tel, String experience,
			String enPoste, String disponibilite, String langues, String permisB, String vehicule) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.poste = poste;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.codepostale = codepostale;
		this.ville = ville;
		this.email = email;
		this.tel = tel;
		this.experience = experience;
		this.enPoste = enPoste;
		this.disponibilite = disponibilite;
		this.langues = langues;
		this.permisB = permisB;
		this.vehicule = vehicule;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Long getCodepostale() {
		return codepostale;
	}

	public void setCodepostale(Long codepostale) {
		this.codepostale = codepostale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEnPoste() {
		return enPoste;
	}

	public void setEnPoste(String enPoste) {
		this.enPoste = enPoste;
	}

	public String getDisponibilite() {
		return disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public String getLangues() {
		return langues;
	}

	public void setLangues(String langues) {
		this.langues = langues;
	}

	public String getPermisB() {
		return permisB;
	}

	public void setPermisB(String permisB) {
		this.permisB = permisB;
	}

	public String getVehicule() {
		return vehicule;
	}

	public void setVehicule(String vehicule) {
		this.vehicule = vehicule;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 

}
