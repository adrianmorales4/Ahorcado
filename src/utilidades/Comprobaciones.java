package utilidades;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class Comprobaciones {
	public static boolean comprobarLetraVeridica(String letra) {
		boolean correcto=false;
		 if (!(letra.equals(""))){
			 if(!Character.isDigit(letra.charAt(0)) && (Character.isLetterOrDigit(letra.charAt(0))) && letra.length()==1) {
				 correcto=true;
				}
		 }
		return correcto;
	}
	//Modificará las palabras para quitarle acentos 
	public static String conversorPalabras(String palabra) {
		palabra=palabra.replace("ñ", "&");
		palabra=StringUtils.stripAccents(palabra);
		palabra=palabra.replace("&", "ñ");
		return palabra;
	}
	//Comprobará que la letra se encuentra en la palabra Seleccionada, indicando en que posicion de la misma se encuentra
	public static ArrayList<String> comprobarLetra(String letra,String palabra) {
		boolean encontrada=false;
		//Pasamos todo a minuscula por si el Usuario ha introducido alguna Mayuscula
		letra=letra.toUpperCase();
		//Este Array guardará las posiciones donde se encuentra la letra introducida
		ArrayList<String> posicionLetra= new ArrayList<String> ();
		for(int i=0;i<palabra.length();i++){
			//Si se encuentra la letra, metemos la posicion en el ArrayList
			if(letra.equals(Character.toString(palabra.charAt(i)))) {
				posicionLetra.add(i,letra);
				encontrada=true;
			}
			else {
				if(conversorPalabras(letra).equals(Character.toString(palabra.charAt(i)))) {
					posicionLetra.add(i,conversorPalabras(letra));
					encontrada=true;
				}
				else {
					if(letra.equals(conversorPalabras(Character.toString(palabra.charAt(i))))) {
						posicionLetra.add(i,Character.toString(palabra.charAt(i)));
						encontrada=true;
					}
					else {
						posicionLetra.add(i,null);
					}
					
				}
			}
		}
		//Cambiamos el boolean para poder determinar en el Servlet si se ha encontrado o no la letra,metiendola en la ultima posicion
		if(encontrada) {
			posicionLetra.add(palabra.length(),"encontrada");
		}
		else {
			posicionLetra.add(palabra.length(),"noEncontrada");
		}
		return posicionLetra;
	}
	
	//Comprobará si hemos conseguido acertar la palabra
	public static boolean comprobarAciertos(String palabraSeleccionada,String [] letrasCorrectas) {
		boolean completo=true;
		//Vamos comparando cada posicion de los aciertos con cada letra de la Palabra Seleccionada
		for(int i=0;i<palabraSeleccionada.length();i++) {
			if(!(Character.toString(palabraSeleccionada.charAt(i)).equals(letrasCorrectas[i]))) {
				completo=false;
			}
		}
		
		return completo;
	}
	
	/*Este metodo simplemente recorrerá el ArrayList de las letras,tanto correctas
	como no, y las meterá en un String para ser mostradas al jugador*/
	public static String recorrerLetrasIntroducidas(ArrayList<String> letrasIntroducidas) {
		String letras="";
		for(int i=0;i<letrasIntroducidas.size();i++) {
			letras=letras+letrasIntroducidas.get(i);
		}
		return letras;
	}
	
	//Este metodo comprobará si la letra Introducida se encuentra ya en el ArrayList de Correctas o Incorrectas
	public static boolean comprobarLetrasIntroducidas(ArrayList<String> letrasIntroducidasC,ArrayList<String> letrasIntroducidasI,String letra) {
		boolean encontrado=false;
		letra=letra.toUpperCase();
		
		for(int i=0;i<letrasIntroducidasC.size();i++) {
			if(letrasIntroducidasC.get(i).equals(letra) || letrasIntroducidasC.get(i).equals(StringUtils.stripAccents(letra)) || StringUtils.stripAccents(letrasIntroducidasC.get(i)).equals(letra)) {
				encontrado=true;
			}
		}
		for(int i=0;i<letrasIntroducidasI.size();i++) {
			if(letrasIntroducidasI.get(i).equals(letra) || letrasIntroducidasI.get(i).equals(StringUtils.stripAccents(letra)) || StringUtils.stripAccents(letrasIntroducidasI.get(i)).equals(letra)) {
				encontrado=true;
			}
		}
		return encontrado;
		
	}
}