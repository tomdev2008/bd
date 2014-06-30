package com.changhong.bd.file.bcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baidu.inf.iis.bcs.BaiduBCS;
import com.baidu.inf.iis.bcs.auth.BCSCredentials;
import com.baidu.inf.iis.bcs.model.Empty;
import com.baidu.inf.iis.bcs.model.ObjectMetadata;
import com.baidu.inf.iis.bcs.request.GetObjectRequest;
import com.baidu.inf.iis.bcs.request.PutObjectRequest;
import com.changhong.bd.bae.service.api.BaeService;
import com.changhong.bd.core.utils.PropertyUtils;
import com.changhong.bd.file.dao.api.FileDao;
import com.changhong.bd.file.domain.FileDto;
import com.changhong.bd.file.entity.FileEntity;
import com.changhong.bd.file.service.api.FileService;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 百度文件云服务
 */
@Service("bcsFileService")
@Transactional(readOnly=true)
public class BcsFileService implements FileService{

	@Autowired
	private BaeService baeService;
	
	@Autowired
	private FileDao fileDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BcsFileService.class);
	// ----------------------------------------
	public static String host = "bcs.duapp.com";
	public static String bucket = null;
	public static BaiduBCS baiduBCS = null;
	// ----------------------------------------

	@PostConstruct
	public void getBcs(){
		String ak = this.baeService.queryAk();
		String sk = this.baeService.querySk();
		bucket = PropertyUtils.getAppId();
		
		BCSCredentials credentials = new BCSCredentials(ak, sk);
		baiduBCS = new BaiduBCS(credentials, host);

		baiduBCS.setDefaultEncoding("UTF-8"); // Default UTF-8
	}
	
	/**
	 * 下载文件
	 * @param baiduBCS
	 * @param id
	 * @return
	 * @throws FileNotFoundException 
	 */
	public InputStream getObject(BaiduBCS baiduBCS, String id) throws FileNotFoundException {
		id = "/" + id;
		GetObjectRequest getObjectRequest = new GetObjectRequest(bucket, id);
		File file = new File("tmp");
		baiduBCS.getObject(getObjectRequest, file);
		return new FileInputStream(file);
	}

	public void putObjectByFile(BaiduBCS baiduBCS, String id, File file) throws IOException {
		this.putObjectByInputStream(baiduBCS, id, new FileInputStream(file));
	}

	public void putObjectByInputStream(BaiduBCS baiduBCS, String id, InputStream is) throws IOException {
		id = "/" + id;
		
		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentType("text/html");
		objectMetadata.setContentLength(is.available());
		PutObjectRequest request = new PutObjectRequest(bucket, id, is, objectMetadata);
		ObjectMetadata result = baiduBCS.putObject(request).getResult();
		logger.info(result.toString());
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.file.service.api.FileService#query(java.lang.String)
	 */
	@Override
	public FileDto query(String fileId) {
		FileEntity e = this.fileDao.query(fileId);
		FileDto dto = new FileDto(e);
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.file.service.api.FileService#queryFile(java.lang.String)
	 */
	@Override
	public FileDto queryFile(String fileId) throws FileNotFoundException {

		FileEntity e = this.fileDao.query(fileId);
		InputStream is = this.getObject(baiduBCS, e.getId());
		FileDto dto = new FileDto(e, is);
		
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.file.service.api.FileService#add(com.changhong.bd.file.entity.FileEntity, java.io.InputStream)
	 */
	@Override
	@Transactional(readOnly=false)
	public FileDto add(FileEntity e, InputStream is) throws IOException {
		e = this.fileDao.save(e);
		String id = e.getId();
		this.putObjectByInputStream(baiduBCS, id, is);
		FileDto dto = new FileDto(e);
		return dto;
	}

	/* (non-Javadoc)
	 * @see com.changhong.bd.file.service.api.FileService#delete(java.lang.String)
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(String id) {
		String object="/"+ id;
		Empty result = baiduBCS.deleteObject(bucket, object).getResult();
		this.fileDao.deleteByKey(id);
		logger.debug(result.toString());
	}

}
