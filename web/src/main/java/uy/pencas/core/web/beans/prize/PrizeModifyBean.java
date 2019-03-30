package uy.pencas.core.web.beans.prize;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypePrize;
import uy.pencas.core.logic.interfaces.PrizeFacadeRemote;

@ManagedBean(name = "prize_modify", eager = true)
public class PrizeModifyBean {

	@EJB
	PrizeFacadeRemote prizeEJB;
	
	DTPrize p = new DTPrize();
	
	public PrizeModifyBean() {
		this.load();
	}
	
	public String modifyPrize() {
		prizeEJB.update(p);				
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		external.getSessionMap().remove("dtprize_mod");
		return "prize_manage.xhtml?faces-redirect=true";
	}	
	
	public DTPrize getP() {
		return p;
	}

	public void setP(DTPrize p) {
		this.p = p;
	}

	public TypePrize[] getTypes(){
		return TypePrize.values();
	}
	
	public void load() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		if(  external.getSessionMap().containsKey("dtprize_mod") ) {
			System.out.println("Entre");
			p = (DTPrize) external.getSessionMap().get("dtprize_mod");
			System.out.println(p.getId());
		}else {
			System.out.println("Algo fallo, no lo logré cargar");
		}
	}
}
