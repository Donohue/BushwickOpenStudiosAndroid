package com.example.bushwickopenstudios2013;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class EventListener implements RequestListener<EventList> {
	public EventListener() {
	}

	@Override
	public void onRequestFailure(SpiceException arg0) {
		
	}

	@Override
	public void onRequestSuccess(EventList arg0) {
	}

}
