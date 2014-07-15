package com.example.bushwickopenstudios2013;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MessageActivity extends Activity {
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.web_layout);
		
		WebView webView = (WebView)findViewById(R.id.webview);
		webView.setWebViewClient(new WebClient());
		webView.loadUrl("http://artsinbushwick.com");
	}
	
	public class WebClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView webView, String url) {
			return false;
		}
	}
}
