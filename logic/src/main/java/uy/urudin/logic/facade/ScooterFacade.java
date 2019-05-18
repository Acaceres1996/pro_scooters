package uy.urudin.logic.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.geojson.Crs;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import uy.urudin.datatypes.DTScooter;
import uy.urudin.datatypes.DTScooterUltimoRegistro;
import uy.urudin.datatypes.DTScooterhistorico;
import uy.urudin.logic.interfaces.ScooterFacadeLocal;
import uy.urudin.persistance.interfaces.ScooterDAOLocal;
import uy.urudin.persistance.interfaces.ScooterhistoricoDAOLocal;



/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class ScooterFacade implements  ScooterFacadeLocal {


	@EJB
	ScooterDAOLocal ScooterDAO;
	@EJB
	ScooterhistoricoDAOLocal ScooterhistoricoDAO;
	
    /**
     * Default constructor. 
     */
    public ScooterFacade() {
        
    }

	@Override
	public DTScooter add(DTScooter dtScooter) {
		try {
			DTScooter newdtscooter = ScooterDAO.add(dtScooter);
			
			//historico por default
			DTScooterhistorico newSH = new DTScooterhistorico();
			newSH.setBateria(100);
			newSH.setLatitud("-34.9181706");
			newSH.setLongitud("-56.1665725");
			newSH.setScooter(newdtscooter);
			DTScooterhistorico creadoSH =  ScooterhistoricoDAO.add(newSH);
			// sino existe almenos 1 falla el buscar disponibles.
			
			return newdtscooter;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public DTScooter update(DTScooter dtScooter) {
		return ScooterDAO.merge(dtScooter);
	}

	@Override
	public void delete(Integer Id) {
		ScooterDAO.delete(Id);
	}

	@Override
	public DTScooter find(Integer id) {
		return ScooterDAO.find(id);
	}

	@Override
	public List<DTScooter> findAll() {
		return ScooterDAO.findAll();
	}

	@Override
	public List<DTScooter> scootersLibres() {
		return ScooterDAO.scootersLibres();
	}

	@Override
	public List<DTScooterUltimoRegistro> scootersUltimosRegistros() {
		List<DTScooterUltimoRegistro> ret = new ArrayList<DTScooterUltimoRegistro>(); 
		
		//todos los scooters
		List<DTScooter> allscooters = ScooterDAO.findAll();
		
		for (DTScooter onedtScooter : allscooters) {
			//busco su dtscooterhistorico.
			DTScooterhistorico onehistorico = ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooterBasico(onedtScooter.getId());
			
			//armo el dt nuevo
			DTScooterUltimoRegistro dtnew = new DTScooterUltimoRegistro(onedtScooter,onehistorico);
			ret.add(dtnew);
			
		}
		
		return ret;
	}

	@Override
	public String scootersAlquilados() throws UnsupportedEncodingException, IOException {
		
		//json object string geojson
		JSONObject newfeatureCollection = new JSONObject();
		JSONArray newfeatures = new JSONArray();
		
		//TODO OBTENER TODOS LOS SCOOTERS EN USO EN ESTE MOMENTO.
		List<DTScooter> scootersEnUso = ScooterDAO.scootersEnUso();
		
		//construir con features geojson para cada 1 de los En uso.
		for (DTScooter onedtScooter : scootersEnUso) {
			DTScooterhistorico ultimoScooter=  ScooterhistoricoDAO.ultimoScooterHistoricoUnIdScooter(onedtScooter.getId());
			JSONObject newfeatureonedtScooter = addFeatureGEOJSON(String.valueOf(onedtScooter.getId()),onedtScooter.getNumeroserial(),Double.valueOf(ultimoScooter.getLongitud()),Double.valueOf(ultimoScooter.getLatitud()));
			newfeatures.add(newfeatureonedtScooter);
		}
		
		System.out.println("newfeatures:"+newfeatures.toString());
		
	    String urlService = "http://www.montevideo.gub.uy/buses/rest/stm-online";
//System.out.println("MARTINDEBUG-URL:"+urlService);
		URL url = new URL(urlService);
		
		//Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		//Set the request to GET or POST as per the requirements
		conn.setRequestMethod("POST");
//System.out.println("MARTINDEBUG-PASO1");
		//conn config post
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		
//System.out.println("MARTINDEBUG-PASO2");
		//data 
		String jsonInputString = "{ \"empresa\":\"50\", \"lineas\": [\"149\"] }"; //149
		
		
		OutputStream os = conn.getOutputStream();
        os.write(jsonInputString.getBytes("UTF-8"));
        os.close();
        
//System.out.println("MARTINDEBUG-os:"+os.toString());
		String respuesta = "vacio";
//System.out.println("MARTINDEBUG-PASO3");
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				    StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				    //string response
				    respuesta = response.toString();
				}
	//System.out.println("MARTINDEBUG-PASO4");
	System.out.println("MARTINDEBUG-respuesta:"+respuesta);


	
	//JSONParser reads the data from string object and break each data into key value pairs
	JSONParser parse = new JSONParser();
	//Type caste the parsed json data in json object
	JSONObject jobj = null;
	try {
		jobj = (JSONObject)parse.parse(respuesta);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	JSONArray features = (JSONArray) jobj.get("features");
	//System.out.println("MARTINDEBUG-PASO2:" + features.size());
	for(int i=0;i<features.size();i++)
	{
		JSONObject oneFeature = (JSONObject)features.get(i);
	//	String type = (String)oneFeature.get("type");
		JSONObject properties = (JSONObject) oneFeature.get("properties");	
		String linea = (String)properties.get("linea");
		Long codigobus = (Long)properties.get("codigoBus");
		JSONObject geometry = (JSONObject) oneFeature.get("geometry");	
		JSONArray coordenadas = (JSONArray) geometry.get("coordinates");	
		double longitud = (double) coordenadas.get(0);
		double latitud = (double) coordenadas.get(1);
	
		//creo los nuevos features geojson
		//cabezal
		JSONObject onenewfeature = addFeatureGEOJSON(linea,codigobus.toString(),longitud,latitud);
		newfeatures.add(onenewfeature);
	}

	//agrego todas la features
	newfeatureCollection.put("features", newfeatures);
	newfeatureCollection.put("type", "FeatureCollection");
//System.out.println("newfeatureCollection:"+newfeatureCollection.toString());

	return newfeatureCollection.toString();
	}

	
	private JSONObject addFeatureGEOJSON(String id,String id2,double longitud,double latitud) {
		//cabezal
		JSONObject onenewfeature = new JSONObject();
		//properties
		JSONObject newproperties = new JSONObject();
		newproperties.put("id", id);
		newproperties.put("numeroserial", id2);
		onenewfeature.put("properties", newproperties);
		//geometry
		JSONObject newgeometry = new JSONObject();
		JSONArray JSONArrayCoord = new JSONArray();
		JSONArrayCoord.add(0, longitud);
		JSONArrayCoord.add(1, latitud);
		newgeometry.put("type", "Point");
		newgeometry.put("coordinates", JSONArrayCoord);
		onenewfeature.put("geometry", newgeometry);
		//type
		onenewfeature.put("type", "Feature");
		return onenewfeature;		
	}

}
