package com.tl.connects;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Login {

	public static String save(String title, String length) {
		// TODO Auto-generated method stub
		String path="http://192.168.253.8/tg/login.php";
		Map<String,String> params = new HashMap<String,String>();
		params.put("username", title);
		params.put("password", length);
		try {
			return sendGETRequest(path,params,"UTF-8");//get方法请求数据
			//return sendPOSTRequest(path,params,"UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}

	private static boolean sendPOSTRequest(String path,
			Map<String, String> params, String encoding) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder data=new StringBuilder();
		if(params !=null && !params.isEmpty()){
			for(Map.Entry<String, String> entry : params.entrySet()){
				data.append(entry.getKey()).append("=");
				data.append(URLEncoder.encode(entry.getValue(), encoding));
				data.append("&");
			}
			data.deleteCharAt(data.length() - 1);
		}
		byte[] entity= data.toString().getBytes();
		HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();

		conn.setConnectTimeout(50000);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(data.length()));
		OutputStream outStream=conn.getOutputStream();
		outStream.write(entity);
		if(conn.getResponseCode() == 200){
			return true;
		}
		return false;
	}

	private static String sendGETRequest(String path,Map<String, String> params,String encoding) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder url=new StringBuilder(path);
		url.append("?");
		for(Map.Entry<String, String> entry : params.entrySet()){
			url.append(entry.getKey()).append("=");
			url.append(URLEncoder.encode(entry.getValue(), encoding));
			url.append("&");
		}
		url.deleteCharAt(url.length() - 1);
		
		HttpGet httpRequest = new HttpGet(url.toString());  
        try  
        {  
          /*发送请求并等待响应*/  
          HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);  
          /*若状态码为200 ok*/  
          if(httpResponse.getStatusLine().getStatusCode() == 200)   
          {  
            /*读*/  
            String strResult = EntityUtils.toString(httpResponse.getEntity()); 
            
            	return strResult;
            /*去没有用的字符*/  
           // strResult = eregi_replace("(\r\n|\r|\n|\n\r)","",strResult);  
           // mTextView1.setText(strResult);  
          }  
        } catch (Exception e)  
        {   
           // mTextView1.setText(e.getMessage().toString());  
            e.printStackTrace();   
          }   
		
		/*
		HttpURLConnection conn = (HttpURLConnection) new URL(url.toString()).openConnection();
		conn.setConnectTimeout(50000);
		conn.setRequestMethod("GET");
		if(conn.getResponseCode() == 200){
			
			String strResult = EntityUtils.toString(httpResponse.getEntity());  
            /*去没有用的字符 
            strResult = eregi_replace("(\r\n|\r|\n|\n\r)","",strResult);  
            mTextView1.setText(strResult); 
			
			return true;
		}*/ 
		return "false";
	}

}
