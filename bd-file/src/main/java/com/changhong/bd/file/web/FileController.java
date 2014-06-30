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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.changhong.bd.file.domain.FileDto;
import com.changhong.bd.file.service.api.FileService;

/**
 * @author QiYao yao.qi@changhong.com
 * @date 2014年6月24日
 * @version 1.0
 * @description : 文件控制器
 */
@Controller
@RequestMapping(value = "/file")
public class FileController {

	@Autowired
	private FileService fileService;

	/**
	 * 下载文件
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/{fileId}", method=RequestMethod.GET)
	public ModelAndView download(
		@PathVariable(value="fileId") String fileId,
		HttpServletRequest request,
		HttpServletResponse response) throws IOException{
			FileDto dto = this.fileService.query(fileId);
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
			
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			
			try {
				Long fileLength = dto.getSize();
				response.setContentType("application/x-msdownload;");
				String fileName = (dto.getId()+"."+dto.getSuffix());
				
				String header = "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1");
				response.setHeader("Content-disposition", header);
				
				response.setHeader("Content-Length", String.valueOf(fileLength));
				bis = new BufferedInputStream(dto.getInputStream());
				bos = new BufferedOutputStream(response.getOutputStream());
				byte[] buff = new byte[2048];
				int bytesRead;
				while(-1 != (bytesRead = bis.read(buff, 0, buff.length))){
					bos.write(buff, 0, bytesRead);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(bis != null)
					bis.close();
				if(bos != null)
					bos.close();
			}
				
			return null;
	}
}
 