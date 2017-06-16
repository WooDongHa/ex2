package com.choa.ex2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject//type
	private NoticeService noticeService;
	
	@RequestMapping(value="test")
	public void test(){
		System.out.println(noticeService);
		noticeService.test();
	}
	
	//list
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue="1") Integer curPage)throws Exception{
		List<NoticeDTO> ar=noticeService.noticeList(curPage);
		model.addAttribute("list", ar);
	}
	
	//view
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void noticeView(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO=noticeService.noticeView(num);
		model.addAttribute("dto", noticeDTO);
	}
	
	//writeForm
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public void noticeWrite(Model model){
		model.addAttribute("path", "Write");
	}
	
	//write
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, /*Model model*/RedirectAttributes rd)throws Exception{
		int result=noticeService.noticeWrite(noticeDTO);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message",message);
		/*model.addAttribute("message",message);*/
		return /*"notice/result"*/"redirect:/notice/noticeList";
		
	}
	
	//updateForm
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public String noticeUpdate(Integer num, Model model)throws Exception{
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("dto",noticeDTO);
		model.addAttribute("path", "Update");
		return "notice/noticeWrite";
	}
	
	//update
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		int result=noticeService.noticeUpdate(noticeDTO);
		String message="FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
	}
	
	@RequestMapping(value="noticeDelete")
	public String noticeDelete(Integer num,RedirectAttributes rd)throws Exception{
		int result=noticeService.noticeDelete(num);
		String message = "FAIL";
		if(result>0){
			message="SUCCESS";
		}
		rd.addFlashAttribute("message",message);
		return "redirect:/notice/noticeList";
	}
	
}
