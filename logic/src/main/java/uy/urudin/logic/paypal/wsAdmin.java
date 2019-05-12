package uy.urudin.logic.paypal;


import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;

import uy.urudin.datatypes.DTAdmin;
import uy.urudin.logic.interfaces.AdminFacadeLocal;

import java.util.Iterator;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@Stateless(mappedName = "wsLuckyNumbers")
@LocalBean
@WebService(serviceName="wsLuckyNumbers")
public class wsAdmin implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	@EJB
	AdminFacadeLocal ejbAdmin;
	
	public wsAdmin() {

	}
	
	@WebMethod(operationName="ListAdmin")
	public List<DTAdmin> ListAdmin() {
		return ejbAdmin.findAll();
	}
}
