package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTPrize;
import uy.pencas.core.datatypes.enumerated.TypePrize;


/**
 * The persistent class for the prize database table.
 * 
 */
@Entity
@NamedQuery(name="Prize.findAll", query="SELECT p FROM Prize p")
public class Prize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Boolean enabled;

	private String name;

	@Column(name="type_prize")
	@Enumerated(EnumType.STRING)
	private TypePrize typePrize;

	public Prize() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TypePrize getTypePrize() {
		return this.typePrize;
	}

	public void setTypePrize(TypePrize typePrize) {
		this.typePrize = typePrize;
	}

	public DTPrize getDTPrize() {
		return (new DTPrize (this.id,this.enabled,this.name,this.typePrize));
	}

	public Prize(DTPrize dtPrize) {
		this.id = dtPrize.getId();
		this.enabled = dtPrize.getEnabled();
		this.name = dtPrize.getName();
		this.typePrize = dtPrize.getTypePrize();
	}
}