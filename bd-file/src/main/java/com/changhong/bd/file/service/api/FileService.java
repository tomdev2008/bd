package com.changhong.bd.file.service.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.changhong.bd.file.domain.FileDto;
import com.changhong.bd.file.entity.FileEntity;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 
 */
public interface FileService {

	/**
	 * 通过Id查询文件
	 * @param fileId
	 * @return
	 */
	public FileDto query(String fileId);

	/**
	 * 通过ID查询文件和文件的内容
	 * @param fileId
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	public FileDto queryFile(String fileId) throws FileNotFoundException, IOException;
	
	/**
	 * 新增文件
	 * @param e
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public FileDto add(FileEntity e, InputStream is) throws IOException;

	/**通过ID删除文件
	 * @param id
	 */
	public void delete(String id);
	
}
