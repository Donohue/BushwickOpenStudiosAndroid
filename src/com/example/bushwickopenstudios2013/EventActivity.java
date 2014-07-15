package com.example.bushwickopenstudios2013;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EventActivity extends Activity {
	private Event event;
	
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.event_layout);
		event = (Event)getIntent().getExtras().get("event");
		
		TextView event_name = (TextView)findViewById(R.id.event_name);
		TextView event_hours = (TextView)findViewById(R.id.event_hours);
		TextView event_short_desc = (TextView)findViewById(R.id.event_short_description);
		TextView event_long_desc = (TextView)findViewById(R.id.event_long_description);
		TextView event_address = (TextView)findViewById(R.id.event_address);
		event_name.setText(event.getName());
		event_hours.setText("7:00 PM - 9:00 PM");
		if (event.getShortDesc() != null)
			event_short_desc.setText(event.getShortDesc());
		if (event.getLongDesc() != null)
			event_long_desc.setText(event.getLongDesc());
		event_address.setText(event.getVenue());
		
	}
}
