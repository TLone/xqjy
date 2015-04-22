package com.tl.activities;

import com.tl.connects.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class tofind extends Activity{
	EditText ftype;
	EditText fhead;
	EditText fskill;
	private String type;
	private String head;
	private String skill;
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	  }
	  
	  public void login(View v){
		  ftype=(EditText)this.findViewById(R.id.findSpinnerText);
		  fhead=(EditText)this.findViewById(R.id.findHead);
		  fskill=(EditText)this.findViewById(R.id.findSkill);
		  type=ftype.getText().toString();
		  head=fhead.getText().toString();
		  skill=fskill.getText().toString();
		  String path="http://192.168.253.8/tg/find.php?";
		  StringBuilder url=new StringBuilder(path);
		  url.append("type=").append(type);
		  url.append("&head=").append(head);
		  url.append("&skill=").append(skill);
		  Intent intent0= new Intent(tofind.this,find.class);
		  Bundle bundle=new Bundle();
		  bundle.putString("url", url.toString());
		  intent0.putExtras(bundle); 
		  startActivity(intent0);

	    	
	    }
	       
}
