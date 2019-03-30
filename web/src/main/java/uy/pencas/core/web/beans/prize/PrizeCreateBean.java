package uy.pencas.core.web.beans.prize;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypePrize;
import uy.pencas.core.logic.interfaces.PrizeFacadeRemote;

@RequestScoped
@ManagedBean(name = "prize_create", eager = true)
public class PrizeCreateBean {

	@EJB
	PrizeFacadeRemote prizeEJB;
	
	DTPrize p = new DTPrize();
	
	public PrizeCreateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String createPrize() {
		p.setEnabled(true);
		prizeEJB.add(p);
		return "prize_manage.xhtml?faces-redirect=true";
	}
	public TypePrize[] getTypes(){
		return TypePrize.values();
	}

	public DTPrize getP() {
		return p;
	}

	public void setP(DTPrize p) {
		this.p = p;
	}
	
	
	
}
