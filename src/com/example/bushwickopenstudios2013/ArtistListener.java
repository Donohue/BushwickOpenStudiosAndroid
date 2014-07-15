package com.example.bushwickopenstudios2013;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

public class ArtistListener implements RequestListener<ArtistList> {
	
	public ArtistListener() {
	}

	@Override
	public void onRequestFailure(SpiceException arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRequestSuccess(ArtistList arg0) {
	}

}
