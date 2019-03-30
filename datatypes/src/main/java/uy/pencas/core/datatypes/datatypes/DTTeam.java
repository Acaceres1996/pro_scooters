package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.List;

import uy.pencas.core.datatypes.enumerated.TypeSport;

public class DTTeam implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private String name;
	private TypeSport typeSport;
	private List<DTMatch> matchesLocal;
	private List<DTMatch> matchesVisitor;
	
	public List<DTMatch> getMatchesLocal() {
		return matchesLocal;
	}
	public void setMatchesLocal(List<DTMatch> matchesLocal) {
		this.matchesLocal = matchesLocal;
	}
	
	public List<DTMatch> getMatchesVisitor() {
		return matchesVisitor;
	}
	public void setMatchesVisitor(List<DTMatch> matchesVisitor) {
		this.matchesVisitor = matchesVisitor;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeSport getTypeSport() {
		return typeSport;
	}
	public void setTypeSport(TypeSport typeSport) {
		this.typeSport = typeSport;
	}
	public DTTeam(Integer id, String name, TypeSport typeSport, List<DTMatch> matchesLocal, List<DTMatch> matchesVisitor) {
		super();
		this.id = id;
		this.name = name;
		this.typeSport = typeSport;
		this.matchesLocal = matchesLocal;
		this.matchesVisitor = matchesVisitor;
	}

	public DTTeam() {
		super();
	}
	
	
}
