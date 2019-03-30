package uy.pencas.core.logic.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;
import uy.pencas.core.logic.interfaces.PaymentRewardFacadeLocal;
import uy.pencas.core.logic.interfaces.PaymentRewardFacadeRemote;

import uy.pencas.core.persistance.interfaces.PaymentRewardDAOLocal;

/**
 * Session Bean implementation class PaymentRewardFacade
 */
@Stateless
@LocalBean
public class PaymentRewardFacade implements PaymentRewardFacadeRemote, PaymentRewardFacadeLocal {

	@EJB
	PaymentRewardDAOLocal paymentRewardDAO;
	
    /**
     * Default constructor. 
     */
    public PaymentRewardFacade() {
        
    }

	@Override
	public void add(DTPaymentReward dtPaymentReward) {
		paymentRewardDAO.add(dtPaymentReward);
	}

	@Override
	public void update(DTPaymentReward dtPaymentReward) {
		paymentRewardDAO.merge(dtPaymentReward);
	}

	@Override
	public void delete(DTPaymentReward dtPaymentReward) {
		paymentRewardDAO.delete(dtPaymentReward);
	}

	@Override
	public DTPaymentReward find(Integer id) {
		return paymentRewardDAO.find(id);
	}

	@Override
	public List<DTPaymentReward> findAll() {
		return paymentRewardDAO.findAll();
	}
	

}
