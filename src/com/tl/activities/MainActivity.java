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
    //登陆按钮点击事件
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
    
    //注册按钮点击事件
    
    
    //游客界面按钮点击事件
    
    

    
    
    
    
    
}