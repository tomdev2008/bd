package com.changhong.bd.social.wechat.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.changhong.bd.social.wechat.message.out.Article;
import com.changhong.bd.social.wechat.message.out.BaseOutMessage;
import com.changhong.bd.social.wechat.message.out.MusicOutMessage;
import com.changhong.bd.social.wechat.message.out.NewsOutMessage;
import com.changhong.bd.social.wechat.message.out.TextOutMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @author QiYao  yao.qi@changhong.com
 * @date 2014年5月6日
 * @version 1.0
 * @description : xml parse工具类
 */
@Component
public class OutMessageXmlParser {

	private static Logger logger = LoggerFactory.getLogger(OutMessageXmlParser.class);

	/**
	 * 将数据转为Map
	 * @param inputStream
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public Map<String,String> parseXml(InputStream inputStream) throws DocumentException, IOException{
		String isString = IOUtils.toString(inputStream, "UTF-8");
		logger.info(isString);
		
		Map<String, String> map = new HashMap<String, String>();
//		SAXReader reader = new SAXReader();
//		reader.read(inputStream);
		Document document = DocumentHelper.parseText(isString);
		Element root = document.getRootElement();
		
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();		
		inputStream = null;
		return map;
	}
	public String outMessageToXml(BaseOutMessage msg){
		if(msg instanceof TextOutMessage){
			return textMessageToXml((TextOutMessage)msg);
		}else if(msg instanceof MusicOutMessage){
			return musicMessageToXml((MusicOutMessage)msg);
		}else if(msg instanceof NewsOutMessage){
			return newsMessageToXml((NewsOutMessage)msg);
		}else{
			RuntimeException e = new RuntimeException("can't find out message type");
			throw e;
		}
	}
	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage 文本消息对象
	 * @return xml
	 */
	public String textMessageToXml(TextOutMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param musicMessage 音乐消息对象
	 * @return xml
	 */
	public String musicMessageToXml(MusicOutMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param newsMessage 图文消息对象
	 * @return xml
	 */
	public String newsMessageToXml(NewsOutMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 */
	private XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						//logger.info("xstream write:"+text);
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
