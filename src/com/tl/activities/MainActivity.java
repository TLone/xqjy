package com.tl.activities;




import com.tl.connects.Login;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private EditText UserName;
	private EditText PassWord;
	private String tempValue;
	private TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        UserName=(EditText) this.findViewById(R.id.userName);
        PassWord=(EditText) this.findViewById(R.id.passWord);
    }
    //��½��ť����¼�
    public void login(View v){
    	String username = UserName.getText().toString();
    	String password = PassWord.getText().toString();
    	String result = Login.save(username,password);
    	if(result.equalsIgnoreCase("1"))
    		{
	    		Intent intent0= new Intent(MainActivity.this,user.class);
	    	 	startActivity(intent0);
	    	 	finish();
    		}
    	
    }
    
    //ע�ᰴť����¼�
    
    
    //�οͽ��水ť����¼�
    
    

    
    
    
    
    
}