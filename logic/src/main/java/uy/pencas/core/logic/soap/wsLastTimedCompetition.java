package uy.pencas.core.logic.soap;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.enumerated.TypeStated;
import uy.pencas.core.logic.interfaces.CompetitionFacadeLocal;
import uy.pencas.core.logic.interfaces.ParameterFacadeLocal;

@Stateless(mappedName = "wsLastTimedCompetition")
@LocalBean
@WebService(serviceName="wsLastTimedCompetition")
public class wsLastTimedCompetition implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	

	@EJB
	CompetitionFacadeLocal compEJB;
	
	@EJB
	ParameterFacadeLocal ejbPar;
	
    public wsLastTimedCompetition() {
    }
    
	@WebMethod(operationName="ping")
	public boolean ping() {
		return true;
	}
	
	@WebMethod(operationName="getLastTimedByCompetition")
	public String getLastTimedByCompetition(@WebParam(name="user") String user,@WebParam(name="password") String password
			,@WebParam(name="idCompetition") String idCompetition) {
		String userP = ejbPar.getValueByName("USERBACKCORE");
		String passP = ejbPar.getValueByName("PASSBACKCORE");
		
		String ret = "";
		if(userP.equals(user) && passP.equals(password)) {
			DTCompetition dtCompetition = compEJB.find(Integer.valueOf(idCompetition));
			List<DTMatch> Matches = dtCompetition.getMatches();
			int LastMatchTimed = 0;
			for(DTMatch oneMatch : Matches) {
				
				if(oneMatch.getStated().equals(TypeStated.FINISHED) && oneMatch.getId() > LastMatchTimed) {
					LastMatchTimed = oneMatch.getId();
				}
				
			}
			ret = String.valueOf(LastMatchTimed);
		}
		return ret;
	}
	


}
