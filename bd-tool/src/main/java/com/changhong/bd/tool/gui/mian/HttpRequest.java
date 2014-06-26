package com.changhong.bd.tool.gui.mian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpRequest {

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			Map<String, List<String>> map = connection.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("Send GET failed! " + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String httpPost(String url, Map<String,String> values, String postData){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
        
        HttpPost httpPost = new HttpPost(url);
        
        //httpPost.setConfig(DEFAULT);  
        // 创建参数队列  
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        
        if(null!=values){
        	for(String key : values.keySet()){
        		formparams.add(new BasicNameValuePair(key, values.get(key))); 
        	}
        }
         
        HttpEntity entity;  
        try {  
            entity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            entity = new StringEntity(postData, ContentType.APPLICATION_JSON);
            
            httpPost.setEntity(entity);  
            HttpResponse httpResponse;  
            //post请求  
            httpResponse = closeableHttpClient.execute(httpPost);  
   
            //getEntity()  
            HttpEntity httpEntity = httpResponse.getEntity();  
            String res = null;
            if (httpEntity != null) {  
                //打印响应内容  
            	res = EntityUtils.toString(httpEntity, "UTF-8");
                System.out.println("response:" + res);  
            }  
            //释放资源  
            closeableHttpClient.close(); 
            return res; 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        return null;
	}
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			result = "";
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("Send POST failed! " + e);
			e.printStackTrace();
		}
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}