package com.tl.activities;

import com.tl.connects.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class user extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.user);
	 }
	 
	 public void login1(View v){
	    	
		    		Intent intent0= new Intent(user.this,add.class);
		    	 	startActivity(intent0);	    		
	    	
	    }
}
