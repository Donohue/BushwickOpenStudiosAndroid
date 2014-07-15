package com.example.bushwickopenstudios2013;
import com.octo.android.robospice.persistence.DurationInMillis;

import android.widget.TabHost;

public class TabChangeListener implements TabHost.OnTabChangeListener {
	private MainActivity activity;
	public static final String ep = "http://whispering-tundra-2412.herokuapp.com/";
	public static final String JSON_CACHE_KEY = "echo";
	private EventListAdapter event_adapter;
	
	public TabChangeListener(MainActivity a) {
		super();
		activity = a;
		event_adapter = new EventListAdapter(activity);
		activity.spiceManager.execute(new ArtistRequest(ep), JSON_CACHE_KEY, DurationInMillis.ALWAYS, new ArtistListener());
		activity.spiceManager.execute(new EventRequest(ep), JSON_CACHE_KEY, DurationInMillis.NEVER, event_adapter);
		activity.spiceManager.execute(new SponsorRequest(ep), JSON_CACHE_KEY, DurationInMillis.ALWAYS, new SponsorListener());
		activity.spiceManager.execute(new StudioRequest(ep), JSON_CACHE_KEY, DurationInMillis.ALWAYS, new StudioListener());
	}
	
	@Override
	public void onTabChanged(String tabId) {
		android.support.v4.app.FragmentManager fm = activity.getSupportFragmentManager();
		StudioFragment studioFragment = (StudioFragment) fm.findFragmentByTag("studios");
		EventFragment eventFragment = (EventFragment) fm.findFragmentByTag("events");
		BOSMapFragment mapFragment = (BOSMapFragment) fm.findFragmentByTag("map");
		MoreFragment moreFragment = (MoreFragment) fm.findFragmentByTag("more");
		android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
		
		if (studioFragment != null)
			ft.detach(studioFragment);
		
		if (eventFragment != null)
			ft.detach(eventFragment);
		
		if (mapFragment != null)
			ft.detach(mapFragment);
		
		if (moreFragment != null)
			ft.detach(moreFragment);
		
		if(tabId.equalsIgnoreCase("studios")){
			
			if(studioFragment == null){		
				/** Create StudioFragment and adding to fragmenttransaction */
				ft.add(R.id.realtabcontent, new StudioFragment(), "studios");						
			}else{
				/** Bring to the front, if already exists in the fragmenttransaction */
				ft.attach(studioFragment);						
			}
			
		}
		else if (tabId.equalsIgnoreCase("events")) {
			if(eventFragment == null){
				ft.add(R.id.realtabcontent, new EventFragment(event_adapter), "events");
			}else{
				/** Bring to the front, if already exists in the fragmenttransaction */
				ft.attach(eventFragment);						
			}
		}
		else if (tabId.equalsIgnoreCase("map")) {
			if (mapFragment == null) {
				ft.add(R.id.realtabcontent, new BOSMapFragment(), "map");
			}
			else {
				ft.attach(mapFragment);
			}
		}
		else if (tabId.equalsIgnoreCase("more")) {
			if (moreFragment == null) {
				ft.add(R.id.realtabcontent, new MoreFragment(), "more");
			}
			else {
				ft.attach(moreFragment);
			}
		}
		ft.commit();
	}

}
