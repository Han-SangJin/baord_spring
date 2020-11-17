package kr.or.ddit.board.web;


import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.attachfile.model.AttachVO;
import kr.or.ddit.attachfile.service.AttachServiceI;

@MultipartConfig
@Controller
@RequestMapping("/file")
public class ProfileDownloadController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileDownloadController.class);
	
	@Resource(name="attachService")
	AttachServiceI attachService;
	
	@RequestMapping(path="/profileDownload", method = {RequestMethod.GET, RequestMethod.POST})
	public String getView(String file_seq1, Model model) {
		
		logger.debug("profileDownload-Controller.getView() : " + file_seq1);
		System.out.println("file_seq1" + file_seq1);
		AttachVO attachVo= attachService.selectAttach(Integer.parseInt(file_seq1));
		logger.debug("memberVo memberVo memberVo : " + file_seq1);
		
		model.addAttribute("attachVo", attachVo);
		return "DownloadView";	
	}	
	 
}
