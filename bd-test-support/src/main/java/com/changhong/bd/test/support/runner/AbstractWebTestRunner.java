package com.changhong.bd.test.support.runner;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年6月3日
 * @version 1.0
 * @description : 
 */
@WebAppConfiguration
public abstract class AbstractWebTestRunner extends AbstractTestRunner{
	
	protected MockMvc mockMvc;
	
	@Autowired
	protected WebApplicationContext wac;

    @Autowired
    protected MockServletContext servletContext; // cached

    @Autowired
    protected MockHttpSession session;

    @Autowired
    protected MockHttpServletRequest request;

    @Autowired
    protected MockHttpServletResponse response;

    @Autowired
    protected ServletWebRequest webRequest;
	@Before
	public void buildMvc(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
}
