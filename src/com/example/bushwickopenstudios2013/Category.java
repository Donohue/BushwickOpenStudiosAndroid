package com.example.bushwickopenstudios2013;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Category {
	private int order;
	private String name;
	private String group;
	private int id;
	private boolean active;
	private int last_modified;
}
