package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utilidades.Comprobaciones;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	//Estas son las palabras ocultas con las cuales vamos a ir jugando
	private String palabras[] = {"PERA","PLATANO","MANZANA","MARACUYA","KIWI","FRESA"};
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 	
        try {
        	//Si venimos de seleccionar "Volver a Jugar"
        	if (request.getParameter("empezar") != null) {  
        		HttpSession session = request.getSession(true);
        		
                // se registran variables de sesion
                
                String numFallos = "6";
                String palabraSeleccionada=palabras[(int) (Math.random() * 5)];
                /*Este Array es el que tiene que acertar el jugador. Al principio se mostrará vacio y con los aciertos,se irá mostrando
                los huecos de las letras acertadas,mientras que el resto seguiran vacias*/
                String letrasCorrectas[] = new String[palabraSeleccionada.length()];
                Arrays.fill(letrasCorrectas,"_");
                
                //Aqui Guardaremos las letras correctas, para mostrarlas siempre al jugador
                ArrayList<String> letrasIntroducidasCorrectamente= new ArrayList<String> ();
                //Aqui Guardaremos las letras incorrectas, para mostrarlas siempre al jugador
                ArrayList<String> letrasIntroducidasIncorrectamente= new ArrayList<String> ();
                String victoria="hidden";
                String derrota="hidden";
                String enPartida="";
                
                String letraRecibidaTexto="";
                String letraRecibidaConfirmacion="";
                session.setAttribute("numFallos", numFallos);
                session.setAttribute("palabraSeleccionada",palabraSeleccionada);
                session.setAttribute("letrasCorrectas",letrasCorrectas);
                session.setAttribute("letrasIntroducidasCorrectamente",letrasIntroducidasCorrectamente);
                session.setAttribute("letrasIntroducidasIncorrectamente",letrasIntroducidasIncorrectamente);
                session.setAttribute("victoria",victoria);
	        	session.setAttribute("derrota",derrota);
	        	session.setAttribute("enPartida",enPartida);
	        	session.setAttribute("letraRecibidaTexto",letraRecibidaTexto);
	        	session.setAttribute("letraRecibidaConfirmacion",letraRecibidaConfirmacion);
              
	        	
                request.setAttribute("numFallos",session.getAttribute("numFallos"));
		    	request.setAttribute("palabraSeleccionada",session.getAttribute("palabraSeleccionada"));
		    	request.setAttribute("letrasCorrectas",session.getAttribute("letrasCorrectas"));
		    	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasCorrectamente));
                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasIncorrectamente));
		    	request.setAttribute("victoria",session.getAttribute("victoria"));
	            request.setAttribute("derrota",session.getAttribute("derrota"));
	        	request.setAttribute("enPartida",session.getAttribute("enPartida"));
	        	request.setAttribute("letraRecibidaTexto",session.getAttribute("letraRecibidaTexto"));
	        	request.setAttribute("letraRecibidaConfirmacion",session.getAttribute("letraRecibidaConfirmacion"));
	        	
	        	response.setContentType("text/html;charset=UTF-8");
				String vista = "/Ahorcado.jsp";
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		        dispatcher.forward(request, response); 
        	}
        	else {
	            // Si ya existe la Sesion...
	            if (request.getSession(false) != null) {  // si existe una sesion
	            	HttpSession session = request.getSession(true);
			    	request.setAttribute("numFallos",session.getAttribute("numFallos"));
			    	request.setAttribute("palabraSeleccionada",session.getAttribute("palabraSeleccionada"));
			    	request.setAttribute("letrasCorrectas",session.getAttribute("letrasCorrectas"));
			    	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas((ArrayList<String>) session.getAttribute("letrasIntroducidasCorrectamente")));
	                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas((ArrayList<String>) session.getAttribute("letrasIntroducidasCorrectamente")));
			    	request.setAttribute("victoria",session.getAttribute("victoria"));
		            request.setAttribute("derrota",session.getAttribute("derrota"));
		        	request.setAttribute("enPartida",session.getAttribute("enPartida")); 	
		        	request.setAttribute("letraRecibidaTexto",session.getAttribute("letraRecibidaTexto"));
		        	request.setAttribute("letraRecibidaConfirmacion",session.getAttribute("letraRecibidaConfirmacion"));
	            	
	            }
	            //Sino, creamos la sesion
	            else {
	            	// Creamos la sesion
	                HttpSession session = request.getSession(true);
	
	                // se registran variables de sesion
	                
	                String numFallos = "6";
	                String palabraSeleccionada=palabras[(int) (Math.random() * 5)];
	                String letrasCorrectas[] = new String[palabraSeleccionada.length()];
	                Arrays.fill(letrasCorrectas,"_");
	                
	                //Aqui Guardaremos las letras correctas, para mostrarlas siempre al jugador
	                ArrayList<String> letrasIntroducidasCorrectamente= new ArrayList<String> ();
	                //Aqui Guardaremos las letras incorrectas, para mostrarlas siempre al jugador
	                ArrayList<String> letrasIntroducidasIncorrectamente= new ArrayList<String> ();
	                
	                String victoria="hidden";
	                String derrota="hidden";
	                String enPartida="";
	                
	                String letraRecibidaTexto="";
	                String letraRecibidaConfirmacion="";
	                
	                session.setAttribute("numFallos", numFallos);
	                session.setAttribute("palabraSeleccionada",palabraSeleccionada);
	                session.setAttribute("letrasCorrectas",letrasCorrectas);
	                session.setAttribute("letrasIntroducidasCorrectamente",letrasIntroducidasCorrectamente);
	                session.setAttribute("letrasIntroducidasIncorrectamente",letrasIntroducidasIncorrectamente);
	                session.setAttribute("victoria",victoria);
		        	session.setAttribute("derrota",derrota);
		        	session.setAttribute("enPartida",enPartida);
		        	session.setAttribute("letraRecibidaTexto",letraRecibidaTexto);
		        	session.setAttribute("letraRecibidaConfirmacion",letraRecibidaConfirmacion);


	                request.setAttribute("numFallos",session.getAttribute("numFallos"));
			    	request.setAttribute("palabraSeleccionada",session.getAttribute("palabraSeleccionada"));
			    	request.setAttribute("letrasCorrectas",session.getAttribute("letrasCorrectas"));    
			    	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasCorrectamente));
	                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasIncorrectamente));
		            request.setAttribute("victoria",victoria);
		            request.setAttribute("derrota",derrota);
		        	request.setAttribute("enPartida",enPartida);
		        	request.setAttribute("letraRecibidaTexto",letraRecibidaTexto);
		        	request.setAttribute("letraRecibidaConfirmacion",letraRecibidaConfirmacion);
	            }
	            response.setContentType("text/html;charset=UTF-8");
				String vista = "/Ahorcado.jsp";
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		        dispatcher.forward(request, response); 
        	}
        }           
        catch (Exception e){ 
        	System.out.println(e);
        }
    }

    @SuppressWarnings({ "unchecked", "unused" })
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    		//Si hemos perdido o ganado y le damos a Volver a Jugar,nos vamos al Get
    		if (request.getParameter("empezar") != null) {  
    			doGet(request, response);
    		}
    		//Sino, significa que seguimos en partida...
    		else {
	            HttpSession session= request.getSession(true);
	            //LETRA A BUSCAR,INTRODUCIDA POR TECLADO POR EL JUGADOR
	            String buscarLetra=new String(request.getParameter("buscarLetra"));
	            
	            //VARIABLES GUARDADAS EN LA SESION ANTERIORMENTE
	            String numFallos = (String) session.getAttribute("numFallos");
	            String palabraSeleccionada=(String) session.getAttribute("palabraSeleccionada");
	            String letrasCorrectas[] = (String[]) session.getAttribute("letrasCorrectas");
	            
	            //ESTADOS DE LA PARTIDA
	            String victoria=(String)session.getAttribute("victoria");
	            String derrota=(String)session.getAttribute("derrota");
	            String enPartida=(String)session.getAttribute("enPartida");
	            
	            
	            //VARIABLES DE INFORMACION PARA EL USUARIO
	            //Estas variables mostraran el mensaje "Has escrito la letra :x" e indicara si se encuentra o no en la Palabra
	            String letraRecibidaTexto=(String)request.getAttribute("letraRecibidaTexto");
	            String letraRecibidaConfirmacion=(String)request.getAttribute("letraRecibidaConfirmacion");
	            //Aqui Guardaremos las letras correctas, para mostrarlas siempre al jugador
                ArrayList<String> letrasIntroducidasCorrectamente=(ArrayList<String>) session.getAttribute("letrasIntroducidasCorrectamente");
                //Aqui Guardaremos las letras incorrectas, para mostrarlas siempre al jugador
                ArrayList<String> letrasIntroducidasIncorrectamente=(ArrayList<String>) session.getAttribute("letrasIntroducidasIncorrectamente");
	            
                
                
	            //Array que guardará las posiciones donde se encuentra la letra a Buscar           
	            ArrayList<String> posicionLetra= Comprobaciones.comprobarLetra(buscarLetra,palabraSeleccionada);
	             
	            //Comprobamos que lo introducido por el usuario es una letra o no la ha introducido anteriormente
	            if(Comprobaciones.comprobarLetraVeridica(buscarLetra)==true 
	            && !Comprobaciones.comprobarLetrasIntroducidas(letrasIntroducidasCorrectamente,letrasIntroducidasIncorrectamente, buscarLetra)) {
		            //Si la Letra se encuenta en la palabra...
		            if(posicionLetra.get(palabraSeleccionada.length()).equals("encontrada")) {
		            	/* Recorremos el ArrayList e introducimos en cada posicion del Array de Letras
		            	la letra seleccionada para comprobar */
		            	for(int i=0;i<letrasCorrectas.length;i++) {
		            		if(posicionLetra.get(i)!=null) {
		            			letrasCorrectas[i]=posicionLetra.get(i);
		            		}
		            	}
		            	//Metemos la letra a la bateria de letras correctas
		            	letrasIntroducidasCorrectamente.add(buscarLetra.toUpperCase());
		            	session.setAttribute("letrasIntroducidasCorrectamente", letrasIntroducidasCorrectamente);
		            	session.setAttribute("numFallos", numFallos);
		            	session.setAttribute("palabraSeleccionada",palabraSeleccionada);
		            	session.setAttribute("letrasCorrectas",letrasCorrectas);
		            	session.setAttribute("letraRecibidaTexto", "La letra recibida es: " + buscarLetra);
		            	session.setAttribute("letraRecibidaConfirmacion","La letra " + buscarLetra + " SÍ pertenece a la palabra oculta");
		                
		                request.setAttribute("numFallos", numFallos);
		                request.setAttribute("palabraSeleccionada",palabraSeleccionada);
		            	request.setAttribute("letrasCorrectas", letrasCorrectas);
		            	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasCorrectamente));
		                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasIncorrectamente));
		            	request.setAttribute("letraRecibidaTexto", "La letra recibida es: " + buscarLetra);
		            	request.setAttribute("letraRecibidaConfirmacion","La letra " + buscarLetra + " SÍ pertenece a la palabra oculta");
		            }
		            //Si es incorrecto,reducimos el numero de Fallos
		            else {
		            	numFallos=Integer.toString(Integer.parseInt(numFallos)-1);
		            	//Metemos la letra a la bateria de letras erroneas
		            	letrasIntroducidasIncorrectamente.add(buscarLetra);
		            	session.setAttribute("letrasIntroducidasCorrectamente", letrasIntroducidasCorrectamente);
		            	session.setAttribute("numFallos", numFallos);
		            	session.setAttribute("palabraSeleccionada",palabraSeleccionada);
		            	session.setAttribute("letrasCorrectas",letrasCorrectas);
		            	session.setAttribute("letraRecibidaTexto", "La letra recibida es: " + buscarLetra);
		            	session.setAttribute("letraRecibidaConfirmacion","La letra '" + buscarLetra + "' NO está en la palabra oculta");
		                
		                request.setAttribute("numFallos", numFallos);
		                request.setAttribute("palabraSeleccionada",palabraSeleccionada);
		            	request.setAttribute("letrasCorrectas", letrasCorrectas);
		            	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasCorrectamente));
		                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasIncorrectamente));
		            	request.setAttribute("letraRecibidaTexto", "La letra recibida es: " + buscarLetra);
		            	request.setAttribute("letraRecibidaConfirmacion","La letra '" + buscarLetra + "' NO está en la palabra oculta");
		            	
		            }
		            
		            //Si ya no hay fallos posibles
		            if(Integer.parseInt(numFallos)==0) {
		            	derrota="";
		            	enPartida="hidden";       	
		            }
		            else {
		            	//Si se ha ganado...
		            	if((Comprobaciones.comprobarAciertos(palabraSeleccionada,letrasCorrectas))==true) {
		            		victoria="";
			            	enPartida="hidden";
		            	}
		            }
		            
		            session.setAttribute("victoria",victoria);
		        	session.setAttribute("derrota",derrota);
		        	session.setAttribute("enPartida",enPartida);
		            
		            request.setAttribute("victoria",victoria);
		            request.setAttribute("derrota",derrota);
		        	request.setAttribute("enPartida",enPartida);
		            
		            response.setContentType("text/html;charset=UTF-8");
					String vista = "/Ahorcado.jsp";
			    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			        dispatcher.forward(request, response); 
	    		}
	            
	            
	            //Sino,mostramos un texto que indique al Usuario que debe introducir una letra o que introduzca una letra distinta
	            //Y volvemos a mostrar el juego tal cual estaba
	            else {
	            	session.setAttribute("numFallos", numFallos);
	                session.setAttribute("palabraSeleccionada",palabraSeleccionada);
	                session.setAttribute("letrasCorrectas",letrasCorrectas);
	                request.setAttribute("letrasIntroducidasCorrectamente",letrasIntroducidasCorrectamente);
	                request.setAttribute("letrasIntroducidasIncorrectamente",letrasIntroducidasIncorrectamente);
	                session.setAttribute("victoria",victoria);
		        	session.setAttribute("derrota",derrota);
		        	session.setAttribute("enPartida",enPartida);
		        	session.setAttribute("letraRecibidaTexto", "Introduce otra letra válida");
	            	session.setAttribute("letraRecibidaConfirmacion","");
	                
	                request.setAttribute("numFallos",session.getAttribute("numFallos"));
			    	request.setAttribute("palabraSeleccionada",session.getAttribute("palabraSeleccionada"));
			    	request.setAttribute("letrasCorrectas",session.getAttribute("letrasCorrectas"));      
			    	request.setAttribute("letrasIntroducidasCorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasCorrectamente));
	                request.setAttribute("letrasIntroducidasIncorrectamente",Comprobaciones.recorrerLetrasIntroducidas(letrasIntroducidasIncorrectamente));
		            request.setAttribute("victoria",victoria);
		            request.setAttribute("derrota",derrota);
		        	request.setAttribute("enPartida",enPartida);
		        	request.setAttribute("letraRecibidaTexto", "Introduce otra letra válida");
	            	request.setAttribute("letraRecibidaConfirmacion","");
	            	
	            	response.setContentType("text/html;charset=UTF-8");
					String vista = "/Ahorcado.jsp";
			    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			        dispatcher.forward(request, response); 
	            }
	            
    		}
        
    }
}