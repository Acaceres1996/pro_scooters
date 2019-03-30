package uy.pencas.core.web.beans.prize;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypePrize;
import uy.pencas.core.logic.interfaces.PrizeFacadeRemote;

@RequestScoped
@ManagedBean(name = "prizeBean", eager = true)
public class PrizeBean {

	@EJB
	PrizeFacadeRemote prizeEJB;
		
	public PrizeBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<DTPrize> getPrizes(){
		return prizeEJB.findEnabled();
	}
	
	public String disablePrize(DTPrize p){
		p.setEnabled(false);
		prizeEJB.update(p);
		return "prize_manage.xhtml?faces-redirect=true";
	}
	
	public String goToModify(DTPrize p) {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().put("dtprize_mod", p );
		return ("prize_modify.xhtml?faces-redirect=true");
	}
	
	public TypePrize[] getTypes(){
		return TypePrize.values();
	}

}
