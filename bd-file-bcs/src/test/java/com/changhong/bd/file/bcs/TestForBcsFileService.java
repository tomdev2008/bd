package com.changhong.bd.file.bcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.changhong.bd.file.domain.FileDto;
import com.changhong.bd.file.entity.FileEntity;
import com.changhong.bd.file.service.api.FileService;
import com.changhong.bd.test.support.runner.AbstractTestRunner;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月30日
 * @description
 *
 */
public class TestForBcsFileService extends AbstractTestRunner{

	@Autowired
	private FileService fileService;
	
	private FileDto dto = null;
	
	@Before
	public void testAdd() throws IOException{
		File file = new File("E:/temp/upload/20140630220200.png");
		FileInputStream is = new FileInputStream(file);
		FileEntity e = new FileEntity();
		e.setName("Tony");
		e.setOwnerId("tony");
		Long size = Long.valueOf(is.available() + "" );
		e.setSize(size);
		e.setSuffix("jpg");
		e.setType("image/gif");
		dto = this.fileService.add(e , is );
		out(dto);
	}
	@Test
	public void testQuery() throws FileNotFoundException{
		dto = this.fileService.queryFile(dto.getId());
		Assert.notNull(dto.getInputStream());
	}

	@After
	public void testDetele(){
		if(null!=dto){
			this.fileService.delete(dto.getId());
		}
	}
}
