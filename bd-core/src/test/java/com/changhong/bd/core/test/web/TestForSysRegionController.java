package com.changhong.bd.core.test.web;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.changhong.bd.core.web.SysRegionController;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月26日
 * @version 1.0
 * @description : 
 */
@WebAppConfiguration
@ContextConfiguration(locations={
	"classpath*:/applicationContext.xml",
	"classpath*:/spring-mvc.xml" //only for test
})
public class TestForSysRegionController extends AbstractJUnit4SpringContextTests{
	
	private static Logger logger = LoggerFactory.getLogger(TestForSysRegionController.class);
	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private SysRegionController sysRegionController;
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(sysRegionController).build();
    }

    /**
     * 测试获取地区json树数据
     * @throws Exception
     */
    @Test
    public void getAccount() throws Exception {
    	ResultActions ra = this.mockMvc.perform(MockMvcRequestBuilders.get("/sys/region").accept(MediaType.parseMediaType("application/json;charset=UTF-8")));
    	
    	ra.andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    	
    	MvcResult mr = ra.andReturn();
		String result = mr.getResponse().getContentAsString();
		logger.info(result);
    }
}
