package uy.pencas.core.persistance.model;

import java.io.Serializable;
import javax.persistence.*;

import uy.pencas.core.datatypes.datatypes.DTService;
import uy.pencas.core.datatypes.enumerated.Type;
import uy.pencas.core.datatypes.enumerated.TypeService;


/**
 * The persistent class for the service database table.
 * 
 */
@Entity
@NamedQuery(name="Service.findAll", query="SELECT s FROM Service s")
public class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "enabled", columnDefinition = "boolean default true", nullable = false)
	private Boolean enabled;

	private String host;

	private String name;

	private String path;

	private String port;

	private String query;

	@Enumerated(EnumType.STRING)
	private Type type;

	@Column(name="type_service")
	@Enumerated(EnumType.STRING)
	private TypeService typeService;

	public Service() {
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

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TypeService getTypeService() {
		return this.typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public Service(DTService dtService) {
		this.id = dtService.getId();
		this.enabled = dtService.getEnabled();
		this.host = dtService.getHost();
		this.name = dtService.getName();
		this.path = dtService.getPath();
		this.port = dtService.getPort();
		this.query = dtService.getQuery();
		this.type = dtService.getType();
		this.typeService = dtService.getTypeService();
	}
	
	public DTService getDTService() {
		return new DTService(this.id,this.enabled,this.host,this.name,this.path,this.port,this.query,this.type,this.typeService);
	}
	
}