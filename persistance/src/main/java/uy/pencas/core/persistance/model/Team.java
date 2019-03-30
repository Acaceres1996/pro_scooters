package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTMatch;
import uy.pencas.core.datatypes.datatypes.DTTeam;
import uy.pencas.core.datatypes.enumerated.TypeSport;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(name="type_sport")
	@Enumerated(EnumType.STRING)
	private TypeSport typeSport;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="teamLocal")
	private List<Match> matchesLocal;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="teamVisitor")
	private List<Match> matchesVisitor;

	public Team() {
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

	public List<Match> getMatchesLocal() {
		return this.matchesLocal;
	}

	public void setMatchesLocal(List<Match> matchesLocal) {
		this.matchesLocal = matchesLocal;
	}

	public Match addMatchesLocal(Match matches1) {
		getMatchesLocal().add(matches1);
		matches1.setTeamLocal(this);

		return matches1;
	}

	public Match removeMatchesLocal(Match matches1) {
		getMatchesLocal().remove(matches1);
		matches1.setTeamLocal(null);

		return matches1;
	}

	public List<Match> getMatchesVisitor() {
		return this.matchesVisitor;
	}

	public void setMatchesVisitor(List<Match> matchesVisitor) {
		this.matchesVisitor = matchesVisitor;
	}

	public Match addMatchesVisitor(Match matches2) {
		getMatchesVisitor().add(matches2);
		matches2.setTeamVisitor(this);

		return matches2;
	}

	public Match removeMatchesVisitor(Match matches2) {
		getMatchesVisitor().remove(matches2);
		matches2.setTeamVisitor(null);
		return matches2;
	}

	// TODO esto podria cambiar el null de list
	public Team(DTTeam dtTeam) {
		this.id = dtTeam.getId();
		this.name = dtTeam.getName();
		this.typeSport = dtTeam.getTypeSport();
	}
	
	public DTTeam getDTTeam() {
		List<DTMatch> dtMatchesLocal = new ArrayList<DTMatch>();
		for(Match m : this.matchesLocal) {
			dtMatchesLocal.add(m.getDTMatchBasic());
		}
		
		List<DTMatch> dtMatchesVisitor = new ArrayList<DTMatch>();
		for(Match m : this.matchesVisitor) {
			dtMatchesVisitor.add(m.getDTMatchBasic());
		}
		return new DTTeam(this.getId(),this.getName(),this.getTypeSport(),dtMatchesLocal,dtMatchesVisitor);
	}
	
	public DTTeam getDTTeamBasic() {
		return new DTTeam(this.getId(),this.getName(),this.getTypeSport(),null,null);
	}


	
}