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
	private String Ville;

	@Column(name = "Email")
	private String Email;

	@Column(name = "Telephone")
	private String Tel;

	@Column(name = "Experience")
	private String Experience;

	@Column(name = "enPoste")
	private String enPoste;

	@Column(name = "Disponibilite")
	private String Disponibilite;

	@Column(name = "Langues")
	private String Langues;

	@Column(name = "PermisB")
	private String PermisB;

	@Column(name = "vehicule")
	private String vehicule;

	public Candidature() {
	}

	public Candidature(int id, String civilite, String nom, String prenom, String adresse, String dateNaissance,
			Long codepostale, String ville, String email, String tel, String experience, String enPoste,
			String disponibilite, String langues, String permisB, String vehicule) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.codepostale = codepostale;
		Ville = ville;
		Email = email;
		Tel = tel;
		Experience = experience;
		this.enPoste = enPoste;
		Disponibilite = disponibilite;
		Langues = langues;
		PermisB = permisB;
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
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getEnPoste() {
		return enPoste;
	}

	public void setEnPoste(String enPoste) {
		this.enPoste = enPoste;
	}

	public String getDisponibilite() {
		return Disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		Disponibilite = disponibilite;
	}

	public String getLangues() {
		return Langues;
	}

	public void setLangues(String langues) {
		Langues = langues;
	}

	public String getPermisB() {
		return PermisB;
	}

	public void setPermisB(String permisB) {
		PermisB = permisB;
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
