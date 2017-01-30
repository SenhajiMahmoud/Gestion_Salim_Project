package com.Pizzeria.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {
	@Id 
	@GeneratedValue
	@Column
	private String idNotif;
	
	@Column private String userName;
	@Column private String notificationDescription;
	@Column private String notificationIcone;
	@Column private String notificationEmailBody;
	@Column private String notificationTitle;
	@Column private String distanceTheorique;
	@Column private String distanceGlobaleTheorique;
	@Column private String stepsTrajet;
	@Column private String nbPassagers_Total;
	//Facturation
	@Column private String Date_paiement;
	@Column private double montant_Total;
	@Column private double PU;
	@Column private double FraisReservation;
	@Column private String TVA;
	@Column private double nbPersReserve;
	public Notification() {
		super();
	}
	public Notification(String idNotif, String userName, String notificationDescription, String notificationIcone,
			String notificationEmailBody, String notificationTitle, String distanceTheorique,
			String distanceGlobaleTheorique, String stepsTrajet, String nbPassagers_Total, String date_paiement,
			double montant_Total, double pU, double fraisReservation, String tVA, double nbPersReserve) {
		super();
		this.idNotif = idNotif;
		this.userName = userName;
		this.notificationDescription = notificationDescription;
		this.notificationIcone = notificationIcone;
		this.notificationEmailBody = notificationEmailBody;
		this.notificationTitle = notificationTitle;
		this.distanceTheorique = distanceTheorique;
		this.distanceGlobaleTheorique = distanceGlobaleTheorique;
		this.stepsTrajet = stepsTrajet;
		this.nbPassagers_Total = nbPassagers_Total;
		Date_paiement = date_paiement;
		this.montant_Total = montant_Total;
		PU = pU;
		FraisReservation = fraisReservation;
		TVA = tVA;
		this.nbPersReserve = nbPersReserve;
	}
	public String getIdNotif() {
		return idNotif;
	}
	public void setIdNotif(String idNotif) {
		this.idNotif = idNotif;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNotificationDescription() {
		return notificationDescription;
	}
	public void setNotificationDescription(String notificationDescription) {
		this.notificationDescription = notificationDescription;
	}
	public String getNotificationIcone() {
		return notificationIcone;
	}
	public void setNotificationIcone(String notificationIcone) {
		this.notificationIcone = notificationIcone;
	}
	public String getNotificationEmailBody() {
		return notificationEmailBody;
	}
	public void setNotificationEmailBody(String notificationEmailBody) {
		this.notificationEmailBody = notificationEmailBody;
	}
	public String getNotificationTitle() {
		return notificationTitle;
	}
	public void setNotificationTitle(String notificationTitle) {
		this.notificationTitle = notificationTitle;
	}
	public String getDistanceTheorique() {
		return distanceTheorique;
	}
	public void setDistanceTheorique(String distanceTheorique) {
		this.distanceTheorique = distanceTheorique;
	}
	public String getDistanceGlobaleTheorique() {
		return distanceGlobaleTheorique;
	}
	public void setDistanceGlobaleTheorique(String distanceGlobaleTheorique) {
		this.distanceGlobaleTheorique = distanceGlobaleTheorique;
	}
	public String getStepsTrajet() {
		return stepsTrajet;
	}
	public void setStepsTrajet(String stepsTrajet) {
		this.stepsTrajet = stepsTrajet;
	}
	public String getNbPassagers_Total() {
		return nbPassagers_Total;
	}
	public void setNbPassagers_Total(String nbPassagers_Total) {
		this.nbPassagers_Total = nbPassagers_Total;
	}
	public String getDate_paiement() {
		return Date_paiement;
	}
	public void setDate_paiement(String date_paiement) {
		Date_paiement = date_paiement;
	}
	public double getMontant_Total() {
		return montant_Total;
	}
	public void setMontant_Total(double montant_Total) {
		this.montant_Total = montant_Total;
	}
	public double getPU() {
		return PU;
	}
	public void setPU(double pU) {
		PU = pU;
	}
	public double getFraisReservation() {
		return FraisReservation;
	}
	public void setFraisReservation(double fraisReservation) {
		FraisReservation = fraisReservation;
	}
	public String getTVA() {
		return TVA;
	}
	public void setTVA(String tVA) {
		TVA = tVA;
	}
	public double getNbPersReserve() {
		return nbPersReserve;
	}
	public void setNbPersReserve(double nbPersReserve) {
		this.nbPersReserve = nbPersReserve;
	}
	
	
	
}
