<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<title>
	<spring:message  code='candidat.title' />
</title>
	<link rel="stylesheet" href="site/css/StyleCandidature.css">
	<link rel="stylesheet" href="site/css/navBar.css">
	<link rel="stylesheet" href="site/css/FormCSS.css">
	
	
		<script type="text/javascript">
			function dis() {
				 
				var waiting = document.getElementById("loading");
				 
					waiting.style.display = "block";
				 
			}
		</script>
		
		<script type="text/javascript">
			function envoiData(){
				
				var url = "addCandidature.do";
			}
		</script>
		
</head>
<body>
	
	<div id="loading" style="display: none">
		<div class="PosLogoText">
			<span class="envoiEnCours">Envoi En cours...</span>
			<span class="imgpos"> <img alt="Win" src="site/img/win.png">
			</span>
		</div>
	</div>

	<jsp:include page="../views/header.jsp" />
	
	<div id="infoNav">
		<div class="title">
			<h5>Home/<spring:message  code='candidat.title' /></h5>
		</div>
		<div id="separator"></div>
	</div>

	<div id="content">
		<div class="bodyForm">
		 
		 <form class="FormStyle" action="addCandidature.do" method="post" >
		 
			 <table>
				<tr>
					<td><spring:message  code='candidat.civilite' /> *: </td>
					<td>
						<select name="civilite" >
						  <option value=""><spring:message  code='candidat.dDisponibilite.Choisissez' text="missing"/>..</option>
						  <option value="Monsieur">M.</option>
						  <option value="Madame">Mme</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.nom' />  *:</td>
					<td><input type="text" name="nom" placeholder="Nom" size="60" height="10"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.prenom' /> *:</td>
					<td><input type="text" name="prenom" placeholder="Prénom " size="60" height="10"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.adresse' /> *:</td>
					<td><input type="text" name="adresse" placeholder="Adresse"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.DNaissance' /> *: </td>
					<td><input type="text" name="dateNaissance" placeholder="Date de Naissance">
					<br/>
					<span style="font-size: 10px;">Format JJ/MM/AAAA- Exemple 28/03/1988 pour 28 Mars 1988</span>
					</td>
				</tr>
					
				<tr>
					<td><spring:message  code='candidat.CPostale' />: </td>
					<td><input type="text" name="codepostale" placeholder="Code postale"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.Ville' />: </td>
					<td><input type="text" name="Ville" placeholder="Ville"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.email' /> *: </td>
					<td><input type="email" name="Email" placeholder="E-mail"></td>
				</tr>
				<tr> 
					<td><spring:message  code='candidat.Tel' /> *: </td>
					<td><input type="text" name="Tel" placeholder="Telephone"></td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.Profil' /></td>
				</tr>
				
				<tr> 
					<td><spring:message  code='candidat.poste' /> *: </td>
					<td>
						<select name="Poste">
						  <option value=""><spring:message  code='candidat.dDisponibilite.Choisissez' />..</option>
						  <option value="Livreur" > <spring:message  code='candidat.Livreur' /> </option>
						  <option value="Pizzaiolo" > <spring:message  code='candidat.Pizzaiolo' /> </option>
						</select>
					</td>
				</tr>
				
				<tr> 
					<td><spring:message  code='candidat.NExperience' /> *: </td>
					<td>
						<select name="Experience">
						  <option value=""><spring:message  code='candidat.dDisponibilite.Choisissez' />..</option>
						  <option value=" > 1 an" > > 1 an</option>
						  <option value="1-2 ans" >1-2 ans </option>
						  <option value="2-5 ans">	2-5 ans </option>
						  <option value="5-10 ans"> 5-10 ans </option>
						  <option value=" > 10 ans">  > 10 ans </option>
						</select>
					</td>
				</tr>
				<tr> 
					<td><spring:message  code='candidat.enPoste' /> *: </td>
					<td>
						<input type="radio" name="enPoste" value="oui"><spring:message  code='candidat.enPoste.oui' />
						<input type="radio" name="enPoste" value="Non"><spring:message  code='candidat.enPoste.non' />
					</td>
				</tr>
				<tr>
					<td><spring:message  code='candidat.dDisponibilite' />:</td>
					<td>
						<select name="Disponibilite">
						  <option value=""><spring:message  code='candidat.dDisponibilite.Choisissez' />..</option>
						  <option value="Immediat" ><spring:message  code='candidat.dDisponibilite.Immediat'  /></option>
						  <option value="sup3mois">	<spring:message  code='candidat.dDisponibilite.sup3mois' /></option>
						  <option value="inf3mois">	<spring:message  code='candidat.dDisponibilite.Inf3mois' /></option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td><spring:message  code='candidat.Langues' />:</td>
					<td><br/><br/><br/><br/>
						Français :
						
						<select name="Langues" style="margin-left: 50px;">
						  <option value=""><spring:message  code='candidat.dDisponibilite.Choisissez' />..</option>
						  <option value="Non Parlée" >Non Parlée</option>
						  <option value="Notions">	Notions</option>
						  <option value="Moyen">	Moyen</option>
						  <option value="Bon">	Bon</option>
						  <option value="Courant">	Courant</option>
						</select></td>
				</tr>
				
				<tr>
					<td><spring:message  code='candidat.Permis' /></td>
	 
					<td>
						<input type="radio" name="PermisB" value="oui"><spring:message  code='candidat.Permis.oui' />
						<input type="radio" name="PermisB" value="Non"><spring:message  code='candidat.Permis.non' />
					</td>
				</tr>
				
				<tr> 
					<td><spring:message  code='candidat.vehicule' text="Missing"/> *: </td>
					<td>
						<input type="radio" name="vehicule" value="oui"><spring:message  code='candidat.vehicule.oui' text="Missing"/>
						<input type="radio" name="vehicule" value="Non"><spring:message  code='candidat.vehicule.non' text="Missing"/>
					</td>
				</tr>
				
			</table> 
			
			<input onclick="dis()" type="submit" value="<spring:message  code='Form.Valider' />">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		 </form> 
		 </div>
		 
		  
		  <br/><br/><br/><br/><br/><br/>
		  
		  <!-- <form method="post" action="test.do" enctype="multipart/form-data">
			
			<label>Choississez des fichiers de taille qui ne depasse pas 1Mo et l'extension doit etre en pdf ou docx</label>
			
			<table id="uploadTable" >
				<tr>
					<td><input name="cv" type="file" /></td>
				</tr>
				<tr>
					<td><input name="lettre" type="file" /></td>
				</tr>
			</table>
			<br />
			<input type="submit" value="Upload Files" /> 
		</form> -->
		  <!--  <iframe	
						src="http://www.facebook.com/plugins/likebox.php?href=http%3A%2F%2Fwww.facebook.com%2FPizzaWinWin%2F;width=235&amp;height=258&amp;colorscheme=light&amp;show_faces=true&amp;header=false&amp;stream=false&amp;show_border=false&amp;appId=438889712801266"
						style="border: none; 
						overflow: hidden; 
						width: 235px; 
						height: 258px;">
		 </iframe>  -->
		
		 
		 <!-- <iframe class="r_corners full_width" 
				id="gmap_mini" width="1350" height="320"
				src="https://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=ru&amp;geocode=&amp;q=liege,+New+York,+NY,+United+States&amp;aq=0&amp;oq=monheten&amp;sll=37.0625,-95.677068&amp;sspn=65.430355,129.814453&amp;t=m&amp;ie=UTF8&amp;hq=&amp;hnear=%D0%9C%D0%B0%D0%BD%D1%85%D1%8D%D1%82%D1%82%D0%B5%D0%BD,+%D0%9D%D1%8C%D1%8E-%D0%99%D0%BE%D1%80%D0%BA,+%D0%9D%D1%8C%D1%8E+%D0%99%D0%BE%D1%80%D0%BA,+%D0%9D%D1%8C%D1%8E-%D0%99%D0%BE%D1%80%D0%BA&amp;ll=40.790278,-73.959722&amp;spn=0.015612,0.031693&amp;z=13&amp;output=embed">
		</iframe> -->
	</div>
	
	
	<jsp:include page="../views/Footer.jsp" />
	 
	<!-- <script src="site/js/mousScrollFluide.js" ></script> -->
</body>
</html>