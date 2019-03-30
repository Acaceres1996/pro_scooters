package uy.pencas.core.persistance.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTPrize;



@Local
public interface PrizeDAOLocal {
	void add(DTPrize dtPrize);
	void merge(DTPrize dtPrize);
	void delete(DTPrize dtPrize);
	DTPrize find(Integer id);
	List<DTPrize> findAll();

}
