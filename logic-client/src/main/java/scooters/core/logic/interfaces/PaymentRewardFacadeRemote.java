package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTPaymentReward;

@Remote
public interface PaymentRewardFacadeRemote {
	void add(DTPaymentReward dtPaymentReward);
	void update(DTPaymentReward dtPaymentReward);
	void delete(DTPaymentReward dtPaymentReward);
	DTPaymentReward find(Integer id);
	List<DTPaymentReward> findAll();
}
