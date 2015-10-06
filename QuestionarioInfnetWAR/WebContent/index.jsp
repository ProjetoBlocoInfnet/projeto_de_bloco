
<jsp:include page="openDoc.jsp" />

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<img src="resources/img/logoInfnet3.png">  
		
		<ul id="menu" class="nav navbar-nav navbar-right">	 
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Área <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Usuários</a></li>
	            <li><a href="#">Questões</a></li>
	            <li><a href="#">Avaliações</a></li>
	          </ul>
	        </li>
        	<li><a href="#" >Média Histórica</a></li>
      	</ul>
      					  
	</div>	
	
</nav>
  

<div id="containerSlider" class="container-fluid">
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel"> 

	  <!-- Wrapper for slides -->
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img class="img-responsive" src="resources/img/2.jpg">
	    </div>
	    <div class="item">
	      <img class="img-responsive" src="resources/img/3.jpg">
	    </div>
	    <div class="item">
	      <img class="img-responsive" src="resources/img/8.jpg">
	    </div>
	  </div> 
	</div>
</div>

<jsp:include page="footer.jsp" />