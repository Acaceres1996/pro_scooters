package uy.pencas.core.logic.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTOrganization;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeRewardStatus;
import uy.pencas.core.datatypes.enumerated.TypeStatus;
import uy.pencas.core.logic.interfaces.OrganizationFacadeLocal;
import uy.pencas.core.logic.interfaces.OrganizationFacadeRemote;
import uy.pencas.core.persistance.interfaces.OrganizationDAOLocal;


@Stateless
@LocalBean
public class OrganizationFacade implements OrganizationFacadeRemote, OrganizationFacadeLocal {

	@EJB
	OrganizationDAOLocal organizationDAO;
	
    /**
     * Default constructor. 
     */
    public OrganizationFacade() {
        
    }

	@Override
	public void add(DTOrganization dtOrganization) {
		organizationDAO.add(dtOrganization);
	}
	
	@Override
	public void update(DTOrganization dtOrganization) {
		organizationDAO.merge(dtOrganization);
	}

	@Override
	public void delete(DTOrganization dtOrganization) {
		organizationDAO.delete(dtOrganization);
	}

	@Override
	public DTOrganization find(Integer id) {
		return organizationDAO.find(id);
	}

	@Override
	public List<DTOrganization> findAll() {
		return organizationDAO.findAll();
	}

	@Override
	public List<DTOrganization> getPendingOrgs() {
		List<DTOrganization> all = this.findAll();
		List<DTOrganization> pending = new ArrayList<DTOrganization>();
		for(DTOrganization org : all) {
			// TODO ESTO SE CAMBIO DE boolean a String
			if( org.getApproved().equals(TypeStatus.SEND)) {
				pending.add(org);
			}
		}
		return pending;
	}

	@Override
	public void approveOrg(Integer id) {
		DTOrganization org = this.find(id);
		org.setApproved(TypeStatus.ACCEPT);
		this.update(org);
	}
	
}
