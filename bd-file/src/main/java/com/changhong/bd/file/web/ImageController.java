package com.changhong.bd.file.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.file.domain.FileDto;
import com.changhong.bd.file.service.api.FileService;

/**
 * 图片显示控制器
 * 
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月30日
 * @description 这个控制器只用于类型的及时显示
 *
 */
@Controller
@RequestMapping(value = "/file/image")
public class ImageController {

	@Autowired
	private FileService fileService;

	/**
	 * 显示图片
	 * 
	 * @param fileId
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/{fileId}.jpg")
	public ModelAndView show(@PathVariable(value="fileId") String fileId,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		FileDto dto = this.fileService.queryFile(fileId);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			Long fileLength = dto.getSize();
			response.setContentType("image/gif");
			request.setCharacterEncoding("UTF-8");
			
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(dto.getInputStream());
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while(-1 != (bytesRead = bis.read(buff, 0, buff.length))){
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bos != null)
				bos.close();
			if(bis != null)
				bis.close();
		}
			
		return null;
	}
}
