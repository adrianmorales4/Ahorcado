<%@ page language="java" contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<%
String victoria=(String)request.getAttribute("victoria");
String derrota=(String)request.getAttribute("derrota");
String enPartida=(String)request.getAttribute("enPartida");

String letraRecibidaTexto=(String)request.getAttribute("letraRecibidaTexto");
String letraRecibidaConfirmacion=(String)request.getAttribute("letraRecibidaConfirmacion");

String letrasIntroducidasCorrectamente=(String)request.getAttribute("letrasIntroducidasCorrectamente");
String letrasIntroducidasIncorrectamente = (String)request.getAttribute("letrasIntroducidasIncorrectamente");

String numFallos = (String)request.getAttribute("numFallos");
//Esta es la imagen de la horca
String horca = "images/" + numFallos + ".gif";
String palabraSeleccionada=(String)request.getAttribute("palabraSeleccionada");
String [] letrasCorrectas = (String[])request.getAttribute("letrasCorrectas");
String letras="";
for(int i=0;i<letrasCorrectas.length;i++){
	if(letrasCorrectas[i].equals("_")){
		letras=letras+"<div class='letraNoAcertada'><span>" + letrasCorrectas[i] + "</span></div>" + "\n";
	}
	else{
		letras=letras+"<div class='letraAcertada'><span>" + letrasCorrectas[i] + "</span></div>" + "\n";
	}
}
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html, charset=UTF-8">
    <meta name="author" content="Adrian Morales">
    <link href="./css/styles.css" rel="stylesheet">
    <link href="./bootstrap/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./bootstrap/bootstrap.css">
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/miJS.js"></script>
    <title>AHORCADO PRACTICA 3</title>    
</head>  
<body>
 <form action="Servlet" method="post">
    <nav class="navbar cabecera" role="navigation">
        <div class="container-fluid">
           <span class="titulo">Ahorcado</span> 
        </div>
    </nav>
    <div class="container victoriaDerrota" <%=victoria %> >
        <div class="row">
            <div class="col-md-12"> 
                <span class="titulovictoriaDerrota">!HAS GANADO!</span>
            </div>
            <div class="col-md-12">
	            <a href="Servlet?empezar">
	                <button type="button" class="btn btn-secondary">
	                    <span>VOLVER A JUGAR</span>
	                </button>
	            </a>
            </div>
        </div>
    </div>

    <div class="container victoriaDerrota" <%=derrota %>>
        <div class="row">
            <div class="col-md-12"> 
                <span class="titulovictoriaDerrota">!HAS PERDIDO!</span>
            </div>
            <div class="col-md-12">
	            <a href="Servlet?empezar">
	                <button type="button" class="btn btn-secondary">
	                    <span>VOLVER A JUGAR</span>
	                </button>
	            </a>
            </div>
        </div>
    </div>
    
    <div class="container contenedor" <%=enPartida %>>
        <div class="row">
            <div class="col-md-4 col-xs-12">
                <img src=<%=horca %>>
            </div>
            <div class="col-md-8 col-xs-12 infoUsuario">
                <div class="textoInfoUsuario">
                    <span><%=letraRecibidaTexto %></span>
			    	<br>
			    	<span><%=letraRecibidaConfirmacion %></span>
			    	<br>
			    	<span>Letras Introducidas <img src="./images/right.png"> <%=letrasIntroducidasCorrectamente %></span>
			    	<br>
			    	<span>Letras Introducidas <img src="./images/wrong.png"> <%=letrasIntroducidasIncorrectamente %></span>
			    	<br>
				    <span>Numero de Fallos Posibles: <%=numFallos%></span>
                 </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12 letras"> 
                <%=letras %>
            </div>  
        </div>
        <div class="row">
            <div class="col-md-12 buscarLetra"> 
                <span>LETRA</span>
                <input type="text" size="3" name="buscarLetra"/>
                <button type="submit" class="btn btn-primary">
                    <span>GO</span>
                </button>
            </div>
    	</div>
    </div>
 </form>   
</body>
</html>