package uy.pencas.core.datatypes.datatypes;

import java.io.Serializable;

import uy.pencas.core.datatypes.enumerated.Type;
import uy.pencas.core.datatypes.enumerated.TypeService;


public class DTService implements Serializable  {

	private static final long serialVersionUID = 6128016096756071380L;
	
	private Integer id;
	private Boolean enabled;
	private String host;
	private String name;
	private String path;
	private String port;
	private String query;
	private Type type;
	private TypeService typeService;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public TypeService getTypeService() {
		return typeService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public DTService(Integer id, Boolean enabled, String host, String name, String path, String port, String query,
			Type type, TypeService typeService) {
		super();
		this.id = id;
		this.enabled = enabled;
		this.host = host;
		this.name = name;
		this.path = path;
		this.port = port;
		this.query = query;
		this.type = type;
		this.typeService = typeService;
	}
	

	public DTService() {
		super();
	}
	
	
}
