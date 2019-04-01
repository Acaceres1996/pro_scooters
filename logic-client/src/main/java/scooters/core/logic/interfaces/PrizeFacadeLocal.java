package scooters.core.logic.interfaces;

import java.util.List;

import javax.ejb.Remote;

import uy.pencas.core.datatypes.datatypes.DTPrize;

@Remote
public interface PrizeFacadeLocal {
	void add(DTPrize dtPrize);
	void update(DTPrize dtPrize);
	void delete(DTPrize dtPrize);
	DTPrize find(Integer id);
	List<DTPrize> findAll();
	List<DTPrize> findEnabled();
}
