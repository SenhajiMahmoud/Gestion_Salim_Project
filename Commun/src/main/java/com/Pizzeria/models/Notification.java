package com.Pizzeria.models;

/**
 * @author Mahmoud
 *
 */
public class Notification {
	private String idSession;
	
	private String idUser;
	
	private String userName;
	
	private String notificationDescription;
	
	private String notificationIcone;
	
	private String notificationEmailBody;
	
	private String notificationTitle;
	
	private String distanceTheorique;
	
	private String distanceGlobaleTheorique;
	
	private String stepsTrajet;
	
	private String nbPassagers_Total;
	//Facturation
	private String Date_paiement;
	
	private double montant_Total;
	
	private double PU;
	
	private double FraisReservation;
	
	private String TVA;

	private double nbPersReserve;

	private TypeNotification typeAlert;

	public Notification() {
	}

	public Notification(String idSession, String idUser, String userName, String notificationDescription,
			String notificationIcone, String notificationEmailBody, String notificationTitle, String distanceTheorique,
			String distanceGlobaleTheorique, String stepsTrajet, String nbPassagers_Total, String date_paiement,
			double montant_Total, double pU, double fraisReservation, String tVA, double nbPersReserve,
			TypeNotification typeAlert) {
		this.idSession = idSession;
		this.idUser = idUser;
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
		this.typeAlert = typeAlert;
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

	public String getIdSession() {
		return idSession;
	}

	public void setIdSession(String idSession) {
		this.idSession = idSession;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
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

	 

	public TypeNotification getTypeAlert() {
		return typeAlert;
	}

	public void setTypeAlert(TypeNotification typeAlert) {
		this.typeAlert = typeAlert;
	}
	
 

}
