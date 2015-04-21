package com.tl.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class add extends Activity {
	private static final String[] m={"ѧϰ","��ҵ","��Ƹ","�������","����"};
    private EditText view ;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
         
        view = (EditText) findViewById(R.id.spinnerText);
        spinner = (Spinner) findViewById(R.id.Spinner01);
        //����ѡ������ArrayAdapter��������
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,m);
         
        //���������б�ķ��
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         
        //��adapter ��ӵ�spinner��
        spinner.setAdapter(adapter);
         
        //����¼�Spinner�¼�����  
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());
         
        //����Ĭ��ֵ
        spinner.setVisibility(View.VISIBLE);
         
    }
     
    //ʹ��������ʽ����
    class SpinnerSelectedListener implements OnItemSelectedListener{
 
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                long arg3) {
        	if(m[arg2].toString().equalsIgnoreCase("����"))
        		view.setText("");
        	else
        		view.setText("���Ѫ���ǣ�"+m[arg2]);
        }
 
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}
