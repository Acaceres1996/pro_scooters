package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LuckyNumbersRemote {
	List<Integer> GetLuckyNumbers(String provider, String game);
	List<Integer> GetResultMatch(String provider);
}
