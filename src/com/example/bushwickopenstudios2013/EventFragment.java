package com.example.bushwickopenstudios2013;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class EventFragment extends ListFragment {
	EventListAdapter adapter;
	
	public EventFragment(EventListAdapter a) {
		super();
		adapter = a;
	}
    	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Event event = adapter.getItem(position);
		if (event.getShortDesc() == null)
			System.out.println("GET SHORT DESC NULLO");
		else
			System.out.println(event.getShortDesc());
		Intent i = new Intent(getActivity(), EventActivity.class);
		i.putExtra("event", event);
		getActivity().startActivity(i);
	}
}
