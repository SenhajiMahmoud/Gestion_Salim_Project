<head>
<style type="text/css">
@import url('http://fonts.googleapis.com/css?family=Lato');

.container{
  display: block;
  position: absolute;
  margin: auto;
  height: 450px;
  width: 400px;
  bottom: 0; left:0; right: 0; top:0;
  padding: 0;
}

.container ul{
  list-style: none;
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  display: inline-block;
}

ul li{
  color: #AAAAAA;
  display: block;
  position: relative;
  float: left;
  width: 100%;
  height: 100px;
	border-bottom: 1px solid #111111;
}

ul li input[type=radio]{
  position: absolute;
  visibility: hidden;
}

ul li label{
  display: block;
  position: relative;
  font-weight: 300;
  font-size: 1.35em;
  padding: 25px 25px 25px 80px;
  margin: 10px auto;
  height: 30px;
  z-index: 9;
  cursor: pointer;
  -webkit-transition: all 0.25s linear;
}

ul li:hover label{
	color: #000;
}

ul li .check{
  display: block;
  position: absolute;
  border: 5px solid #AAAAAA;
  border-radius: 100%;
  height: 25px;
  width: 25px;
  top: 30px;
  left: 20px;
  z-index: 5;
  transition: border .25s linear;
  -webkit-transition: border .25s linear;
}

ul li:hover .check {
  border: 5px solid #FFFFFF;
}

ul li .check::before {
  display: block;
  position: absolute;
	content: '';
  border-radius: 100%;
  height: 15px;
  width: 15px;
  top: 5px;
	left: 5px;
  margin: auto;
	transition: background 0.25s linear;
	-webkit-transition: background 0.25s linear;
}

input[type=radio]:checked ~ .check {
  border: 5px solid #0DFF92;
}

input[type=radio]:checked ~ .check::before{
  background: #0DFF92;
}

input[type=radio]:checked ~ label{
  color: #0DFF92;
}
</style>
</head>
<html>
<body>
<div class="container">
	
  <ul>
	  <li>
	    <input type="radio" id="f-option" name="selector">
	    <label for="f-option">Oui</label>
	    
	    <div class="check"></div>
	  </li>
	  
	  <li>
	    <input type="radio" id="s-option" name="selector">
	    <label for="s-option">Non</label>
	    
	    <div class="check">
	    	<div class="inside"></div>
	    </div>
	  </li>
	</ul>
</div>

</body>
</html>