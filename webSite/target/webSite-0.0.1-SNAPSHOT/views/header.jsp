<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="site/Commun/CSS/StyleHeader.css"  />
	
	<link   rel='stylesheet' 
        id='theme-style-css'
	    href='site/Commun/CSS/resSociaux.css'
	    type='text/css' 
        media='screen' />
		
</head>
<body>
	
	<div class="sideBarr">
		
		<nav class="conn pos" >
				<span>				 <a href="#"><spring:message  code='Menu.Inscription' /></a></span>
				<span class="margin"><a href="connexionPage.do"><spring:message  code='Menu.connexion' /></a></span>
		</nav>  
		
		<a id="nav-logo" href="index.jsp" title="WinWin" > <img alt="" src="site/Commun/Images/win.png" /> </a> 
	 
		<div class="reseaux">
				<div class="header_inner">
						<div class="wrap_social_icons">
                            <ul class="social_icons">
									<li>
										<a 	target="_blank"
										    href="https://twitter.com/eudonet_crm"
										    title="Win"> 
											
											<img src="site/Commun/Images/twitter_header.png"/>
										</a>
									</li>
									<li>
										<a  target="_blank"
											href="https://www.facebook.com/Eudonet"
											title="PizzeriaWin"> 
											
											<img src="site/Commun/Images/facebook_header.png" />
										</a>
									</li>
								</ul>
						</div>
                   </div>
			</div>
	</div>
	
	<div id="siteWrapper">
		<header>
				<div id="nav-bar">
					<div class="trait"></div>
					<div class="container">
						 	<nav class="pages">
								<ul>
									<li><a href="apropos.do" title="About"><spring:message  code='Menu.apropos' /></a></li>
									<li><a href="menu.do" title="Menu"><spring:message  code='Menu.Menu' /></a></li>
									<li><a href="agenda.do" title="Planning"><spring:message  code='Menu.Planning' /></a></li>
									<li><a href="Galerie.do" title="Gallery"><spring:message  code='Menu.Galerie' /></a></li>
		                            <li><a href="candidature.do" title="Candidature"><spring:message  code='Menu.Candidature' /></a></li>
		                            <li><a href="Offres.do" title="Win_Win News"><spring:message  code='Menu.Offres' /></a></li>
									<li><a href="Contact.do" title="Contact"><spring:message  code='Menu.Contact' /></a></li>
								</ul>
							</nav>
					</div>
					
					<div class="page-header__lang-switch lang-switch cc-dropdown" style="margin-top: 20px;">
							
							<a href="#" class="cc-dropdown__button lang-switch__button">
			                    <i class="lang-switch__globe"></i>
			                    <span class="lang-switch__current"><spring:message code='Menu.langue' /></span>
			                    <i class="icon-caret-small--blue"></i>
			                </a>
	                	
		                    <ul class="dropdown__menu-Inter">
		                        <li>
		                        	<img alt="" src="site/Commun/Images/Flag_of_France.png" class="taille" />
		                        	<a href="?lang=fr" class="cc-dropdown__menu-link">Francais</a>
		                        </li>
		                        <li>
		                        	<img alt="" src="site/Commun/Images/Flag_of_United_Kingdom.png" class="taille"  />
		                        	<a href="?lang=en" class="cc-dropdown__menu-link">English</a>
		                        </li>
		                    </ul>
	           	  </div> 
				</div>
	</header>
	 
	</div>
  	<script type="text/javascript" src="site/Commun/JS/MenuScrollFixe2.js"> </script>
</body>
</html>