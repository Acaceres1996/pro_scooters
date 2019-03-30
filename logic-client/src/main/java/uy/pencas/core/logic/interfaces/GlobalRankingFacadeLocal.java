package uy.pencas.core.logic.interfaces;

import java.util.List;

import javax.ejb.Local;

import uy.pencas.core.datatypes.datatypes.DTGlobalRanking;

@Local
public interface GlobalRankingFacadeLocal {
	void add(DTGlobalRanking dtGlobalRanking);
	void update(DTGlobalRanking dtGlobalRanking);
	void delete(DTGlobalRanking dtGlobalRanking);
	DTGlobalRanking find(Integer id);
	List<DTGlobalRanking> findAll();
	DTGlobalRanking getDTRankingByCompetitorPenca(Integer idcompetitor,Integer idpenca,Integer IdOrganizacion);
}
