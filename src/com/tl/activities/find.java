package com.tl.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tl.beans.Person;
import com.tl.daos.PersonService;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class find extends Activity{
	 private ListView listView;
	    private PersonService personService;
	    private String url;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        Bundle bundle=getIntent().getExtras();
	        url=bundle.getString("url");
	        
	        personService = new PersonService();
	        listView=(ListView) this.findViewById(R.id.listView);
	        //show();
	        listView.setOnItemClickListener(new ItemClickListener());
	        show();
	    }
	    
	    private final class ItemClickListener implements OnItemClickListener{

			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				ListView lView = (ListView)parent;
				//Person person = (Person)lView.getItemAtPosition(position);
				HashMap<String, Object> hs=(HashMap<String, Object>) lView.getItemAtPosition(position);
				Toast.makeText(getApplicationContext(),hs.get("link").toString(), 1).show();
			}
	    	
	    }

		private void show() {
			// TODO Auto-generated method stub
			List<Person> persons=personService.getitems(url);
			List<HashMap<String, Object>> data =new ArrayList<HashMap<String, Object>>();
			for(Person person : persons){
				HashMap<String, Object> item = new HashMap<String, Object>();
				item.put("title",person.getTitle());
				item.put("link",person.getLink());
				data.add(item);
			}
			SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item,new String[]{"title","link"},new int[]{R.id.title1,R.id.link1} );
			listView.setAdapter(adapter);
		}
}
