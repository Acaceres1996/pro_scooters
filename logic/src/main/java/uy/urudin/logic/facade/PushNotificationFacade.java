package uy.urudin.logic.facade;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.logic.interfaces.AdminFacadeLocal;
import uy.urudin.logic.interfaces.PushNotificationFacadeLocal;
import uy.urudin.persistance.interfaces.AdminDAOLocal;
import uy.urudin.persistance.interfaces.ParametroDAOLocal;




/**
 * Session Bean implementation class ScooterFacade
 */
@Stateless
@LocalBean
public class PushNotificationFacade implements  PushNotificationFacadeLocal {


	@EJB
	ParametroDAOLocal ParametroDAO;
	
    /**
     * Default constructor. 
     */
    public PushNotificationFacade() {
        
    }


	@Override
	public boolean sendPushNotification(String cabezal, String cuerpo) {
		boolean ret = false;
		
		String appid = ParametroDAO.getValueByName("ONESIGNALAPPID");
		//ONESIGNALAPPID
		String apikey = ParametroDAO.getValueByName("ONESIGNALRESTAPIKEY");
		//ONESIGNALRESTAPIKEY
		
		try {
			   String jsonResponse;
			   
			   URL url = new URL("https://onesignal.com/api/v1/notifications");
			   HttpURLConnection con = (HttpURLConnection)url.openConnection();
			   con.setUseCaches(false);
			   con.setDoOutput(true);
			   con.setDoInput(true);

			   con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			   con.setRequestProperty("Authorization", "Basic "
			   		+ apikey);
			   con.setRequestMethod("POST");

			   String strJsonBody = "{"
			                      +   "\"app_id\": \""
			                      + appid
			                      + "\","
			                      +   "\"included_segments\": [\"All\"],"
			                      +   "\"data\": {\"redirect\": \"notificacion\", \"cabezal\":\""
			                      + cabezal.toString()
			                      + "\", \"cuerpo\":\""
			                      + cuerpo.toString()
			                      + "\"},"
			                      +   "\"contents\": {\"en\": \""
			                      + cabezal.toString()
			                      + " - "
			                      + cuerpo.toString()
			                      + "\"}"
			                      + "}";
			         
			   
			   System.out.println("strJsonBody:\n" + strJsonBody);

			   byte[] sendBytes = strJsonBody.getBytes("UTF-8");
			   con.setFixedLengthStreamingMode(sendBytes.length);

			   OutputStream outputStream = con.getOutputStream();
			   outputStream.write(sendBytes);

			   int httpResponse = con.getResponseCode();
			   System.out.println("httpResponse: " + httpResponse);

			   if (  httpResponse >= HttpURLConnection.HTTP_OK
			      && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
			      Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
			      jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
			      scanner.close();
			   }
			   else {
			      Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
			      jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
			      scanner.close();
			   }
			   System.out.println("jsonResponse:\n" + jsonResponse);
			   ret = true;
			   
			} catch(Throwable t) {
			   t.printStackTrace();
			}
		
		return ret;
	}



}
