package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;
import java.util.List;

import uy.pencas.core.datatypes.enumerated.TypeSport;


public class DTCompetition implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private String name;
	private TypeSport typeSport;
	private List<DTMatch> matches;
	
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

	public List<DTMatch> getMatches() {
		return matches;
	}
	public void setMatches(List<DTMatch> matches) {
		this.matches = matches;
	}
	public DTCompetition() {
		super();
	}

	public DTCompetition(Integer id, String name, TypeSport typeSport, List<DTMatch> matches) {
		super();
		this.id = id;
		this.name = name;
		this.typeSport = typeSport;
		this.matches = matches;
	}

	
}
