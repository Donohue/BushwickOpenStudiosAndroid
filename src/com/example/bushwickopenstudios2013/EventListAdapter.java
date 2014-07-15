package com.example.bushwickopenstudios2013;

import java.util.ArrayList;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter<Event> implements RequestListener<EventList> {
	private ArrayList<Event> events = new ArrayList<Event>(0);
	private LayoutInflater inflater;
	
	public EventListAdapter(Activity activity) {
		super(activity.getBaseContext(), android.R.layout.simple_list_item_1, new ArrayList<Event>(0));
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return events.size();
	}
	
	@Override
	public Event getItem(int i) {
		return events.get(i);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		EventHolder holder = null;
		
		if (row == null) {
			row = inflater.inflate(R.layout.event_row, parent, false);
			
			holder = new EventHolder();
			holder.event_name = (TextView)row.findViewById(R.id.event_name);
			holder.event_location = (TextView)row.findViewById(R.id.event_location);
			holder.event_time = (TextView)row.findViewById(R.id.event_time);
			holder.event_distance = (TextView)row.findViewById(R.id.event_distance);
			
			row.setTag(holder);
		}
		else {
			holder = (EventHolder)row.getTag();
		}
		
		Event event = events.get(position);
		holder.event_name.setText(event.getName());
		holder.event_location.setText(event.getVenue() + "");
		holder.event_time.setText("6PM - 9PM");
		holder.event_distance.setText("1000 ft");
		
		return row;
	}

	@Override
	public void onRequestFailure(SpiceException arg0) {
		
	}

	@Override
	public void onRequestSuccess(EventList arg0) {
		events = new ArrayList<Event>(arg0.getResult());
		notifyDataSetChanged();
	}
	
	static class EventHolder {
		TextView event_name;
		TextView event_location;
		TextView event_time;
		TextView event_distance;
	}

}
