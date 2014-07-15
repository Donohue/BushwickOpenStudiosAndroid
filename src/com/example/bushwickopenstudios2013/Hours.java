package com.example.bushwickopenstudios2013;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Hours {
	private int opens;
	private int closes;
	private String notes;
	
	public int getOpens() {
		return opens;
	}
	public void setOpens(int opens) {
		this.opens = opens;
	}
	public int getCloses() {
		return closes;
	}
	public void setCloses(int closes) {
		this.closes = closes;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
