package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;
import uy.pencas.core.persistance.interfaces.PaymentRewardDAOLocal;
import uy.pencas.core.persistance.model.PaymentReward;


@Stateful
public class PaymentRewardDAO implements PaymentRewardDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;
	
    public PaymentRewardDAO() {
    }

	@Override
	public void add(DTPaymentReward dtPaymentReward) {
		//con id null
		PaymentReward team = new PaymentReward(dtPaymentReward);
		em.persist(team);
	}

	@Override
	public void merge(DTPaymentReward dtPaymentReward) {
		PaymentReward team = new PaymentReward(dtPaymentReward);
		em.merge(team);
	}

	@Override
	public void delete(DTPaymentReward dtPaymentReward) {
		PaymentReward team = new PaymentReward(dtPaymentReward);
		em.remove(em.merge(team));
	}
	
	@Override
	public DTPaymentReward find(Integer id) {
		PaymentReward team = em.find(PaymentReward.class, id);
		return team.getDTPaymentReward();
	}
	
	@Override
	public List<DTPaymentReward> findAll() {
		List<PaymentReward> Listteam = em.createQuery("SELECT t FROM PaymentReward t", PaymentReward.class).getResultList();
		List<DTPaymentReward> ListDT = new ArrayList<DTPaymentReward>();
		for(PaymentReward t : Listteam){
			ListDT.add(t.getDTPaymentReward());
		}
		return ListDT; 
	}

}
