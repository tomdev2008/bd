package com.changhong.bd.core.test.resp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.changhong.bd.core.resp.JsonData;
import com.changhong.bd.core.resp.JsonMessage;
import com.changhong.bd.core.resp.JsonPageData;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月13日
 * @version 1.0
 * @description : resp返回对象单元测试
 */
public class TestForResp {

	private static Logger logger = LoggerFactory.getLogger(TestForResp.class);
	
	private ObjectMapper om = new ObjectMapper();
	
	/**
	 * 测试json信息数据
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Test
	public void testJsonMessage() throws JsonGenerationException, JsonMappingException, IOException{
		JsonMessage msa = new JsonMessage();
		msa.setStatus(400);
		msa.setMessage("信息a");
		JsonMessage msb = new JsonMessage(200, "信息");
		
		String sa = om.writeValueAsString(msa);
		String sb = om.writeValueAsString(msb);
		
		logger.info(sa);
		logger.info(sb);
	}
	/**
	 * 测试JSON 非分页数据
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test
	public void testJsonData() throws JsonGenerationException, JsonMappingException, IOException{
		Long count = 700L;
		List<String> list = new ArrayList<String>();
		JsonData<String> jd = new JsonData<String>(count, list);
		
		jd.setCount(count);
		jd.setDatas(list);
		
		String s = om.writeValueAsString(jd);
		logger.info(s);
	}
	/**
	 * 测试 json分页数据
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	@Test
	public void testJsonPageData() throws JsonGenerationException, JsonMappingException, IOException{
		Integer pageNo = 1;
		Integer pageSize = 10;
		Long count = 900L;
		List<String> list = new ArrayList<String>();
		
		JsonPageData<String> jpd = new JsonPageData<String>(pageNo, pageSize, count, list);
		
		jpd.setPageNo(pageNo);
		jpd.setPageSize(pageSize);
		jpd.setCount(count);
		jpd.setDatas(list);
		
		String s = om.writeValueAsString(jpd);
		
		logger.info(s);
	}
}
