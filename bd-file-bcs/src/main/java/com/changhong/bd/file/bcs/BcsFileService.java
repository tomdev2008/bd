package com.changhong.bd.file.bcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.GetObjectRequest;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.baidu.inf.iis.bcs.response.BaiduBCSResponse;
import com.changhong.bd.bae.service.api.BaeService;
import com.changhong.bd.core.utils.PropertyUtils;
import com.changhong.bd.file.service.api.FileService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 百度文件云服务
 */
@Service("bcsFileService")
public class BcsFileService implements FileService{

	@Autowired
	private BaeService baeService;
	
	private static final Logger logger = LoggerFactory.getLogger(BcsFileService.class);
	// ----------------------------------------
	public static String host = "bcs.duapp.com";
	public static String bucket = null;
	public static BaiduBCS baiduBCS = null;
	// ----------------------------------------
	static String object = "/first-object";
	static File destFile = new File("test");

	@PostConstruct
	public void getBcs(){
		String ak = this.baeService.queryAk();
		String sk = this.baeService.querySk();
		bucket = PropertyUtils.getAppId();
		
		BCSCredentials credentials = new BCSCredentials(ak, sk);
		baiduBCS = new BaiduBCS(credentials, host);

		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
	}
	
	public ObjectMetadata getObjectMetadata(BaiduBCS baiduBCS) {
		ObjectMetadata objectMetadata = baiduBCS.getObjectMetadata(bucket, object).getResult();
		return objectMetadata;
	}

	public void getObjectWithDestFile(BaiduBCS baiduBCS, File file) {
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, object);
		baiduBCS.getObject(getObjectRequest, file);
	}

	public void putObjectByFile(BaiduBCS baiduBCS, File file) {
		PutObjectRequest request = new PutObjectRequest(bucket, object, file);
		ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setContentType("text/html");
		request.setMetadata(metadata);
		BaiduBCSResponse<ObjectMetadata> response = baiduBCS.putObject(request);
		ObjectMetadata objectMetadata = response.getResult();
		logger.info(objectMetadata.toString());
	}

	public static void putObjectByInputStream(BaiduBCS baiduBCS, File file) throws FileNotFoundException {
		InputStream fileContent = new FileInputStream(file);
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType("text/html");
		objectMetadata.setContentLength(file.length());
		PutObjectRequest request = new PutObjectRequest(bucket, object, fileContent, objectMetadata);
		ObjectMetadata result = baiduBCS.putObject(request).getResult();
		logger.info(result.toString());
	}

}
