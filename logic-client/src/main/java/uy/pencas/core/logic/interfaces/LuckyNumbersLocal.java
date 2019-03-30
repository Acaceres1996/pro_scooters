package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LuckyNumbersLocal {
	List<Integer> GetLuckyNumbers(String provider, String game);
	List<Integer> GetResultMatch(String provider);
}
