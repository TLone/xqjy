package com.tl.daos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.tl.beans.Person;


public class PersonService {
	public List<Person> getitems(String url){
		List<Person> persons = new ArrayList<Person>();
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByTag("div");
		   	   
	     	for (Element adiv : content) {
	     		Elements links = adiv.getElementsByTag("a");
		   	    String link = links.attr("href");
		   	    String title = links.text();
		   	    persons.add( new Person(title,link));
	     	}	
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	
		return persons;
		
	}

}
