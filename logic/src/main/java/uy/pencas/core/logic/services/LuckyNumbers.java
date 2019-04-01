package uy.pencas.core.logic.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import scooters.core.logic.interfaces.LuckyNumbersLocal;
import scooters.core.logic.interfaces.LuckyNumbersRemote;

/**
 * Session Bean implementation class LuckyNumbers
 */
@Stateless
@LocalBean
public class LuckyNumbers implements LuckyNumbersRemote, LuckyNumbersLocal , Serializable {

	private static final long serialVersionUID = 6128016096756071380L;

	public LuckyNumbers() {

	}
	
	
	public List<Integer> GetResultMatch( String provider) {
		List<Integer> result = new ArrayList<>();
		result = getValuesFromWS(provider, 2, 0, 5);
		return result;
	}
	
	public List<Integer> GetLuckyNumbers( String provider, String game) {
		List<Integer> result = new ArrayList<>();
		switch (game) {
		case "5 de oro":	
			result = getValuesFromWS(provider, 5, 1, 48);
			break;

		case "quiniela":
			result = getValuesFromWS(provider, 1, 0, 999);
			break;

		default:
			result = null;
			break;
		}		
		return result;
	}

	private List<Integer> getValuesFromWS(String provider, Integer max_numbers, Integer min_level, Integer max_level) {	
		List<Integer> result = new ArrayList<>();		
		switch (provider) {
		case "ANU":			
			result = getANURandom(max_numbers, min_level, max_level); 
			break;

		case "RANDOM":
			result = getRandomOrgRandom(max_numbers, min_level, max_level);
			break;
			
		default:
			result = null;
			break;
		}
				
		return result;
    }

	private List<Integer> getANURandom(Integer max_numbers, Integer min_level, Integer max_level) {
		List<Integer> result = new ArrayList<>();		
		String targetPath = "https://qrng.anu.edu.au/API/jsonI.php?length=1&type=uint8";
		boolean isValid = false;
		for (int i = 0; i < max_numbers; i++) {
			Integer number = 0;
			Integer aux = 0;
			do {
				//Hago el pedido a ANU
				Client client = ClientBuilder.newClient();
				WebTarget resource = client.target(targetPath);
				String a = resource.request().get(String.class);
				System.out.println("Termino una restcall");
				//Parseo el numero
				String Token = Pattern.quote("[");
				String[] aux_split = a.split(Token);
				Token = Pattern.quote("]");
				String[] aux_split_2 = aux_split[1].split(Token);
				number = Integer.parseInt( aux_split_2[0] );
				aux = number % 6; //numero en rango 0 a 5 siempre.
				isValid = (aux >= min_level) && (aux <= max_level );				
			}while(!isValid);
			result.add(aux);
			System.out.println("Numero:" + number.toString() );
			System.out.println("martin:" + aux);
		}	
		return result;
	}

	private List<Integer> getRandomOrgRandom(Integer max_numbers, Integer min_level, Integer max_level) {
		List<Integer> result = new ArrayList<>();		
		String targetPath = "https://www.random.org/integers/?num="+ max_numbers.toString().trim() +"&min="+min_level.toString().trim()+"&max="+max_level.toString().trim()+"&col=1&base=10&format=plain&rnd=new";
		Client client = ClientBuilder.newClient();
		WebTarget resource = client.target(targetPath);
		String a = resource.request().get(String.class);
		System.out.println("Request:" + a);
		String[] request_lines = a.split("\n");
		
		for (int i = 0; i < request_lines.length; i++) {
			result.add( Integer.parseInt( request_lines[i].trim() ) );			
		}
				
		return result;
	}

}
