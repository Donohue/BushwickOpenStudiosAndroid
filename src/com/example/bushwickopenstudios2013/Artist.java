package com.example.bushwickopenstudios2013;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Artist {
	private int id;
	private int last_modified;
	private String name;
	private boolean active;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLastModified() {
		return last_modified;
	}
	public void setLastModified(int last_modified) {
		this.last_modified = last_modified;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActive() {
		if (isActive())
			return 1;
		else
			return 0;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
