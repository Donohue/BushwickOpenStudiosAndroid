package com.example.bushwickopenstudios2013;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
	private static String DATABASE_NAME = "bos2013";
	private static int DATABASE_VERSION = 1;
	private static String ARTIST_TABLE_NAME = "artists";
	private static String ARTIST_TABLE_CREATE =
			"CREATE TABLE " + ARTIST_TABLE_NAME + " (" +
					"id INTEGER PRIMARY KEY, last_modified INTEGER, name TEXT, active INTEGER);";
	private static String CATEGORY_TABLE_NAME = "categories";
	private static String CATEGORY_TABLE_CREATE =
			"CREATE TABLE " + CATEGORY_TABLE_NAME + "(" +
					"order INTEGER, name TEXT, group TEXT, id INTEGER PRIMARY KEY," +
					"active INTEGER, last_modified INTEGER);";
	private static String EVENT_TABLE_NAME = "events";
	private static String EVENT_TABLE_CREATE =
			"CREATE TABLE " + EVENT_TABLE_NAME + "(" +
					"id INTEGER PRIMARY KEY, short_desc TEXT, section TEXT, active INTEGER" +
					"room TEXT, last_modified INTEGER, name TEXT, long_desc TEXT, venue INTEGER);";
	private static String ARTIST_EVENT_TABLE_NAME = "artists_events";
	private static String ARTIST_EVENT_TABLE_CREATE =
			"CREATE TABLE " + ARTIST_EVENT_TABLE_NAME + "(" +
					"artist_id INTEGER, event_id INTEGER," +
					"FOREIGN KEY(artist_id) REFERENCES artists(id)," +
					"FOREIGN KEY(event_id) REFERENCES events(id));";
	private static String EVENT_HOURS_TABLE_NAME = "event_hours";
	private static String EVENT_HOURS_TABLE_CREATE =
			"CREATE TABLE " + EVENT_HOURS_TABLE_NAME + "(" +
					"opens INTEGER, closes INTEGER, notes TEXT, event_id INTEGER," +
					"FOREIGN KEY(event_id) REFERENCES events(id));";
	private static String SPONSOR_TABLE_NAME = "sponsors";
	private static String SPONSOR_TABLE_CREATE =
			"CREATE TABLE " + SPONSOR_TABLE_NAME + "(" +
					"name TEXT, website TEXT, id INTEGER PRIMARY KEY, short_desc TEXT," +
					"active INTEGER, sponsor_level String, last_modified INTEGER);";
	private static String STUDIO_TABLE_NAME = "studios";
	private static String STUDIO_TABLE_CREATE =
			"CREATE TABLE " + STUDIO_TABLE_NAME + "(" +
					"id INTEGER PRIMARY KEY, lon REAL, active INTEGER, last_modified INTEGER," +
					"map_identifier TEXT, lat REAL, address TEXT, name TEXT," +
					"state TEXT, city TEXT, country TEXT, zip TEXT);";
	private static String[] DATABASE_TABLE_CREATE =
			{ARTIST_TABLE_CREATE,
			 CATEGORY_TABLE_CREATE,
			 EVENT_TABLE_CREATE,
			 ARTIST_EVENT_TABLE_CREATE,
			 EVENT_HOURS_TABLE_CREATE,
			 SPONSOR_TABLE_CREATE,
			 STUDIO_TABLE_CREATE};
	
	public Database(Context c) {
		super(c, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		for (int i = 0; i < DATABASE_TABLE_CREATE.length; i++) {
			db.execSQL(DATABASE_TABLE_CREATE[i]);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public void addArtists(ArtistList artists) {
		SQLiteDatabase db = getReadableDatabase();
		for (int i = 0; i < artists.getResult().size(); i++) {
			Artist artist = artists.getResult().get(i);
			String values = artist.getId() + "," + artist.getLastModified() + "," + artist.getName() + "," + artist.getActive();
			String sql = "INSERT OR REPLACE INTO " + ARTIST_TABLE_NAME +
					" (id, last_modified, name, active) VALUES (" + values + ");";
			db.execSQL(sql);
		}
	}
	
	public void addEvents(EventList events) {
		SQLiteDatabase db = getReadableDatabase();
		for (int i = 0; i < events.getResult().size(); i++) {
			Event event = events.getResult().get(i);
			String values = event.getId() + "," + event.getShortDesc() + "," + event.getSection() + "," +
							event.getActive() + "," + event.getRoom() + "," + event.getLastModified() + "," +
							event.getName() + "," + event.getLongDesc() + "," + event.getVenue();
			String sql = "INSERT OR REPLACE INTO " + EVENT_TABLE_NAME +
					" (id, short_desc, section, active, room, last_modified, name, long_desc, venue) VALUES (" + values + ");";
			db.execSQL(sql);
			
			ArrayList<Integer> artists = event.getArtists();
			for (int j = 0; j < artists.size(); j++) {
				int artist_id = artists.get(j);
				String artist_event_sql = "INSERT OR REPLACE INTO " + ARTIST_EVENT_TABLE_NAME +
											"(artist_id, event_id) VALUES (" + artist_id + "," + event.getId() + ");";
				db.execSQL(artist_event_sql);
			}
			
			ArrayList<Hours> hours_list = event.getHours();
			for (int j = 0; j < hours_list.size(); j++) {
				Hours hours = hours_list.get(j);
				String hours_sql = "INSERT OR REPLACE INTO " + EVENT_HOURS_TABLE_NAME +
						" (opens, closes, notes, event_id) VALUES (" +
						hours.getOpens() + "," + hours.getCloses() + "," + hours.getNotes() + "," + event.getId() + ");";
				db.execSQL(hours_sql);
			}
		}
	}
	
	public void addSponsors(SponsorList sponsors) {
		SQLiteDatabase db = getReadableDatabase();
		for (int i = 0; i < sponsors.getResult().size(); i++) {
			Sponsor sponsor = sponsors.getResult().get(i);
			String values = sponsor.getId() + "," + sponsor.getWebsite() + "," + sponsor.getShortDesc() + "," +
							sponsor.getActive() + "," + sponsor.getSponsorLevel() + "," + sponsor.getLastModified();
			String sql = "INSERT OR REPLACE INTO " + SPONSOR_TABLE_NAME +
					" (id, website, id, short_desc, active, sponsor_level, last_modified) VALUES (" + values + ");";
			db.execSQL(sql);
		}
	}
	/*
	public void addStudios(StudioList studios) {
		SQLiteDatabase db = getReadableDatabase();
		for (int i = 0; i < studios.getResult().size(); i++) {
			Studio studio = studios.getResult().get(i);
			String values = artist.getId() + "," + artist.getLastModified() + "," + artist.getName() + "," + artist.getActive();
			String sql = "INSERT OR REPLACE INTO " + ARTIST_TABLE_NAME +
					" (id, last_modified, name, active) VALUES (" + values + ");";
			db.execSQL(sql);
		}
	}*/
}
