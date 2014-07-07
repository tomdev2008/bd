package com.changhong.bd.network.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.changhong.bd.network.service.api.NetworkService;
import com.changhong.bd.network.trustmanager.AllX509TrustManager;

import net.sf.json.JSONObject;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月8日
 * @version 1.0
 * @description : 
 */
@Service("networkService")
public class NetworkServiceImpl implements NetworkService {
	private Logger logger = LoggerFactory.getLogger(NetworkServiceImpl.class);
	
	/**
	 * 网络请求
	 * @param requestUrl
	 * @param requestMethod
	 * @param outputStr
	 * @return
	 */
	@Override
	public JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new AllX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return jsonObject;
	}

	@Override
	public String httpsPost(String url, Map<String, String> values, String postData) {
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
            String is = null;
            if (httpEntity != null) {  
                is = EntityUtils.toString(httpEntity, "UTF-8"); 
            }  
            //释放资源  
            closeableHttpClient.close(); 
            return is; 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        return null;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.network.service.api.NetworkService#httpRequest(java.lang.String, java.util.Map, java.lang.String)
	 */
	@Override
	public void httpRequest(String url, Map<String, String> map) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();  
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();  
        
        HttpRequest	method = new HttpRequest(url);
        
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
            String is = null;
            if (httpEntity != null) {  
                is = EntityUtils.toString(httpEntity, "UTF-8"); 
            }  
            //释放资源  
            closeableHttpClient.close(); 
            return is; 
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        
        return null;
	}
}
