package com.tl.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class message extends Activity{
	private WebView messageView;
	private String url;

	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        Bundle bundle=getIntent().getExtras();
	        url=bundle.getString("url");
	        
	        messageView=(WebView)this.findViewById(R.id.messagewebView);
	        messageView.loadUrl(url);
	 }
}
