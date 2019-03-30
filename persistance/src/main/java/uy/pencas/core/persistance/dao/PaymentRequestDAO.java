package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTPaymentRequest;
import uy.pencas.core.persistance.interfaces.PaymentRequestDAOLocal;
import uy.pencas.core.persistance.model.PaymentRequest;


@Stateful
public class PaymentRequestDAO implements PaymentRequestDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public PaymentRequestDAO() {
    }

	@Override
	public void add(DTPaymentRequest dtPaymentRequest) {
		//con id null
		PaymentRequest team = new PaymentRequest(dtPaymentRequest);
		em.persist(team);
	}

	@Override
	public void merge(DTPaymentRequest dtPaymentRequest) {
		PaymentRequest team = new PaymentRequest(dtPaymentRequest);
		em.merge(team);
	}

	@Override
	public void delete(DTPaymentRequest dtPaymentRequest) {
		PaymentRequest team = new PaymentRequest(dtPaymentRequest);
		em.remove(em.merge(team));
	}
	
	@Override
	public DTPaymentRequest find(Integer id) {
		PaymentRequest team = em.find(PaymentRequest.class, id);
		return team.getDTPaymentRequest();
	}
	
	@Override
	public List<DTPaymentRequest> findAll() {
		List<PaymentRequest> Listteam = em.createQuery("SELECT t FROM PaymentRequest t", PaymentRequest.class).getResultList();
		List<DTPaymentRequest> ListDT = new ArrayList<DTPaymentRequest>();
		for(PaymentRequest t : Listteam){
			ListDT.add(t.getDTPaymentRequest());
		}
		return ListDT; 
	}

}
