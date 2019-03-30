package uy.pencas.core.persistance.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTOrganization;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.persistance.interfaces.OrganizationDAOLocal;
import uy.pencas.core.persistance.interfaces.TeamDAOLocal;
import uy.pencas.core.persistance.model.Organization;
import uy.pencas.core.persistance.model.Team;

@Stateful
public class OrganizationDAO  implements OrganizationDAOLocal  {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
	public OrganizationDAO() {
    }
	
	@Override
	public void add(DTOrganization dtOrganization) {
		//con id null
		Organization organization = new Organization(dtOrganization);
		em.persist(organization);
	}
	
	@Override
	public void merge(DTOrganization dtOrganization) {
		Organization organization = new Organization(dtOrganization);
		em.merge(organization);
	}
	
	@Override
	public void delete(DTOrganization dtOrganization) {
		Organization organization = new Organization(dtOrganization);
		em.remove(em.merge(organization));
	}
	
	@Override
	public DTOrganization find(Integer id) {
		Organization organization = em.find(Organization.class, id);
		return organization.getDTOrganization(); 
	}
	
	@Override
	public List<DTOrganization> findAll() {
		List<Organization> Listorganization = em.createQuery("SELECT o FROM Organization o", Organization.class).getResultList();
		List<DTOrganization> ListDT = new ArrayList<DTOrganization>();
		for(Organization o : Listorganization){
			ListDT.add(o.getDTOrganization());
		}
		return ListDT; 
	}
}
