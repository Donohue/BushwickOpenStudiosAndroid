package com.example.bushwickopenstudios2013;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import android.os.Parcel;
import android.os.Parcelable;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Event implements Parcelable {
	private int id;
	private String short_desc;
	private String section;
	private boolean active;
	private ArrayList<Integer> artists;
	private String room;
	private int last_modified;
	private String name;
	private String long_desc;
	private ArrayList<Hours> hours;
	private int venue;
	
	@Override
	public void writeToParcel(Parcel out, int arg1) {
		out.writeInt(id);
		out.writeString(short_desc);
		out.writeString(section);
		out.writeByte((byte)(active? 1:0));
		//out.writeArray(artists.toArray());
		out.writeString(room);
		out.writeInt(last_modified);
		out.writeString(name);
		out.writeString(long_desc);
		//out.writeArray(hours.toArray());
		out.writeInt(venue);
	}
	
	public Event() {
		super();
	}

	public Event(Parcel in) {
		id = in.readInt();
		short_desc = in.readString();
		section = in.readString();
		active = in.readByte() == 1;
		//in.readArray(Integer.class.getClassLoader());
		room = in.readString();
		last_modified = in.readInt();
		name = in.readString();
		long_desc = in.readString();
		//in.readArray(Hours.class.getClassLoader());
		venue = in.readInt();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShortDesc() {
		return short_desc;
	}
	public void setShort_desc(String short_desc) {
		this.short_desc = short_desc;
	}
	public void setShortDesc(String short_desc) {
		this.short_desc = short_desc;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public int getActive() {
		return isActive()? 1: 0;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public ArrayList<Integer> getArtists() {
		return artists;
	}
	public void setArtists(ArrayList<Integer> artists) {
		this.artists = artists;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public int getLastModified() {
		return last_modified;
	}
	public void setLast_modified(int last_modified) {
		this.last_modified = last_modified;
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
	public String getLongDesc() {
		return long_desc;
	}
	public void setLong_desc(String long_desc) {
		this.long_desc = long_desc;
	}
	public void setLongDesc(String long_desc) {
		this.long_desc = long_desc;
	}
	public ArrayList<Hours> getHours() {
		return hours;
	}
	public void setHours(ArrayList<Hours> hours) {
		this.hours = hours;
	}
	public int getVenue() {
		return venue;
	}
	public void setVenue(int venue) {
		this.venue = venue;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	public static final Creator<Event> CREATOR = new Creator<Event>() {
		public Event createFromParcel(Parcel source) {
			return new Event(source);
		}
		
		public Event[] newArray(int size) {
			return new Event[size];
		}
	};
}
