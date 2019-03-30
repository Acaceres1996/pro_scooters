package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;



@Local
public interface PaymentRewardDAOLocal {
	void add(DTPaymentReward dtPaymentReward);
	void merge(DTPaymentReward dtPaymentReward);
	void delete(DTPaymentReward dtPaymentReward);
	DTPaymentReward find(Integer id);
	List<DTPaymentReward> findAll();
	
}
