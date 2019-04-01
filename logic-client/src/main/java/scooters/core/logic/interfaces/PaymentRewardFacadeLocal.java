package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;

@Local
public interface PaymentRewardFacadeLocal {
	void add(DTPaymentReward dtPaymentReward);
	void update(DTPaymentReward dtPaymentReward);
	void delete(DTPaymentReward dtPaymentReward);
	DTPaymentReward find(Integer id);
	List<DTPaymentReward> findAll();
}
