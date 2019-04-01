package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTCompetition;
import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.enumerated.TypeSport;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the competition database table.
 * 
 */
@Entity
@NamedQuery(name="Competition.findAll", query="SELECT c FROM Competition c")
public class Competition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name="type_sport")
	@Enumerated(EnumType.STRING)
	private TypeSport typeSport;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="competition")
	private List<Match> matches;

	public Competition() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypeSport getTypeSport() {
		return this.typeSport;
	}

	public void setTypeSport(TypeSport typeSport) {
		this.typeSport = typeSport;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setCompetition(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setCompetition(null);

		return match;
	}

	public Competition(DTCompetition dtCompetition) {
		this.id = dtCompetition.getId();
		this.name = dtCompetition.getName();
		this.typeSport = dtCompetition.getTypeSport();
	}
	
	public DTCompetition getDTCompetition() {
		
		//de otros datatype solo Basic
		List<DTMatch> dtMatches = new ArrayList<DTMatch>();
		for(Match m : this.matches) {
			dtMatches.add(m.getDTMatchBasic());
		}
		return new DTCompetition(this.getId(),this.getName(),this.getTypeSport(), dtMatches);
	}
	
	public DTCompetition getDTCompetitionBasic() {
		return new DTCompetition(this.getId(),this.getName(),this.getTypeSport(), null);
	}
	
}