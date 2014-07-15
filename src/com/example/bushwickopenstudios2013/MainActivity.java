package com.example.bushwickopenstudios2013;

import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity {
	private TabHost tHost;
	public SpiceManager spiceManager = new SpiceManager(JacksonSpringAndroidSpiceService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tHost = (TabHost) findViewById(android.R.id.tabhost);
        tHost.setup();
		
		/** Setting tabchangelistener for the tab */
		tHost.setOnTabChangedListener(new TabChangeListener(this));
		
        TabHost.TabSpec tSpecStudios = tHost.newTabSpec("studios");
        tSpecStudios.setIndicator("STUDIOS");
        tSpecStudios.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecStudios);
        
        TabHost.TabSpec tSpecEvents = tHost.newTabSpec("events");
        tSpecEvents.setIndicator("EVENTS");
        tSpecEvents.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecEvents);
        
        TabHost.TabSpec tSpecMap = tHost.newTabSpec("map");
        tSpecMap.setIndicator("MAP");
        tSpecMap.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecMap);
        
        TabHost.TabSpec tSpecMore = tHost.newTabSpec("more");
        tSpecMore.setIndicator("MORE");
        tSpecMore.setContent(new DummyTabContent(getBaseContext()));
        tHost.addTab(tSpecMore);    
    }
    
	@Override
	protected void onStart() {
		super.onStart();
		spiceManager.start(this);
	}
	
	@Override
	protected void onStop() {
		spiceManager.shouldStop();
		super.onStop();
	}
	
}
