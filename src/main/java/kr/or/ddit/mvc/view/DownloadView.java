package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.attachfile.model.AttachVO;

public class DownloadView extends AbstractView {
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadView.class);
	

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AttachVO attachVo = (AttachVO )model.get("attachVo");

		logger.debug("profileImgDownload-view : " + attachVo);
				
			response.setHeader("Content-Disposition", "attachment; filename=\"" + attachVo.getFile_real_name() + "\"");
			response.setContentType("application/octet-stream");	
	
			FileInputStream fis = new FileInputStream(attachVo.getFile_name());
			ServletOutputStream sos = response.getOutputStream();
			
			byte[] buffer = new byte[512];
			
			while(fis.read(buffer) != -1) {
				sos.write(buffer);
			}
			
			fis.close();
			sos.flush();
			sos.close();
		
	}
}
