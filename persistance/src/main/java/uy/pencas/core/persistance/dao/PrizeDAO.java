package uy.pencas.core.persistance.dao;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.persistance.interfaces.PrizeDAOLocal;
import uy.pencas.core.persistance.model.Prize;



@Stateful
public class PrizeDAO implements PrizeDAOLocal {

	@PersistenceContext(unitName = "persistance", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

    public PrizeDAO() {
    }

	@Override
	public void add(DTPrize dtPrize) {
		Prize Prize = new Prize(dtPrize);
		em.persist(Prize);
	}

	@Override
	public void merge(DTPrize dtPrize) {
		Prize Prize = new Prize(dtPrize);
		em.merge(Prize);
	}

	@Override
	public void delete(DTPrize dtPrize) {
		Prize Prize = new Prize(dtPrize);
		em.remove(em.merge(Prize));
	}

	@Override
	public DTPrize find(Integer id) {
		Prize Prize = em.find(Prize.class, id);
		return Prize.getDTPrize(); 
	}

	@Override
	public List<DTPrize> findAll() {
		List<Prize> ListComp = em.createQuery("SELECT p FROM Prize p", Prize.class).getResultList();
		List<DTPrize> ListDT = new ArrayList<DTPrize>();
		for(Prize t : ListComp){
			ListDT.add(t.getDTPrize());
		}
		return ListDT;
	}

}
