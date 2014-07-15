package com.example.bushwickopenstudios2013;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Studio {
	private int id;
	private float lon;
	private boolean active;
	private int last_modified;
	private String map_identifier;
	private float lat;
	private String address;
	private String name;
	private String state;
	private String city;
	private String country;
	private String zip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getLastModified() {
		return last_modified;
	}
	public void setLastModified(int last_modified) {
		this.last_modified = last_modified;
	}
}
